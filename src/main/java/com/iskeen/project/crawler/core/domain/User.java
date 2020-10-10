package com.iskeen.project.crawler.core.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "pc_user")
public class User implements Serializable {

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.INPUT)
  private Integer id;

  /**
   * 昵称
   */
  @TableField(value = "username")
  @NotNull(message = "用户名不可为空")
  private String username;

  @TableField(value = "`password`")
  @NotNull(message = "密码不可为空")
  private String password;

  /**
   * 用户状态 0 正常
   */
  @TableField(value = "`status`")
  private Integer status;

  @TableField(value = "create_time")
  private Date createTime;

  @TableField(value = "update_time")
  private Date updateTime;

  @TableField(value = "secret")
  private String secret;

  private static final long serialVersionUID = 1L;

  public static final String COL_ID = "id";

  public static final String COL_USERNAME = "username";

  public static final String COL_PASSWORD = "password";

  public static final String COL_STATUS = "status";

  public static final String COL_CREATE_TIME = "create_time";

  public static final String COL_UPDATE_TIME = "update_time";

  public static final String COL_SECRET = "secret";
}