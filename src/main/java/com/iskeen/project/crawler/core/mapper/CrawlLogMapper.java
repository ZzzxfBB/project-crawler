package com.iskeen.project.crawler.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iskeen.project.crawler.core.domain.CrawlLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CrawlLogMapper extends BaseMapper<CrawlLog> {
}