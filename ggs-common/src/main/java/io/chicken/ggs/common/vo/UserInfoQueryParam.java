/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.common.vo;

import java.io.Serializable;

/**
 * 用户列表查询条件
 *
 * @author wung 2017/8/25.
 */
public class UserInfoQueryParam implements Serializable {
    private static final long serialVersionUID = -794023287671347775L;

    private Integer pageNum;

    private Integer pageSize;

    private String account;

    private String username;

    private String departcode;

    private String departName;

    private String postcode;

    private String postName;

    private String organcode;

    private String organName;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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

    @Override
    public String toString() {
        return "UserInfoQueryParam{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", departcode='" + departcode + '\'' +
                ", departName='" + departName + '\'' +
                ", postcode='" + postcode + '\'' +
                ", postName='" + postName + '\'' +
                ", organcode='" + organcode + '\'' +
                ", organName='" + organName + '\'' +
                '}';
    }
}
