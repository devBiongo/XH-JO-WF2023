package com.jo.system.domain.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jo.common.annotation.Excel;
import com.jo.common.annotation.Excel.ColumnType;
import lombok.Data;

import java.util.Date;

/**
 * @author ruoyi
 */
@Data
@TableName("sys_login_info")
public class SysLoginInfoPo {
    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @Excel(name = "序号", cellType = ColumnType.NUMERIC)
    private Long infoId;

    /**
     * 用户账号
     */
    @Excel(name = "用户账号")
    @TableField("user_name")
    private String userName;

    /**
     * 登录状态 0成功 1失败
     */
    @Excel(name = "登录状态", readConverterExp = "0=成功,1=失败")
    private String status;

    /**
     * 登录IP地址
     */
    @Excel(name = "登录地址")
    private String ipaddr;

    /**
     * 登录地点
     */
    @Excel(name = "登录地点")
    @TableField("login_location")
    private String loginLocation;

    /**
     * 浏览器类型
     */
    @Excel(name = "浏览器")
    private String browser;

    /**
     * 操作系统
     */
    @Excel(name = "操作系统")
    private String os;

    /**
     * 提示消息
     */
    @Excel(name = "提示消息")
    private String msg;

    /**
     * 访问时间
     */
    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField("login_time")
    private Date loginTime;

}
