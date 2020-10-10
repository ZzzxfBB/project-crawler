package com.iskeen.project.crawler.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iskeen.project.crawler.common.exception.BizException;
import com.iskeen.project.crawler.common.exception.CommonError;
import com.iskeen.project.crawler.common.util.JWTUtil;
import com.iskeen.project.crawler.core.domain.User;
import com.iskeen.project.crawler.core.mapper.UserMapper;
import com.iskeen.project.crawler.core.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Override
  @Transactional(rollbackFor = Exception.class)
  public JSONObject login(User user) {

    String username = user.getUsername();
    String password = user.getPassword();
    User usr = getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username)
        .eq(User::getPassword, password));
    if (null == usr) {
      throw new BizException(CommonError.PARAM_ERROR, "用户名或者密码错误");
    }

    //秘钥
    String secret = RandomStringUtils.randomAlphabetic(16);
    usr.setSecret(secret);
    updateById(usr);
    String token = JWTUtil.sign(usr.getId(), secret);
    try {
      JSONObject jsonObject = new JSONObject() {{
        put("userId", usr.getId());
        put("username", usr.getUsername());
        put("token", token);
      }};
      return jsonObject;
    } catch (Exception e) {
      log.error("token格式转化异常", e);
      throw new BizException(CommonError.PARAM_ERROR, "token格式错误");
    }
  }
}
