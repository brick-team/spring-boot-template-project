#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.model.error;

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
