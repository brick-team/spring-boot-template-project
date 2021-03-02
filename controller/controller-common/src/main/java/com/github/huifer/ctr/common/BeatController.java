package com.github.huifer.ctr.common;

import com.github.huifer.domain.model.res.ResultVO;
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
