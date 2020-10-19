package com.iskeen.project.crawler.core.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * xsoft
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "pc_xsoft")
public class Xsoft implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 开发类型
     */
    @TableField(value = "dev_type")
    private String devType;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 发布时间
     */
    @TableField(value = "publish_time")
    private Date publishTime;

    /**
     * 预算
     */
    @TableField(value = "budget")
    private String budget;

    /**
     * 开发周期
     */
    @TableField(value = "dev_period")
    private String devPeriod;

    /**
     * 开发区域
     */
    @TableField(value = "dev_area")
    private String devArea;

    /**
     * 项目描述
     */
    @TableField(value = "`desc`")
    private String desc;

    /**
     * 附件
     */
    @TableField(value = "attachment")
    private String attachment;

    /**
     *  0 正常
     */
    @TableField(value = "`status`")
    private Integer status;

    @TableField(value = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_DEV_TYPE = "dev_type";

    public static final String COL_TITLE = "title";

    public static final String COL_PUBLISH_TIME = "publish_time";

    public static final String COL_BUDGET = "budget";

    public static final String COL_DEV_PERIOD = "dev_period";

    public static final String COL_DEV_AREA = "dev_area";

    public static final String COL_DESC = "desc";

    public static final String COL_ATTACHMENT = "attachment";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";
}