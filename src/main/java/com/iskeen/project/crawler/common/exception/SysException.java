package com.iskeen.project.crawler.common.exception;

/**
 * @author zhaobo
 * @date 2018/1/17 下午3:50
 */
public class SysException extends BaseException {

  /**
   * 非Throwable引起的系统异常，比如内部参数错误等，可以只传递说明附加文字
   *
   * @param extMsg
   */
  public SysException(String extMsg) {
    super(CommonError.FAILED, null, extMsg);
  }

  /**
   * 带具体异常和附加提示的状态码, 如果errCodeMsg为null, 则默认使用{@link CommonError .SYSTEM_ERROR }状态码。
   *
   * @param t      可以为null
   * @param extMsg 附加在状态码msg上的提示，可以为null
   */
  public SysException(Throwable t, String extMsg) {
    super(CommonError.FAILED, t, extMsg);
  }
}
