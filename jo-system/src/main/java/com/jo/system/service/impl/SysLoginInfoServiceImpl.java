package com.jo.system.service.impl;

import com.jo.common.core.service.BaseService;
import com.jo.system.domain.po.SysLoginInfoPo;
import com.jo.system.mapper.SysLoginInfoMapper;
import com.jo.system.service.ISysLoginInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLoginInfoServiceImpl extends BaseService<SysLoginInfoMapper, SysLoginInfoPo> implements ISysLoginInfoService {

    @Override
    public void insertLoginInfo(SysLoginInfoPo loginInfoPo) {
        this.save(loginInfoPo);
    }

    @Override
    public List<SysLoginInfoPo> selectLoginInfoList(SysLoginInfoPo loginInfoPo) {
        return null;
    }

    @Override
    public int deleteLoginInfoByIds(Long[] infoIds) {
        return 0;
    }

    @Override
    public void cleanLoginInfo() {

    }
}
