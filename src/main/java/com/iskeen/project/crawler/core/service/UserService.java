package com.iskeen.project.crawler.core.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.iskeen.project.crawler.core.domain.User;

public interface UserService extends IService<User> {


  JSONObject login(User user);

}
