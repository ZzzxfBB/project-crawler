package com.iskeen.project.crawler.common.constant;

/**
 * @author zhaobo
 * @program advert-platform
 * @description 常量
 * @date 2020/9/8
 */
public class Constant {

  /**
   * token过期
   */
  public final static Long TOKEN_TTL = 2 * 60 * 60 * 1000L;
  /**
   * 当前页码
   */
  public static final String PAGE = "page";
  /**
   * 每页显示记录数
   */
  public static final String LIMIT = "limit";
  /**
   * 排序字段
   */
  public static final String ORDER_FIELD = "sidx";
  /**
   * 排序方式
   */
  public static final String ORDER = "order";
  /**
   * 升序
   */
  public static final String ASC = "asc";


  /**
   * 定时任务状态
   *
   * @author chenshun
   * @email sunlightcs@gmail.com
   * @date 2016年12月3日 上午12:07:22
   */
  public enum ScheduleStatus {
    /**
     * 正常
     */
    NORMAL(0),
    /**
     * 暂停
     */
    PAUSE(1);

    private int value;

    ScheduleStatus(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }
}

