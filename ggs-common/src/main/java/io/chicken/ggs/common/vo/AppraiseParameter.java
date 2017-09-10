package io.chicken.ggs.common.vo;

public class AppraiseParameter {

    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String appraisename;
    private String appraiseLevel;
    private String schoolcode;
    private String areacode;
    private String schooltype;
    private String organcode;

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

    public String getAppraisename() {
        return appraisename;
    }

    public void setAppraisename(String appraisename) {
        this.appraisename = appraisename;
    }

    public String getAppraiseLevel() {
        return appraiseLevel;
    }

    public void setAppraiseLevel(String appraiseLevel) {
        this.appraiseLevel = appraiseLevel;
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

    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode;
    }

    @Override
    public String toString() {
        return "AppraiseParameter{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", appraisename='" + appraisename + '\'' +
                ", appraiseLevel='" + appraiseLevel + '\'' +
                ", schoolcode='" + schoolcode + '\'' +
                ", areacode='" + areacode + '\'' +
                ", schooltype='" + schooltype + '\'' +
                ", organcode='" + organcode + '\'' +
                '}';
    }
}