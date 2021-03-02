package com.github.huifer.domain.model.error;

/**
 * @author huifer
 */
public enum ErrorEnums implements ErrorCode {
  /**
   * 转换异常
   */
  CONVERT_ERROR(1001, "转换异常"),
  ;

  private final int errCode;
  private final String errDesc;

  ErrorEnums(int errCode, String errDesc) {
    this.errCode = errCode;
    this.errDesc = errDesc;
  }

  @Override
  public int getErrCode() {
    return errCode;
  }

  @Override
  public String getErrDesc() {
    return errDesc;
  }
}
