package com.jo.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jo.business.domain.dto.ConsignDto;
import com.jo.business.domain.po.ConsignPo;
import com.jo.business.mapper.ConsignMapper;
import com.jo.business.service.IConsignService;
import com.jo.common.core.service.BaseService;
import com.jo.common.utils.bean.ModelUtil;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-29
 */
@Service
public class ConsignServiceImpl extends BaseService<ConsignMapper, ConsignPo> implements IConsignService {

    public List<ConsignPo> selectList(String shipDocId) {
        QueryWrapper<ConsignPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ship_doc_id", shipDocId);
        return this.list(queryWrapper);
    }
    @Transactional
    @SneakyThrows
    @Override
    public void updateConsigns(List<ConsignDto> consignDtoList) {
        List<ConsignPo> prevPos = this.selectList(consignDtoList.get(0).getShipDocId().toString());
        List<ConsignPo> currPos = ModelUtil.convertDtoPoBatch(consignDtoList, ConsignPo.class);
        this.saveOrUpdateOrRemoveBatch(prevPos, currPos);
    }
}