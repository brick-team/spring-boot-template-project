#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ctr.common;

import ${package}.domain.model.res.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huifer
 */
@RestController
public class BeatController {

  @GetMapping("/beat")
  public ResultVO beat() {
    return ResultVO.success(System.currentTimeMillis());
  }
}
