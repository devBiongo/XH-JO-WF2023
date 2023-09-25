package com.jo.web.controller.system;


import com.jo.common.core.model.SearchModel;
import com.jo.system.domain.po.SysCompanyPo;
import com.jo.system.service.ISysCompanyService;
import com.jo.web.param.CompanyParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Joffrey
 * @since 2023-09-19
 */
@RestController
public class SysCompanyController {

    @Autowired
    private ISysCompanyService sysCompanyService;

    @PostMapping("/fetchCompanies")
    public List<SysCompanyPo> fetchCompanies(@RequestBody SearchModel<SysCompanyPo> searchModel) {
        return sysCompanyService.list(searchModel.getQueryModel());
    }

    @PostMapping("/addCompany")
    public void addCompany(@RequestBody CompanyParam companyParam){
        System.out.println(companyParam);
    }

}
