package com.jo.web.controller.system;

import com.jo.common.core.domain.po.SysUserPo;
import com.jo.common.core.model.SearchModel;
import com.jo.common.exception.ServiceException;
import com.jo.common.utils.SecurityUtils;
import com.jo.system.service.ISysUserService;
import com.jo.web.param.CompanyParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @PostMapping("/fetchUsers")
    public List<SysUserPo> fetchUsers(@RequestBody SearchModel<SysUserPo> searchModel) {
        List<SysUserPo> list = sysUserService.list(searchModel.getQueryModel());
        for (SysUserPo sysUserPo : list) {
            sysUserPo.setPassword(null);
        }
        return list;
    }

    @PostMapping("/addUser")
    public void addCompany(@RequestBody SysUserPo sysUser){
        if(!sysUserService.checkUserNameUnique(sysUser)){
            throw new ServiceException("記入したユーザーネームが既に存在しています。");
        }
        sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        sysUser.setCreateTime(new Date());
        sysUser.setCreateBy(SecurityUtils.getUsername());
        if(!sysUserService.save(sysUser)){
            throw new RuntimeException("更新が出来なかった。");
        }
    }
}
