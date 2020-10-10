package com.iskeen.project.crawler.controller;

import com.alibaba.fastjson.JSONObject;
import com.iskeen.project.crawler.common.dto.Result;
import com.iskeen.project.crawler.core.domain.User;
import com.iskeen.project.crawler.core.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description: TODO
 * @Author zhouxiangfu
 * @Date 2020/9/23 2:29 下午
 * @Version V1.0
 **/

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Valid User user) {
    JSONObject login = userService.login(user);
    return Result.ok(login, "登录成功");
  }

}