package com.jo.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jo.business.domain.dto.ShipDocDto;
import com.jo.business.domain.po.ShipDocPo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-29
 */
public interface IShipDocService extends IService<ShipDocPo> {

    void updateShipDoc(ShipDocDto shipDocDto);

}