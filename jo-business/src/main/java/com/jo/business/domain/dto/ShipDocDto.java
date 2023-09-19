package com.jo.business.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ShipDocDto {

    private Long shipDocId;

    private String invoiceNo;

    private String invoiceNoOth;

    private String stowageStatus;

    private String ioType;

    private String shipper;

    private String bookingType;

    private String bookingNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
    private Date bookingDate;

    private Integer freight;

    private String internalNote;

    private String shippingCompany;

    private String vesselNo;

    private String receiptPlace;

    private String loadingPort;

    private String dischargePort;

    private String deliveryPlace;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
    private Date departureDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
    private Date cyCut;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
    private Date fileCut;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
    private Date openDay;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
    private Date arrivalDate;

    private String shippingNote;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
    private Date issuedAt;

    private String blCount;

    private String blCopy;

    private String blMark;

    private String paymentType;

    private String blNote;

    private String transCompany;

    private String transContactPerson;

    private String transNote;

    private Integer status;

    private Integer delFlag;

    private Date createdAt;

    @NotNull
    private Integer version;

}