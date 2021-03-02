package com.github.huifer.cache.config.serializer;

import com.google.gson.Gson;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.springframework.data.redis.serializer.RedisSerializer;

public class GsonRedisSerializer<T> implements RedisSerializer<T> {

  public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
  private final Class<T> clazz;
  Gson gson = new Gson();

  public GsonRedisSerializer(Class<T> clazz) {

    this.clazz = clazz;
  }

  @Override
  public byte[] serialize(T t) {
    if (t == null) {
      return new byte[0];
    }
    return gson.toJson(t).getBytes(DEFAULT_CHARSET);
  }

  @Override
  public T deserialize(byte[] bytes) {
    if (bytes == null || bytes.length <= 0) {
      return null;
    }
    String str = new String(bytes, DEFAULT_CHARSET);

    return gson.fromJson(str, clazz);
  }
}
