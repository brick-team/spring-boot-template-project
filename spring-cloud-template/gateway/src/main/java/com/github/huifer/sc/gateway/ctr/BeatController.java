package com.github.huifer.sc.gateway.ctr;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.huifer.sc.http.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeatController {

  @SentinelResource("/beat")
  @GetMapping(value = {"/beat", "/"})
  public R<String> beat() {
    return R.ok("beat");
  }
}
