package com.jo.system.service.impl;

import com.jo.common.core.service.BaseService;
import com.jo.common.core.domain.po.SysRolePo;
import com.jo.common.core.domain.po.SysUserRolePo;
import com.jo.system.mapper.SysRoleMapper;
import com.jo.system.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class SysRoleServiceImpl extends BaseService<SysRoleMapper, SysRolePo> implements ISysRoleService {
    @Override
    public List<SysRolePo> selectRoleList(SysRolePo role) {
        return null;
    }

    @Override
    public List<SysRolePo> selectRolesByUserId(Long userId) {
        return null;
    }

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        return null;
    }

    @Override
    public List<SysRolePo> selectRoleAll() {
        return null;
    }

    @Override
    public List<Long> selectRoleListByUserId(Long userId) {
        return null;
    }

    @Override
    public SysRolePo selectRoleById(Long roleId) {
        return null;
    }

    @Override
    public boolean checkRoleNameUnique(SysRolePo role) {
        return false;
    }

    @Override
    public boolean checkRoleKeyUnique(SysRolePo role) {
        return false;
    }

    @Override
    public void checkRoleAllowed(SysRolePo role) {

    }

    @Override
    public void checkRoleDataScope(Long roleId) {

    }

    @Override
    public int countUserRoleByRoleId(Long roleId) {
        return 0;
    }

    @Override
    public int insertRole(SysRolePo role) {
        return 0;
    }

    @Override
    public int updateRole(SysRolePo role) {
        return 0;
    }

    @Override
    public int updateRoleStatus(SysRolePo role) {
        return 0;
    }

    @Override
    public int authDataScope(SysRolePo role) {
        return 0;
    }

    @Override
    public int deleteRoleById(Long roleId) {
        return 0;
    }

    @Override
    public int deleteRoleByIds(Long[] roleIds) {
        return 0;
    }

    @Override
    public int deleteAuthUser(SysUserRolePo userRole) {
        return 0;
    }

    @Override
    public int deleteAuthUsers(Long roleId, Long[] userIds) {
        return 0;
    }

    @Override
    public int insertAuthUsers(Long roleId, Long[] userIds) {
        return 0;
    }
}
