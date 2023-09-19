package com.jo.business.domain.dto;

import lombok.Data;

@Data
public class ContainerDto {

    private Long containerId;

    private String departure;

    private String transit;


    private String arrival;


    private String date;


    private String vanNo;


    private String sheetNo;


    private String size;


    private String freeTime;

    private String tw;

    private String dutyFreeFare;

    private String taxableFare;

    private String toll;

    private String salesAmount;

    private String note;

    private Long shipDocId;
}