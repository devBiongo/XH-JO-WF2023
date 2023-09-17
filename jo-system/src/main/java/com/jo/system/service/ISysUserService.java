package com.jo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jo.common.core.domain.po.SysUserPo;

public interface ISysUserService extends IService<SysUserPo> {

    SysUserPo selectUserByUserName(String username);

    void updateUserProfile(SysUserPo sysUser);

    boolean registerUser(SysUserPo sysUser);

    boolean checkUserNameUnique(SysUserPo sysUser);
}
