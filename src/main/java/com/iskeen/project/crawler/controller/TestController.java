package com.iskeen.project.crawler.controller;

import com.iskeen.project.crawler.common.dto.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description: TODO
 * @Author zhouxiangfu
 * @Date 2020/9/23 2:29 下午
 * @Version V1.0
 **/

@RestController
public class TestController {


  @GetMapping
  public ResponseEntity test(){
    return Result.ok("hello");
  }
}