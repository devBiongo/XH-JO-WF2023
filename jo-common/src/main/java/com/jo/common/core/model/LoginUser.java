package com.jo.common.core.model;

import java.io.Serial;
import java.util.Collection;
import java.util.Set;

import com.jo.common.core.domain.po.SysUserPo;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 登录用户身份权限
 *
 * @author ruoyi
 */
@Data
public class LoginUser implements UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 当前登录用户唯一标识
     */
    private String uuid;

    /**
     * 用户信息
     */
    private SysUserPo user;


    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 所属公司
     */
    private String company;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 登录时间
     */
    private Long loginTime;


    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 权限列表
     */
    private Set<String> permissions;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }


    public LoginUser(SysUserPo user, Set<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    @JSONField(serialize = false)
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * 账户是否未过期,过期无法验证
     */
    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     *
     */
    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     *
     */
    @JSONField(serialize = false)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     *
     */
    @JSONField(serialize = false)
    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
