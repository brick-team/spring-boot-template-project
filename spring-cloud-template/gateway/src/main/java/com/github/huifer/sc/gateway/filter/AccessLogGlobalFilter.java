package com.github.huifer.sc.gateway.filter;

import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AccessLogGlobalFilter implements GlobalFilter, Ordered {

  private static final Logger log = LoggerFactory.getLogger(AccessLogGlobalFilter.class);
  private static final String REQUEST_PREFIX = "Request Info [ ";

  private static final String REQUEST_TAIL = " ]";

  private static final String RESPONSE_PREFIX = "Response Info [ ";

  private static final String RESPONSE_TAIL = " ]";

  private final StringBuilder normalMsg = new StringBuilder();

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    RecorderServerHttpRequestDecorator requestDecorator = new RecorderServerHttpRequestDecorator(
        request);
    InetSocketAddress address = requestDecorator.getRemoteAddress();
    HttpMethod method = requestDecorator.getMethod();
    URI url = requestDecorator.getURI();
    HttpHeaders headers = requestDecorator.getHeaders();
    Flux<DataBuffer> body = requestDecorator.getBody();
    //读取requestBody传参
    AtomicReference<String> requestBody = new AtomicReference<>("");
    body.subscribe(buffer -> {
      CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
      requestBody.set(charBuffer.toString());
    });
    String requestParams = requestBody.get();
    normalMsg.append(REQUEST_PREFIX);
    normalMsg.append(";header=").append(headers);
    normalMsg.append(";params=").append(requestParams);
    normalMsg.append(";address=").append(address.getHostName() + address.getPort());
    normalMsg.append(";method=").append(method.name());
    normalMsg.append(";url=").append(url.getPath());
    normalMsg.append(REQUEST_TAIL);

    ServerHttpResponse response = exchange.getResponse();

    DataBufferFactory bufferFactory = response.bufferFactory();
    normalMsg.append(RESPONSE_PREFIX);
    ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(response) {
      @Override
      public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
        if (body instanceof Flux) {
          Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
          return super.writeWith(fluxBody.map(dataBuffer -> {
            // probably should reuse buffers
            byte[] content = new byte[dataBuffer.readableByteCount()];
            dataBuffer.read(content);
            String responseResult = new String(content, StandardCharsets.UTF_8);
            normalMsg.append("status=").append(this.getStatusCode());
            normalMsg.append(";header=").append(this.getHeaders());
            normalMsg.append(";responseResult=").append(responseResult);
            normalMsg.append(RESPONSE_TAIL);
            log.info(normalMsg.toString());
            return bufferFactory.wrap(content);
          }));
        }
        return super.writeWith(body); // if body is not a flux. never got there.
      }
    };

    return chain
        .filter(exchange.mutate().request(requestDecorator).response(decoratedResponse).build());
  }

  @Override
  public int getOrder() {
    return -2;
  }

}