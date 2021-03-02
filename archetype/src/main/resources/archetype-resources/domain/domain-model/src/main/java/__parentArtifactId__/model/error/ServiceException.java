#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.model.error;

import ${package}.${parentArtifactId}.model.res.ResultVO;

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
