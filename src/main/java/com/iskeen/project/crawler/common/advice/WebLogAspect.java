package com.iskeen.project.crawler.common.advice;

/**
 * @ClassName WebLogAspect
 * @Description: 接口请求日志
 * @Author zhouxiangfu
 * @Date 2020/9/11 11:39 上午
 * @Version V1.0
 **/


import com.iskeen.project.crawler.common.util.IpUtil;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Aspect 切面 日志切面
 */
@Aspect
@Component
@Slf4j
@Order(1)
public class WebLogAspect {


  /**
   * Pointcut 切入点 匹配cn.controller包下面的所有方法
   */
  @Pointcut("execution(public * com.iskeen.space.post.controller.*.*(..))")
  public void webLog() {
  }

  /**
   * 环绕通知
   */
  @Around(value = "webLog()")
  public Object arround(ProceedingJoinPoint pjp) throws Throwable {

    long start = System.currentTimeMillis();
    Object o;
    try {
      o = pjp.proceed();
    } catch (Throwable throwable) {
      log.info("EXCEPTION : {}", throwable.getMessage());
      throw throwable;

    } finally {
      long end = System.currentTimeMillis();
      log.info("===========================方法执行结束，耗时：{} ms===========================",
          end - start);
    }
    return o;

  }

  /**
   * 方法执行前
   */
  @Before(value = "webLog()")
  public void before(JoinPoint joinPoint) {
    log.info("=================================方法执行开始=================================");
    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
        .getRequestAttributes();
    assert attributes != null;
    HttpServletRequest request = attributes.getRequest();
    String servletPath = request.getServletPath();
    String ipAddress = IpUtil.getRequestIpAddress(request);
    // 记录下请求内容
    log.info("URL : " + servletPath);
    log.info("HTTP_METHOD : " + request.getMethod());
    log.info("IP : " + ipAddress);
    log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint
        .getSignature().getName());
    log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
  }

  /**
   * 方法执行结束，不管是抛出异常或者正常退出都会执行
   */
  @After(value = "webLog()")
  public void after(JoinPoint joinPoint) {
  }

  /**
   * 方法执行结束，增强处理
   */
  @AfterReturning(returning = "ret", pointcut = "webLog()")
  public void doAfterReturning(Object ret) {
    // 处理完请求，返回内容
//    log.info("5、AfterReturning：方法的返回值 : " + ret);
  }

  /**
   * 后置异常通知
   */
  @AfterThrowing(value = "webLog()")
  public void throwss(JoinPoint joinPoint) {
  }
}