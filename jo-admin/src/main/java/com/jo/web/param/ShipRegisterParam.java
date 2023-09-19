package com.jo.web.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ShipRegisterParam {

    @NotBlank
    private String ioType;

    @NotBlank
    private String invoiceNo;
}
