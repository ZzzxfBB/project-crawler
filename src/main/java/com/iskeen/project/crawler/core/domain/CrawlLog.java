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
    * 抓取记录
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "pc_crawl_log")
public class CrawlLog implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类型
     */
    @TableField(value = "processor")
    private String processor;

    @TableField(value = "url")
    private String url;

    /**
     * 抓取字节数
     */
    @TableField(value = "bytes")
    private Integer bytes;

    /**
     *  0 正常
     */
    @TableField(value = "`status`")
    private Integer status;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "velocity")
    private Integer velocity;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_PROCESSOR = "processor";

    public static final String COL_URL = "url";

    public static final String COL_BYTES = "bytes";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_VELOCITY = "velocity";
}