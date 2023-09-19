package com.jo.web.param;

import com.jo.business.domain.dto.*;
import lombok.Data;

import java.util.List;

@Data
public class ShipParam {

    private ShipDocDto shipDocDto;

    private List<AssignDto> assignDtoList;

    private List<ConsignDto> consignDtoList;

    private List<ContainerDto> containerDtoList;

    private List<NotifierDto> notifierDtoList;

    public void setUpShipDocId(){
        Long shipDocId = shipDocDto.getShipDocId();
        if(shipDocId==null) throw new RuntimeException("System error");
        assignDtoList.forEach(assignDto -> assignDto.setShipDocId(shipDocId));
        consignDtoList.forEach(consignDto -> consignDto.setShipDocId(shipDocId));
        containerDtoList.forEach(containerDto -> containerDto.setShipDocId(shipDocId));
        notifierDtoList.forEach(notifierDto -> notifierDto.setShipDocId(shipDocId));
    }
}