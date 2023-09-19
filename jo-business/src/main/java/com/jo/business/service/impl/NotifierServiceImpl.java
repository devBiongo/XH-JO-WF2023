package com.jo.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jo.business.domain.dto.NotifierDto;
import com.jo.business.domain.po.NotifierPo;
import com.jo.business.mapper.NotifierMapper;
import com.jo.business.service.INotifierService;
import com.jo.common.core.service.BaseService;
import com.jo.common.utils.bean.ModelUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-29
 */
@Service
public class NotifierServiceImpl extends BaseService<NotifierMapper, NotifierPo> implements INotifierService {
    public List<NotifierPo> selectList(String shipDocId) {
        QueryWrapper<NotifierPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ship_doc_id", shipDocId);
        return this.list(queryWrapper);
    }

    @Transactional
    @Override
    public void updateNotifiers(List<NotifierDto> notifierDtoList) {
        List<NotifierPo> prevPos = this.selectList(notifierDtoList.get(0).getShipDocId().toString());
        List<NotifierPo> currPos = ModelUtil.convertDtoPoBatch(notifierDtoList, NotifierPo.class);
        this.saveOrUpdateOrRemoveBatch(prevPos, currPos);
    }
}