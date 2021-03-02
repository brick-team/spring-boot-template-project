#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.config;

import ${package}.${parentArtifactId}.config.serializer.GsonRedisSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author huifer
 */
@Configuration
public class HuiFerTemplateRedisConfiguration {

  @Bean(name = "gsonRedisSerializer")
  public RedisSerializer gsonRedisSerializer() {
    return new GsonRedisSerializer(Object.class);
  }


  @Bean
  public RedisTemplate<String, String> redisTemplate(
      RedisConnectionFactory factory, RedisSerializer fastJson2JsonRedisSerializer,
      @Qualifier("gsonRedisSerializer") RedisSerializer gsonRedisSerializer
  ) {
    StringRedisTemplate result = new StringRedisTemplate(factory);
    result.setValueSerializer(gsonRedisSerializer);
    result.setHashValueSerializer(gsonRedisSerializer);

    result.setValueSerializer(fastJson2JsonRedisSerializer);
    result.setHashValueSerializer(fastJson2JsonRedisSerializer);

    result.setKeySerializer(new StringRedisSerializer());
    result.afterPropertiesSet();
    return result;
  }
}
