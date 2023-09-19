package com.jo.framework.web.service;

import com.jo.common.core.domain.po.SysRolePo;
import com.jo.common.core.domain.po.SysUserPo;
import com.jo.system.service.ISysMenuService;
import com.jo.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户权限处理
 *
 * @author ruoyi
 */
@Component
public class SysPermissionService {
    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysMenuService menuService;

    /**
     * 获取角色数据权限
     *
     * @param user 用户信息
     * @return 角色权限信息
     */
    public Set<String> getRolePermission(SysUserPo user) {

        return new HashSet<String>(roleService.selectRolePermissionByUserId(user.getUserId()));
    }

    /**
     * 获取菜单数据权限
     *
     * @param user 用户信息
     * @return 菜单权限信息
     */
    public Set<String> getMenuPermission(SysUserPo user) {
        return menuService.selectMenuPermsByUserId(user.getUserId());
    }
}
