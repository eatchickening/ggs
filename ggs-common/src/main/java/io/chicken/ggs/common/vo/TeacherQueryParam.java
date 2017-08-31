package io.chicken.ggs.common.vo;

import java.io.Serializable;

/**
 * Created by nyh on 8/28/17.
 */
public class TeacherQueryParam implements Serializable {
    private static final long serialVersionUID = -794023287671347775L;
    private Integer pageNum = 1;
    private Integer pageSize = 5;
    private String name;
    private String schoolcode;
    private String areacode;
    private String schooltype;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getSchoolcode() {
        return schoolcode;
    }

    public void setSchoolcode(String schoolcode) {
        this.schoolcode = schoolcode;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getSchooltype() {
        return schooltype;
    }

    public void setSchooltype(String schooltype) {
        this.schooltype = schooltype;
    }
}
