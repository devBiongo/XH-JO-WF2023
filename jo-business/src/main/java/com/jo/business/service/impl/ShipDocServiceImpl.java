package com.jo.business.service.impl;

import com.jo.business.domain.dto.ShipDocDto;
import com.jo.business.domain.po.ShipDocPo;
import com.jo.business.mapper.ShipDocMapper;
import com.jo.business.service.IShipDocService;
import com.jo.common.core.service.BaseService;
import com.jo.common.exception.ServiceException;
import com.jo.common.utils.bean.ModelUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-29
 */
@Service
public class ShipDocServiceImpl extends BaseService<ShipDocMapper, ShipDocPo> implements IShipDocService {

    @Override
    public void updateShipDoc(ShipDocDto shipDocDto) {
        ShipDocPo prevPo = this.getById(shipDocDto.getShipDocId());
        ShipDocPo currPo = ModelUtil.convertDtoPo(shipDocDto, ShipDocPo.class);
        if (!this.updateById(currPo)) {
            throw new ServiceException("操作対象のデータが他ユーザによって更新されています。");
        }
    }
}