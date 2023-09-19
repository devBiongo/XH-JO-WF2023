package com.jo.business.domain.dto;

import lombok.Data;

@Data
public class ConsignDto {
    private Long consignId;

    private String companyName;

    private String note;

    private Long shipDocId;
}