package com.jo.business.domain.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bz_container")
public class ContainerPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "container_id", type = IdType.AUTO)
    private Long containerId;

    @TableField("departure")
    private String departure;

    @TableField("transit")
    private String transit;

    @TableField("arrival")
    private String arrival;

    @TableField("date")
    private String date;

    @TableField("van_no")
    private String vanNo;

    @TableField("sheet_no")
    private String sheetNo;

    @TableField("size")
    private String size;

    @TableField("free_time")
    private String freeTime;

    @TableField("tw")
    private String tw;

    @TableField("duty_free_fare")
    private String dutyFreeFare;

    @TableField("taxable_fare")
    private String taxableFare;

    @TableField("toll")
    private String toll;

    @TableField("sales_amount")
    private String salesAmount;

    @TableField("note")
    private String note;

    @TableField("ship_doc_id")
    private Long shipDocId;
}