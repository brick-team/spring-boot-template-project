package com.github.huifer.validator;

/**
 * 验证接口
 */
public interface ValidatorApi<T> {

  void valid(T t);
}
