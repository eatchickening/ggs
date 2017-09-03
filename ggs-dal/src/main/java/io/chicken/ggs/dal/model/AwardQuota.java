package io.chicken.ggs.dal.model;

import java.util.Date;

public class AwardQuota {
    private Long id;

    private String appraisecode;

    private String awardcode;

    private String awardquota;

    private String quotacontent;

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

    public String getAwardquota() {
        return awardquota;
    }

    public void setAwardquota(String awardquota) {
        this.awardquota = awardquota == null ? null : awardquota.trim();
    }

    public String getQuotacontent() {
        return quotacontent;
    }

    public void setQuotacontent(String quotacontent) {
        this.quotacontent = quotacontent == null ? null : quotacontent.trim();
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