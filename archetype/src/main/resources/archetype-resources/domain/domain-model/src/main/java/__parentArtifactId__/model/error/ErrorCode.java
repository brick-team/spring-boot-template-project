#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.model.error;

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
