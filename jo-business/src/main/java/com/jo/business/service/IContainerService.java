package com.jo.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jo.business.domain.dto.ContainerDto;
import com.jo.business.domain.po.ContainerPo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-29
 */
public interface IContainerService extends IService<ContainerPo> {

    List<ContainerPo> selectList(String shipDocId);

    void updateContainers(List<ContainerDto> containerDtoList);

}