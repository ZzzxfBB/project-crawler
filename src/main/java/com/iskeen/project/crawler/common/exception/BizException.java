package com.iskeen.project.crawler.common.exception;

/**
 * @author zhaobo
 * @date 2018/1/17 下午3:50
 */
public class BizException extends BaseException {

  /**
   * 标准定义的业务状态码异常
   *
   * @param codeMessage 业务状态码，不要使用系统错误码
   */
  public BizException(CodeMessage codeMessage) {
    this(codeMessage, null, null);
  }

  /**
   * 带具体错误提示的业务状态异常，扩展的具体信息会append在标准定义的errorMsg后。
   *
   * @param codeMessage 业务状态码，不要使用系统错误码
   * @param extMsg
   */
  public BizException(CodeMessage codeMessage, String extMsg) {
    this(codeMessage, null, extMsg);
  }

  /**
   * 带具体异常的业务状态码
   *
   * @param codeMessage，业务状态码，不要使用系统错误码
   * @param t
   */
  public BizException(CodeMessage codeMessage, Throwable t) {
    this(codeMessage, t, null);
  }

  /**
   * 带具体异常和附加提示的业务异常
   *
   * @param codeMessage 业务状态码，不要使用系统错误码
   * @param t           可以为null
   * @param extMsg      附加在状态码msg上的提示，可以为null
   */
  public BizException(CodeMessage codeMessage, Throwable t, String extMsg) {
    super(codeMessage, t, extMsg);
  }
}
