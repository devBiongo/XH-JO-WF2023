package com.jo.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jo.business.domain.dto.AssignDto;
import com.jo.business.domain.po.AssignPo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-29
 */
public interface IAssignmentService extends IService<AssignPo> {

    List<AssignPo>  selectList(String shipDocId);

    void updateAssignments(List<AssignDto> assignDtoList);
}