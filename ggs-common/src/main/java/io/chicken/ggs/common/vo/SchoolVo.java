package io.chicken.ggs.common.vo;

public class SchoolVo {

    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String schoolname;
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

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
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

    @Override
    public String toString() {
        return "SchoolVo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", schoolname='" + schoolname + '\'' +
                ", schoolcode='" + schoolcode + '\'' +
                ", areacode='" + areacode + '\'' +
                ", schooltype='" + schooltype + '\'' +
                '}';
    }
}