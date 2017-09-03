package io.chicken.ggs.dal.model;

import java.util.Date;

public class AwardSchool {
    private Long id;

    private String appraisecode;

    private String awardcode;

    private String schoolcode;

    private Integer schoolquota;

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

    public String getSchoolcode() {
        return schoolcode;
    }

    public void setSchoolcode(String schoolcode) {
        this.schoolcode = schoolcode == null ? null : schoolcode.trim();
    }

    public Integer getSchoolquota() {
        return schoolquota;
    }

    public void setSchoolquota(Integer schoolquota) {
        this.schoolquota = schoolquota;
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