package com.github.huifer.ctr.common;

import com.github.huifer.domain.model.error.ServiceException;
import com.github.huifer.domain.model.res.ResultVO;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller增强类，全局异常处理
 *
 * @author zst
 */
@ControllerAdvice
public class SiteControllerAdvice {

  public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
  private static final Logger LOGGER = LoggerFactory.getLogger(SiteControllerAdvice.class);
  @Autowired
  private HttpServletResponse httpServletResponse;

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public ResultVO doExceptionHandler(Exception e) {
    ResultVO failed;
    if (e instanceof NumberFormatException) {
      // 数字转换异常
      LOGGER.error(e.getMessage(), e);
      failed =
          ResultVO.failed(
              ResultVO.PARAM_ERROR,
              "请勿在要求输入数字的内容输入文字,错误内容为:" + e.getMessage(),
              "请勿在要求输入数字的内容输入文字,错误内容为:" + e.getMessage());
    } else if (e instanceof BindException) {
      // 校验参数转换异常
      LOGGER.error(e.getMessage(), e);
      failed =
          ResultVO.failed(
              ResultVO.PARAM_ERROR,
              "请按照接口字段要求输入,错误内容为:" + e.getMessage(),
              "请按照接口字段要求输入,错误内容为:" + e.getMessage());
    } else if (e instanceof IllegalStateException || e instanceof IllegalArgumentException) {
      // 断言退出,未通过业务判断的断言异常退出
      LOGGER.error("校验未通过>>> {}", e.getMessage(), e);
      LOGGER.info("校验未通过,退出执行方法");
      failed = ResultVO
          .failed(ResultVO.ASSERT_ERROR, "校验未通过:" + e.getMessage(), "校验未通过:" + e.getMessage());
    } else if (e instanceof ServiceException) {
      LOGGER.error(e.getMessage(), e);
      failed =
          ResultVO.failed(
              ((ServiceException) e).getCode(),
              "业务校验异常:" + e.getMessage(),
              "业务校验异常:" + e.getMessage());
    } else {
      LOGGER.error("未知异常>>> {}", e.getMessage(), e);
      LOGGER.info("未知异常,退出执行方法");
      failed = ResultVO.failed(500, "未知异常,异常详情:" + e.getMessage(), "未知异常,异常详情:" + e.getMessage());
    }

    this.addCors();
    return failed;
  }

  private void addCors() {
    if (!httpServletResponse.containsHeader(ACCESS_CONTROL_ALLOW_ORIGIN)) {
      httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
      httpServletResponse.addHeader("Access-Control-Allow-Credentials", "false");
      httpServletResponse.addHeader(
          "Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
      httpServletResponse.addHeader("Access-Control-Max-Age", "3600");
    }
  }
}
