package com.jo.system.service.impl;

import com.jo.common.core.service.BaseService;
import com.jo.common.core.domain.po.SysConfigPo;
import com.jo.system.mapper.SysConfigMapper;
import com.jo.system.service.ISysConfigService;
import org.springframework.stereotype.Service;

/**
 * 参数配置 服务层实现

 * @author ruoyi
 */
@Service
public class SysConfigServiceImpl extends BaseService<SysConfigMapper, SysConfigPo> implements ISysConfigService {

    @Override
    public boolean selectCaptchaEnabled() {
        return true;
    }

    @Override
    public String selectConfigByKey(String s) {
        return null;
    }
}
