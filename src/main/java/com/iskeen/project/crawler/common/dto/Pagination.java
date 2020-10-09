package com.iskeen.project.crawler.common.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaobo
 * @date 2018/1/17 下午3:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * 当前页
   */
  private int current;
  /**
   * 每页条数
   */
  private int pageSize;
  /**
   * 总页数
   */
  private int pages;
  /**
   * 总数
   */
  private int total;

  public static Pagination create(long current, long pageSize, long pages, long total) {
    return new Pagination((int) current, (int) pageSize, (int) pages, (int) total);
  }

  public static Pagination defaultInstance() {
    return new Pagination(1, 10, 0, 0);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Pagination{");
    sb.append("current=").append(current);
    sb.append(", pageSize=").append(pageSize);
    sb.append(", pages=").append(pages);
    sb.append(", total=").append(total);
    sb.append('}');
    return sb.toString();
  }
}
