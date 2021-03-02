package com.github.huifer.domain.model.error;

import com.github.huifer.domain.model.res.ResultVO;

public class ServiceException extends RuntimeException {

  private final int code;
  private final String errorMessage;

  public ServiceException(String errorMessage) {
    this(ResultVO.FAILED, errorMessage);
  }

  public ServiceException(Throwable throwable) {
    this(ResultVO.FAILED, throwable.getMessage());
  }

  public ServiceException(int code, String errorMessage) {
    super(errorMessage);
    this.code = code;
    this.errorMessage = errorMessage;
  }

  public ServiceException(ErrorEnums error) {
    super(error.getErrDesc());

    this.code = error.getErrCode();
    this.errorMessage = error.getErrDesc();
  }

  public int getCode() {
    return code;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
