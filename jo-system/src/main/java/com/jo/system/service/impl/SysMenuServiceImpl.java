package com.jo.system.service.impl;

import com.jo.common.core.domain.po.TreeSelect;
import com.jo.common.core.service.BaseService;
import com.jo.system.domain.RouterVo;
import com.jo.common.core.domain.po.SysMenu;
import com.jo.system.mapper.SysMenuMapper;
import com.jo.system.service.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SysMenuServiceImpl  extends BaseService<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Override
    public List<SysMenu> selectMenuList(Long userId) {
        return null;
    }

    @Override
    public List<SysMenu> selectMenuList(SysMenu menu, Long userId) {
        return null;
    }

    @Override
    public Set<String> selectMenuPermsByUserId(Long userId) {
        return null;
    }

    @Override
    public Set<String> selectMenuPermsByRoleId(Long roleId) {
        return null;
    }

    @Override
    public List<SysMenu> selectMenuTreeByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Long> selectMenuListByRoleId(Long roleId) {
        return null;
    }

    @Override
    public List<RouterVo> buildMenus(List<SysMenu> menus) {
        return null;
    }

    @Override
    public List<SysMenu> buildMenuTree(List<SysMenu> menus) {
        return null;
    }

    @Override
    public List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus) {
        return null;
    }

    @Override
    public SysMenu selectMenuById(Long menuId) {
        return null;
    }

    @Override
    public boolean hasChildByMenuId(Long menuId) {
        return false;
    }

    @Override
    public boolean checkMenuExistRole(Long menuId) {
        return false;
    }

    @Override
    public int insertMenu(SysMenu menu) {
        return 0;
    }

    @Override
    public int updateMenu(SysMenu menu) {
        return 0;
    }

    @Override
    public int deleteMenuById(Long menuId) {
        return 0;
    }

    @Override
    public boolean checkMenuNameUnique(SysMenu menu) {
        return false;
    }
}
