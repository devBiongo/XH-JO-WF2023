package com.jo.business.domain.dto;

import lombok.Data;

@Data
public class NotifierDto {

    private Long notifierId;

    private String companyName;

    private String note;

    private Long shipDocId;
}