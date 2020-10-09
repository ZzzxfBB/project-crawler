package com.iskeen.project.crawler.common.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.iskeen.project.crawler.common.exception.CommonError;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

/**
 * @author zhaobo
 * @date 2018/1/17 下午3:50
 */
@Setter
@Getter
public class Result<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  static class Success<T> {

    /**
     * 返回描述信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 分页
     */
    private Pagination pagination;
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  static class Failed {

    private int status;
    /**
     * 返回描述信息
     */
    private String msg;
  }

  public static <T> ResponseEntity<Success> success(CommonError code, String msg, T data,
      Pagination pagination) {
    Success<T> success = Success.<T>builder()
        .data(data)
        .msg(msg)
        .pagination(pagination)
        .build();
    return new ResponseEntity<>(success, code.getErrorCode());
  }

  public static ResponseEntity<Failed> failed(CommonError code, String msg) {
    Failed failed = Failed.builder()
        .status(code.getCode())
        .msg(msg)
        .build();
    return new ResponseEntity<>(failed, code.getErrorCode());
  }

  public static ResponseEntity ok() {
    return success(CommonError.OK, "请求成功", null, null);
  }

  /**
   * 分页
   *
   * @return
   */
  public static ResponseEntity ok(IPage<?> page) {
    Pagination pagination = Pagination
        .create(page.getCurrent(), page.getSize(), page.getPages(), page.getTotal());
    return success(CommonError.OK, "ok", page.getRecords(), pagination);
  }

  public static <T> ResponseEntity ok(T data) {
    if (data instanceof IPage) {
      return ok((IPage) data);
    }
    return success(CommonError.OK, "操作成功", data, null);
  }

  public static <T> ResponseEntity ok(T data, String msg) {
    return success(CommonError.OK, msg, data, null);
  }

  public static ResponseEntity ok(String msg) {
    return success(CommonError.OK, msg, null, null);
  }

  public static ResponseEntity fail(CommonError code, String msg) {
    return failed(code, msg);
  }
}
