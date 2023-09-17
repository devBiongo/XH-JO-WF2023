package com.jo.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jo.common.core.service.BaseService;
import com.jo.common.core.domain.po.SysUserPo;
import com.jo.system.mapper.SysUserMapper;
import com.jo.system.service.ISysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends BaseService<SysUserMapper, SysUserPo> implements ISysUserService {
    @Override
    public SysUserPo selectUserByUserName(String username) {
        QueryWrapper<SysUserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<SysUserPo> list = this.list(queryWrapper);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void updateUserProfile(SysUserPo sysUser) {

    }

    @Override
    public boolean registerUser(SysUserPo sysUser) {
        return false;
    }

    @Override
    public boolean checkUserNameUnique(SysUserPo sysUser) {
        return false;
    }
}
