package com.iskeen.project.crawler.core.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iskeen.project.crawler.core.domain.CrawlLog;
import com.iskeen.project.crawler.core.mapper.CrawlLogMapper;
import com.iskeen.project.crawler.core.service.CrawlLogService;
@Service
public class CrawlLogServiceImpl extends ServiceImpl<CrawlLogMapper, CrawlLog> implements CrawlLogService{

}
