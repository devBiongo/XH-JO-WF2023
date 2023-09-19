package com.jo.web.param;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class CompanyParam {


    private Long companyId;

    /**
     * 公司名称，不能为空
     */
    private String companyName;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人职务
     */
    private String contactTitle;

    /**
     * 联系人电话号码
     */
    private String contactPhone;

    /**
     * 联系人电子邮件地址
     */
    private String contactEmail;

    /**
     * 公司地址
     */
    private String companyAddress;

    /**
     * 公司成立日期
     */
    private Date establishedDate;

    /**
     * 公司所属行业
     */
    private String industry;

    /**
     * 公司规模
     */
    private String companySize;

    /**
     * 合作开始日期
     */
    private Date startDate;

    /**
     * 合作结束日期（如果有）
     */
    private Date endDate;

    /**
     * 合作状态，如活跃、暂停、终止等
     */
    private String status;

    /**
     * 合作详情
     */
    private String collaborationDetails;

    /**
     * 备注
     */
    private String remark;
}


