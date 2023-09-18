package com.jo.system.service;

import com.jo.common.core.domain.po.SysLoginPo;
import com.jo.system.domain.po.SysLoginInfoPo;

import java.util.List;

/**
 * 系统访问日志情况信息 服务层
 *
 * @author ruoyi
 */
public interface ISysLoginInfoService {
    /**
     * 新增系统登录日志
     *
     * @param loginInfoPo 访问日志对象
     */
    public void insertLoginInfo(SysLoginInfoPo loginInfoPo);

    /**
     * 查询系统登录日志集合
     *
     * @param loginInfoPo 访问日志对象
     * @return 登录记录集合
     */
    public List<SysLoginInfoPo> selectLoginInfoList(SysLoginInfoPo loginInfoPo);

    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    public int deleteLoginInfoByIds(Long[] infoIds);

    /**
     * 清空系统登录日志
     */
    public void cleanLoginInfo();
}
