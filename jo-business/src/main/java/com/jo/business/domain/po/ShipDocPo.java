package com.jo.business.domain.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bz_ship_doc")
public class ShipDocPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "ship_doc_id", type = IdType.AUTO)
    private Long shipDocId;

    @TableField("invoice_no")
    private String invoiceNo;

    @TableField("invoice_no_oth")
    private String invoiceNoOth;

    @TableField("stowage_status")
    private String stowageStatus;

    @TableField("io_type")
    private String ioType;

    @TableField("shipper")
    private String shipper;

    @TableField("booking_type")
    private String bookingType;

    @TableField("booking_no")
    private String bookingNo;

    @TableField("booking_date")
    private Date bookingDate;

    @TableField("freight")
    private Integer freight;

    @TableField("internal_note")
    private String internalNote;

    @TableField("shipping_company")
    private String shippingCompany;

    @TableField("vessel_no")
    private String vesselNo;

    @TableField("receipt_place")
    private String receiptPlace;

    @TableField("loading_port")
    private String loadingPort;

    @TableField("discharge_port")
    private String dischargePort;

    @TableField("delivery_place")
    private String deliveryPlace;

    @TableField("departure_date")
    private Date departureDate;

    @TableField("cy_cut")
    private Date cyCut;

    @TableField("file_cut")
    private Date fileCut;

    @TableField("open_day")
    private Date openDay;

    @TableField("arrival_date")
    private Date arrivalDate;

    @TableField("shipping_note")
    private String shippingNote;

    @TableField("issued_at")
    private Date issuedAt;

    @TableField("bl_count")
    private String blCount;

    @TableField("bl_copy")
    private String blCopy;

    @TableField("bl_mark")
    private String blMark;

    @TableField("payment_type")
    private String paymentType;

    @TableField("bl_note")
    private String blNote;

    @TableField("trans_company")
    private String transCompany;

    @TableField("trans_contact_person")
    private String transContactPerson;

    @TableField("trans_note")
    private String transNote;

    @TableField("status")
    private Integer status;

    @TableField("del_flag")
    private Integer delFlag;

    @TableField(value="created_at",fill = FieldFill.INSERT)
    private Timestamp createdAt;

    @TableField(value="created_by",fill = FieldFill.INSERT)
    private String createdBy;

    @TableField(value="updated_at",fill = FieldFill.UPDATE)
    private Timestamp updatedAt;

    @TableField(value="updated_by",fill = FieldFill.UPDATE)
    private String updatedBy;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
}