package com.iskeen.project.crawler.core.job.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iskeen.project.crawler.core.job.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {

}