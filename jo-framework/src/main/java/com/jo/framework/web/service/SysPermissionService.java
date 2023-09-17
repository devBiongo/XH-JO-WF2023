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
        Set<String> roles = new HashSet<String>();
        // 管理员拥有所有权限
        roles.addAll(roleService.selectRolePermissionByUserId(user.getUserId()));
        return roles;
    }

    /**
     * 获取菜单数据权限
     *
     * @param user 用户信息
     * @return 菜单权限信息
     */
    public Set<String> getMenuPermission(SysUserPo user) {
        Set<String> perms = new HashSet<String>();
        List<SysRolePo> roles = null;
        if (!roles.isEmpty() && roles.size() > 1) {
            // 多角色设置permissions属性，以便数据权限匹配权限
            for (SysRolePo role : roles) {
                Set<String> rolePerms = menuService.selectMenuPermsByRoleId(role.getRoleId());
                role.setPermissions(rolePerms);
                perms.addAll(rolePerms);
            }
        } else {
            perms.addAll(menuService.selectMenuPermsByUserId(user.getUserId()));
        }
        return perms;
    }
}
