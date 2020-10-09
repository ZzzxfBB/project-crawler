package com.iskeen.project.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhaobo
 */
@SpringBootApplication
@EnableTransactionManagement
public class ProjectCrawlerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProjectCrawlerApplication.class, args);
  }

}
