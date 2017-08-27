/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.common.vo;

import java.io.Serializable;

/**
 * 区域的详细信息，包括：机构，部门，岗位
 *
 * @author wung 2017/8/27.
 */
public class AreaDetailVO implements Serializable {
    private static final long serialVersionUID = 6221319764991073018L;

    private Integer areaId;

    private String areacode;

    private String areaName;


    private Integer organId;

    private String organcode;

    private String organName;


    private Integer departId;

    private String departcode;

    private String departName;


    private Integer postId;

    private String postcode;

    private String postName;


    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getOrganId() {
        return organId;
    }

    public void setOrganId(Integer organId) {
        this.organId = organId;
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

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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

    @Override
    public String toString() {
        return "AreaDetailVO{" +
                "areaId=" + areaId +
                ", areacode='" + areacode + '\'' +
                ", areaName='" + areaName + '\'' +
                ", organId=" + organId +
                ", organcode='" + organcode + '\'' +
                ", organName='" + organName + '\'' +
                ", departId=" + departId +
                ", departcode='" + departcode + '\'' +
                ", departName='" + departName + '\'' +
                ", postId=" + postId +
                ", postcode='" + postcode + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }
}
