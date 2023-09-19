package com.jo.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jo.business.domain.dto.ContainerDto;
import com.jo.business.domain.po.ContainerPo;
import com.jo.business.mapper.ContainerMapper;
import com.jo.business.service.IContainerService;
import com.jo.common.core.service.BaseService;
import com.jo.common.utils.bean.ModelUtil;
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
public class ContainerServiceImpl extends BaseService<ContainerMapper, ContainerPo> implements IContainerService {

    public List<ContainerPo> selectList(String shipDocId) {
        QueryWrapper<ContainerPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ship_doc_id", shipDocId);
        return this.list(queryWrapper);
    }

    @Transactional
    @Override
    public void updateContainers(List<ContainerDto> containerDtoList) {
        List<ContainerPo> prevPos = this.selectList(containerDtoList.get(0).getShipDocId().toString());
        List<ContainerPo> currPos = ModelUtil.convertDtoPoBatch(containerDtoList, ContainerPo.class);
        this.saveOrUpdateOrRemoveBatch(prevPos, currPos);

    }

}