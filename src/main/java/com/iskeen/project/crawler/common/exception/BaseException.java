package com.iskeen.project.crawler.common.exception;


import java.util.concurrent.ExecutionException;
import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * @author zhaobo
 * @date 2018/1/17 下午3:50
 */
public class BaseException extends RuntimeException {

  @Getter
  private final CodeMessage codeMessage;

  @Getter
  private String extMsg;


  protected BaseException(CodeMessage codeMessage) {
    this(codeMessage, null, null);
  }

  protected BaseException(CodeMessage codeMessage, String extMsg) {
    this(codeMessage, null, extMsg);
  }


  protected BaseException(CodeMessage codeMessage, Throwable t) {
    this(codeMessage, t, null);
  }


  protected BaseException(CodeMessage codeMessage, Throwable t, String extMsg) {
    super(getMessage(codeMessage, extMsg), t);
    if (codeMessage == null) {
      codeMessage = CommonError.FAILED;
    }
    this.extMsg = extMsg;
    this.codeMessage = codeMessage;
  }

  public static BaseException orNew(Throwable t, CodeMessage codeMessage) {
    return orNew(t, codeMessage, null);
  }


  //执行时异常
  public static BaseException orNew(Throwable t, CodeMessage codeMessage, String extMsg) {
    // 如果是线程池抛出的ExecutionException，则获取其cause
    if (t instanceof ExecutionException) {
      t = t.getCause();
    }

    if (t instanceof BaseException) {
      return (BaseException) t;
    } else {
      // 根据状态码是否为系统错误，创建SysException或BizException
      if (codeMessage == null || codeMessage.getCode() == CommonError.FAILED.getCode()) {
        return new SysException(t, extMsg);
      } else {
        return new BizException(codeMessage, t, extMsg);
      }
    }
  }

  private static String getMessage(CodeMessage errorCodeMsg, String extMsg) {
    StringBuilder sb = new StringBuilder();
    sb.append((errorCodeMsg != null ? errorCodeMsg : CommonError.FAILED).getCode()).append("::")
        .append((errorCodeMsg != null ? errorCodeMsg : CommonError.FAILED).getMsg());
    if (!StringUtils.isEmpty(extMsg)) {
      sb.append(" ").append(extMsg);
    }
    return sb.toString();
  }
}
