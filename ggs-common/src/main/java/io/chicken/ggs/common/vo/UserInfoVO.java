/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.common.vo;

import io.chicken.ggs.common.validator.groups.UserInfoControllerSave;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author wung 2017/8/24.
 */
public class UserInfoVO implements Serializable {
    private static final long serialVersionUID = -6397638642733642819L;

    private Integer id;

    @NotNull(message = "账号不能为空", groups = {UserInfoControllerSave.class})
    private String account;

    @NotNull(message = "昵称不能为空", groups = {UserInfoControllerSave.class})
    private String username;

    private String password;

    private String email;

    private String mobile;

    private String areacode;

    private String departcode;

    private String departName;

    private String postcode;

    private String postName;

    private String organcode;

    private String organName;

    private Date createTime;

    private Date updateTime;

    // 权限
    @NotNull(message = "权限不能为空", groups = {UserInfoControllerSave.class})
    private String menuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getDepartcode() {
        return departcode;
    }

    public void setDepartcode(String departcode) {
        this.departcode = departcode;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", areacode='" + areacode + '\'' +
                ", departcode='" + departcode + '\'' +
                ", departName='" + departName + '\'' +
                ", postcode='" + postcode + '\'' +
                ", postName='" + postName + '\'' +
                ", organcode='" + organcode + '\'' +
                ", organName='" + organName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", menuId=" + menuId +
                '}';
    }
}
