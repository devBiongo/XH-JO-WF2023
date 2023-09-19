package com.jo.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jo.business.domain.po.ShipDocPo;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-29
 */
@Repository
public interface ShipDocMapper extends BaseMapper<ShipDocPo> {

}