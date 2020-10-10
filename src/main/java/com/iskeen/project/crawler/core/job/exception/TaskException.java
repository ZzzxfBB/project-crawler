package com.iskeen.project.crawler.core.job.exception;

import com.iskeen.project.crawler.common.exception.BaseException;
import com.iskeen.project.crawler.common.exception.CodeMessage;

/**
 * @ClassName TaskException
 * @Description: TODO
 * @Author zhouxiangfu
 * @Date 2020/10/10 3:43 下午
 * @Version V1.0
 **/

public class TaskException extends BaseException {

  protected TaskException(CodeMessage codeMessage) {
    super(codeMessage);
  }

  public TaskException(CodeMessage codeMessage, Throwable t) {
    super(codeMessage, t);
  }

  public TaskException(CodeMessage codeMessage, Throwable t, String extMsg) {
    super(codeMessage, t, extMsg);
  }

  public TaskException(CodeMessage codeMessage, String extMsg) {
    super(codeMessage, extMsg);
  }
}