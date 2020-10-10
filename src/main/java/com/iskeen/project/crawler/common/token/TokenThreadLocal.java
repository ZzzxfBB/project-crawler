package com.iskeen.project.crawler.common.token;


import com.iskeen.project.crawler.core.domain.User;
import org.springframework.util.Assert;

/**
 * @author zhaobo
 * @program advert-platform
 * @description
 * @date 2020/9/8
 */
public class TokenThreadLocal {

  public static final InheritableThreadLocal<User> TOKENS_THREAD_LOCAL = new InheritableThreadLocal<>();

  public static User get() {
    return TOKENS_THREAD_LOCAL.get();
  }

  public static void set(User user) {
    Assert.notNull(user, "user is null");
    TOKENS_THREAD_LOCAL.set(user);
  }

  public static void clear() {
    TOKENS_THREAD_LOCAL.remove();
  }
}
