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
    private String schoolname;
    private String areaname;
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

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getSchooltype() {
        return schooltype;
    }

    public void setSchooltype(String schooltype) {
        this.schooltype = schooltype;
    }
}
