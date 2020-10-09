package com.iskeen.project.crawler.common.exception;

/**
 * @author zhaobo
 * @date 2018/1/17 下午3:50
 */
public interface CodeMessage {

  /**
   * @return 码值
   */
  int getCode();

  /**
   * @return 描述信息
   */
  String getMsg();
}
