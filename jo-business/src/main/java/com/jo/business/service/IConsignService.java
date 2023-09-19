package com.jo.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jo.business.domain.dto.ConsignDto;
import com.jo.business.domain.po.ConsignPo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-29
 */
public interface IConsignService extends IService<ConsignPo> {

    List<ConsignPo> selectList(String shipDocId);

    void updateConsigns(List<ConsignDto> consignDtoList);

}