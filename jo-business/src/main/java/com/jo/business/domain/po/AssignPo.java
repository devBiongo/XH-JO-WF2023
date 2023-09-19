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
@TableName("bz_assignment")
public class AssignPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "assign_id", type = IdType.AUTO)
    private Long assignId;

    @TableField("company_name")
    private String companyName;

    @TableField("contact_person")
    private String contactPerson;

    @TableField("tel_no")
    private String telNo;

    @TableField("assign_date")
    private String assignDate;

    @TableField("assign_address")
    private String assignAddress;

    @TableField("note")
    private String note;

    @TableField("ship_doc_id")
    private Long shipDocId;

}