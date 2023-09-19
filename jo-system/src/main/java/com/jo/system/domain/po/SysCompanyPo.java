package com.jo.system.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.Serial;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Joffrey
 * @since 2023-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_company")
public class SysCompanyPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 公司ID，自动递增
     */
    @TableId(value = "company_id", type = IdType.AUTO)
    private Long companyId;

    /**
     * 公司名称，不能为空
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 联系人姓名
     */
    @TableField("contact_name")
    private String contactName;

    /**
     * 联系人职务
     */
    @TableField("contact_title")
    private String contactTitle;

    /**
     * 联系人电话号码
     */
    @TableField("contact_phone")
    private String contactPhone;

    /**
     * 联系人电子邮件地址
     */
    @TableField("contact_email")
    private String contactEmail;

    /**
     * 公司地址
     */
    @TableField("company_address")
    private String companyAddress;

    /**
     * 公司成立日期
     */
    @TableField("established_date")
    private Date establishedDate;

    /**
     * 公司所属行业
     */
    @TableField("industry")
    private String industry;

    /**
     * 公司规模
     */
    @TableField("company_size")
    private String companySize;

    /**
     * 合作开始日期
     */
    @TableField("start_date")
    private Date startDate;

    /**
     * 合作结束日期（如果有）
     */
    @TableField("end_date")
    private Date endDate;

    /**
     * 合作状态，如活跃、暂停、终止等
     */
    @TableField("status")
    private String status;

    /**
     * 合作详情
     */
    @TableField("collaboration_details")
    private String collaborationDetails;

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    @TableField("create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;

    @TableField("update_time")
    private Date updateTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
