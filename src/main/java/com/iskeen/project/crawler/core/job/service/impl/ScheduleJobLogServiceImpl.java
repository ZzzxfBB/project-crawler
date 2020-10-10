package com.iskeen.project.crawler.core.job.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iskeen.project.crawler.core.job.dao.ScheduleJobLogDao;
import com.iskeen.project.crawler.core.job.entity.ScheduleJobLogEntity;
import com.iskeen.project.crawler.core.job.service.ScheduleJobLogService;
import org.springframework.stereotype.Service;

@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl extends
    ServiceImpl<ScheduleJobLogDao, ScheduleJobLogEntity> implements
    ScheduleJobLogService {


}