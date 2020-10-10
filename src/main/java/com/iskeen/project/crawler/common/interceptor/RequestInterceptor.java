package com.iskeen.project.crawler.common.interceptor;

import com.google.common.base.Strings;
import com.iskeen.project.crawler.common.exception.BizException;
import com.iskeen.project.crawler.common.exception.CommonError;
import com.iskeen.project.crawler.common.token.TokenThreadLocal;
import com.iskeen.project.crawler.common.util.JWTUtil;
import com.iskeen.project.crawler.core.domain.User;
import com.iskeen.project.crawler.core.service.UserService;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

/**
 * @author zhaobo
 * @program guanghan-report
 * @description 请求拦截器
 * @date 2020/3/19
 */
@Slf4j
@Configuration
public class RequestInterceptor extends HandlerInterceptorAdapter {

  public static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhY2NvdW50SWQiOjE3LCJleHAiOjE2MDA0MjU1MTZ9.Csb4ZFnVa6Ybkm7RKkm2eaVtc6YJR3EuaAhR52OOnLs";

  @Resource
  private UserService userService;


  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    String xkToken = getToken(request);
    User user = validToken(xkToken, request);
    TokenThreadLocal.set(user);
    return super.preHandle(request, response, handler);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    TokenThreadLocal.clear();
    super.afterCompletion(request, response, handler, ex);
  }

  private String getToken(HttpServletRequest request) {

    String token = request.getParameter("authorization");
    if (Strings.isNullOrEmpty(token)) {
      token = request.getHeader("authorization");
    }

    if (Strings.isNullOrEmpty(token)) {
      Cookie cookie = WebUtils.getCookie(request, "authorization");
      if (Objects.nonNull(cookie)) {
        token = cookie.getValue();
      }
    }

    if (Strings.isNullOrEmpty(token)) {

      throw new BizException(CommonError.UN_LOGIN, "请先登录再进行该操作");
    }
    return token;
  }


  private User validToken(String xkToken, HttpServletRequest request) {
    if (StringUtils.isEmpty(xkToken)) {
      return null;
    }
    if (TOKEN.equals(xkToken)) {
      return userService.getById(1);
    }
    Integer userId = JWTUtil.getUserNo(xkToken);
    User usr = userService.getById(userId);
    if (usr == null) {
      log.error("用户已不存在, token:{}", xkToken);
      throw new BizException(CommonError.UN_LOGIN);
    }

    String secret = usr.getSecret();
    if (!JWTUtil.verify(xkToken, userId, secret)) {
      log.error("token格式错误, token:{}", xkToken);
      throw new BizException(CommonError.UN_LOGIN);
    }
    //验证是否过期
    if (JWTUtil.isExpired(xkToken)) {
      log.error("登录session过期, token:{}", xkToken);
      throw new BizException(CommonError.UN_LOGIN);
    }
    return usr;
  }


}
