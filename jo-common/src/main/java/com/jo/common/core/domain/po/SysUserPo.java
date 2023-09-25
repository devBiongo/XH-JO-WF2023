package com.jo.common.core.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_user")
public class SysUserPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id",type = IdType.AUTO)
    private Long userId;

    @TableField("company_id")
    private Long companyId;

    @TableField("dept_id")
    private Long deptId;

    @TableField("user_name")
    private String username;

    @TableField("nick_name")
    private String nickname;

    @TableField("user_type")
    private String usertype;

    private String email;

    @TableField("phone_number")
    private String phoneNumber;

    private String sex;

    private String avatar;

    private String password;

    private String status;

    @TableField("del_Flag")
    private String delFlag;

    @TableField("login_ip")
    private String loginIp;

    @TableField("login_date")
    private Date loginDate;

    @TableField("create_by")
    private String createBy;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_by")
    private String updateBy;

    @TableField("update_time")
    private Date updateTime;

    private String remark;
}
