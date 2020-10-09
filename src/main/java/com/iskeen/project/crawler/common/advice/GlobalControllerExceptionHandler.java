package com.iskeen.project.crawler.common.advice;

import com.iskeen.project.crawler.common.dto.Result;
import com.iskeen.project.crawler.common.exception.BizException;
import com.iskeen.project.crawler.common.exception.CommonError;
import com.iskeen.project.crawler.common.exception.SysException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhaobo
 * @program: backend
 * @description: 全局异常处理类
 * @date 2019/12/4
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

  @ExceptionHandler({BizException.class})
  public ResponseEntity bizExceptionHandler(BizException e) {
    log.error(e.getMessage(), e);
    return Result.fail((CommonError) e.getCodeMessage(), e.getExtMsg());
  }

  @ExceptionHandler({MethodArgumentNotValidException.class})
  public ResponseEntity bizExceptionHandler(MethodArgumentNotValidException e) {
    log.error("方法参数异常", e);
    BindingResult bindingResult = e.getBindingResult();
    List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    FieldError fieldError = fieldErrors.get(0);
    return Result.fail(CommonError.PARAM_ERROR, fieldError.getDefaultMessage());
  }

  @ExceptionHandler({BindException.class})
  public ResponseEntity bizExceptionHandler(BindException e) {
    log.error("方法参数异常", e);
    BindingResult bindingResult = e.getBindingResult();
    List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    FieldError fieldError = fieldErrors.get(0);
    return Result.fail(CommonError.PARAM_ERROR, fieldError.getDefaultMessage());
  }

  @ExceptionHandler({HttpRequestMethodNotSupportedException.class,
      HttpMessageNotReadableException.class, IllegalArgumentException.class})
  public ResponseEntity bizExceptionHandler(Exception e) {
    log.error("方法参数异常", e);
    return Result.fail(CommonError.PARAM_ERROR, e.getMessage());
  }

  @ExceptionHandler({SysException.class, Exception.class})
  public ResponseEntity sysExceptionHandler(Exception e) {
    log.error(e.getMessage(), e);
    return Result.fail(CommonError.FAILED, "服务异常");
  }
}
