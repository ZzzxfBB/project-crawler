package com.iskeen.project.crawler.core.job.entity;

/**
 * @ClassName ScheduleJobEntity
 * @Description: TODO
 * @Author zhouxiangfu
 * @Date 2020/10/10 3:20 下午
 * @Version V1.0
 **/

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定时任务
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
@TableName("schedule_job")
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleJobEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 任务调度参数key
   */
  public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";

  /**
   * 任务id
   */
  @TableId
  private Long jobId;

  /**
   * spring bean名称
   */
  @NotBlank(message = "bean名称不能为空")
  private String beanName;

  /**
   * 参数
   */
  private String params;

  /**
   * cron表达式
   */
  @NotBlank(message = "cron表达式不能为空")
  private String cronExpression;

  /**
   * 任务状态
   */
  private Integer status;

  /**
   * 备注
   */
  private String remark;

  /**
   * 创建时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

}