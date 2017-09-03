package io.chicken.ggs.dal.model;

import java.util.Date;

public class AwardInfo {
    private Long id;

    private String appraisecode;

    private String awardname;

    private String awardcode;

    private String awardlevel;

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

    public String getAwardname() {
        return awardname;
    }

    public void setAwardname(String awardname) {
        this.awardname = awardname == null ? null : awardname.trim();
    }

    public String getAwardcode() {
        return awardcode;
    }

    public void setAwardcode(String awardcode) {
        this.awardcode = awardcode == null ? null : awardcode.trim();
    }

    public String getAwardlevel() {
        return awardlevel;
    }

    public void setAwardlevel(String awardlevel) {
        this.awardlevel = awardlevel == null ? null : awardlevel.trim();
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