package com.iskeen.project.crawler.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 业务状态
 *
 * @author zhaobo
 * @date 2019/11/21
 */
public enum CommonError implements CodeMessage {

  /**
   * 接口成功
   */
  OK(HttpStatus.OK, "成功"),
  /**
   * 系统异常，非业务状态码，即系统bug产生异常，最严重级别。
   */
  SYSTEM_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "系统繁忙"),
  /**
   * 方法处理失败
   */
  FAILED(HttpStatus.NOT_IMPLEMENTED, "任务处理失败"),
  /**
   * 参数错误，主要为入参格式验证异常。业务实现内部的参数IllegalArgumentException，应该归结为系统异常
   */
  PARAM_ERROR(HttpStatus.BAD_REQUEST, "参数错误"),

  NOT_FOUND(HttpStatus.NOT_FOUND, "接口地址不存在"),

  THIRD_ERROR(HttpStatus.METHOD_FAILURE, "三方服务异常"),

  /**
   * 未登录，非业务状态码，用户重新登录。
   */
  UN_LOGIN(HttpStatus.UNAUTHORIZED, "未登录"),

  /**
   * 无权限
   */
  NN_OPERATION(HttpStatus.FORBIDDEN, "无权限"),

  TOO_MANY_REQUESTS(HttpStatus.TOO_MANY_REQUESTS, "Too Many Requests"),

  GONE(HttpStatus.GONE, "请求对象已不存在");

  private final HttpStatus errorCode;
  private final String errorMsg;


  CommonError(HttpStatus errorCode, String errorMsg) {
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public HttpStatus getErrorCode() {
    return errorCode;
  }

  /**
   * @return the errorCode
   */
  @Override
  public int getCode() {
    return errorCode.value();
  }

  /**
   * @return the errorMsg
   */
  @Override
  public String getMsg() {
    return errorMsg;
  }
}
