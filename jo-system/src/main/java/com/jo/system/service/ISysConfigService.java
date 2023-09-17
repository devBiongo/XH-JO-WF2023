package com.jo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jo.common.core.domain.po.SysConfigPo;

/**
 * 参数配置 服务层
 * 
 * @author ruoyi
 */
public interface ISysConfigService extends IService<SysConfigPo> {
    boolean selectCaptchaEnabled();

    String selectConfigByKey(String s);
}
