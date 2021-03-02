#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.validator;

/**
 * 验证接口
 */
public interface ValidatorApi<T> {

  void valid(T t);
}
