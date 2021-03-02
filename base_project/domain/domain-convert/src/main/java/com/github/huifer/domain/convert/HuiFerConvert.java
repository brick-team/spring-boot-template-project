package com.github.huifer.domain.convert;

/**
 * 转换接口
 *
 * @param <S> 源对象类型
 * @param <T> 目标对象类型
 * @author huifer
 */
public interface HuiFerConvert<S, T> {

  /**
   * 对象转换接口
   *
   * @param s 源对象实体
   * @return 目标对象实体
   */
  T convert(S s);

}
