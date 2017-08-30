package io.chicken.ggs.common.vo;

public class StudentVo {

    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String schoolname;
    private String studentid;
    private String areacode;
    private String schooltype;
    private String name;

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

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentVo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", schoolname='" + schoolname + '\'' +
                ", studentid='" + studentid + '\'' +
                ", areacode='" + areacode + '\'' +
                ", schooltype='" + schooltype + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}