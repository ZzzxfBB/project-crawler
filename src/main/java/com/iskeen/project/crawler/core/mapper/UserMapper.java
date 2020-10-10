package com.iskeen.project.crawler.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iskeen.project.crawler.core.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}