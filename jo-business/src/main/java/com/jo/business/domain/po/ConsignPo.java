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
@TableName("bz_consign")
public class ConsignPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "consign_id", type = IdType.AUTO)
    private Long consignId;

    @TableField("company_name")
    private String companyName;

    @TableField("note")
    private String note;

    @TableField("ship_doc_id")
    private Long shipDocId;

}