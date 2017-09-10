package io.chicken.ggs.dal.model;

import java.util.Date;

public class AwardClass {
    private Long id;

    private String appraisecode;

    private String awardcode;

    private String classcode;

    private String schoolcode;

    private Integer classquota;

    private String remark;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppraisecode() {
        return appraisecode;
    }

    public void setAppraisecode(String appraisecode) {
        this.appraisecode = appraisecode == null ? null : appraisecode.trim();
    }

    public String getAwardcode() {
        return awardcode;
    }

    public void setAwardcode(String awardcode) {
        this.awardcode = awardcode == null ? null : awardcode.trim();
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode == null ? null : classcode.trim();
    }

    public String getSchoolcode() {
        return schoolcode;
    }

    public void setSchoolcode(String schoolcode) {
        this.schoolcode = schoolcode == null ? null : schoolcode.trim();
    }

    public Integer getClassquota() {
        return classquota;
    }

    public void setClassquota(Integer classquota) {
        this.classquota = classquota;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}