package com.jo.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jo.business.domain.dto.NotifierDto;
import com.jo.business.domain.po.NotifierPo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-29
 */
public interface INotifierService extends IService<NotifierPo> {

    List<NotifierPo> selectList(String shipDocId);

   void updateNotifiers(List<NotifierDto> notifierDtoList);

}