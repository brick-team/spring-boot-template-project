package com.github.huifer.domain.model.error;

public interface ErrorCode {

  /**
   * error code
   *
   * @return error code
   */
  int getErrCode();

  /**
   * 异常描述
   *
   * @return 异常描述
   */
  String getErrDesc();
}
