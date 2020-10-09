package com.iskeen.project.crawler.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhabo
 * @date 2019/10/20
 */
@Slf4j
public class SpringBeanFactory implements
    ApplicationContextInitializer<ConfigurableApplicationContext> {

  private static ApplicationContext applicationContext;

  public static <T> T getBean(String beanName) {
    return (T) applicationContext.getBean(beanName);
  }

  public static <T> T getBean(Class clazz) {
    return (T) applicationContext.getBean(clazz);
  }

  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  @Override
  public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
    SpringBeanFactory.applicationContext = configurableApplicationContext;
  }
}
