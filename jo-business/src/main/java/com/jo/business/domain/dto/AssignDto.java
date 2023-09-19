package com.jo.business.domain.dto;


import lombok.Data;

@Data
public class AssignDto {

    private Long assignId;

    private String companyName;

    private String contactPerson;

    private String telNo;

    private String assignDate;

    private String assignAddress;

    private String note;

    private Long shipDocId;
}