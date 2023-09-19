package com.jo.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jo.business.domain.dto.AssignDto;
import com.jo.business.domain.po.AssignPo;
import com.jo.business.mapper.AssignmentMapper;
import com.jo.business.service.IAssignmentService;
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
public class AssignmentServiceImpl extends BaseService<AssignmentMapper, AssignPo> implements IAssignmentService {

    /*
     * 用外键作为查询条件
     * */
    public List<AssignPo> selectList(String shipDocId) {
        QueryWrapper<AssignPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ship_doc_id", shipDocId);
        return this.list(queryWrapper);
    }

    @SneakyThrows
    @Transactional
    @Override
    public void updateAssignments(List<AssignDto> assignDtoList) {
        List<AssignPo> prevPos = this.selectList(assignDtoList.get(0).getShipDocId().toString());
        List<AssignPo> currPos = ModelUtil.convertDtoPoBatch(assignDtoList, AssignPo.class);
        this.saveOrUpdateOrRemoveBatch(prevPos, currPos);
    }
}