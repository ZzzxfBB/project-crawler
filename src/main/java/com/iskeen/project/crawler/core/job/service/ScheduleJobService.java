package com.iskeen.project.crawler.core.job.service;

/**
 * @ClassName ScheduleJobService
 * @Description: TODO
 * @Author zhouxiangfu
 * @Date 2020/10/10 3:32 下午
 * @Version V1.0
 **/


import com.baomidou.mybatisplus.extension.service.IService;
import com.iskeen.project.crawler.core.job.entity.ScheduleJobEntity;

/**
 * 定时任务
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface ScheduleJobService extends IService<ScheduleJobEntity> {


  /**
   * 保存定时任务
   */
  void saveJob(ScheduleJobEntity scheduleJob);

  /**
   * 更新定时任务
   */
  void update(ScheduleJobEntity scheduleJob);

  /**
   * 批量删除定时任务
   */
  void deleteBatch(Long[] jobIds);

  /**
   * 批量更新定时任务状态
   */
  int updateBatch(Long[] jobIds, int status);

  /**
   * 立即执行
   */
  void run(Long[] jobIds);

  /**
   * 暂停运行
   */
  void pause(Long[] jobIds);

  /**
   * 恢复运行
   */
  void resume(Long[] jobIds);
}

