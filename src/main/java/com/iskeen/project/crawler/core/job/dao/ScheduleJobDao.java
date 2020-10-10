package com.iskeen.project.crawler.core.job.dao;

/**
 * @ClassName ScheduleJobDao
 * @Description: TODO
 * @Author zhouxiangfu
 * @Date 2020/10/10 3:36 下午
 * @Version V1.0
 **/


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iskeen.project.crawler.core.job.entity.ScheduleJobEntity;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface ScheduleJobDao extends BaseMapper<ScheduleJobEntity> {

  /**
   * 批量更新状态
   */
  int updateBatch(Map<String, Object> map);
}