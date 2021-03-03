package com.github.huifer.sc.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class GatewayApp {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApp.class, args);
  }

  @Value("${spring.cloud.sentinel.transport.dashboard}")
  String value;

  @Bean
  ApplicationRunner applicationRunner(){
    return args -> {
      System.out.println(value);

    };
  }
}
