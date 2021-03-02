package com.github.huifer.domain.model.error;

/**
 * @author huifer
 */
public class ErrorUtils {

  private ErrorUtils() {
    throw new IllegalStateException("this utils");
  }

  public static void error(ErrorEnums errorEnums) {
    throw new ServiceException(errorEnums.getErrCode(), errorEnums.getErrDesc());
  }

}
