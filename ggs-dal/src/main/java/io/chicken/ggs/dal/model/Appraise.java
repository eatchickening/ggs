package io.chicken.ggs.dal.model;

import java.util.Date;

public class Appraise {
    private Long id;

    private String appraisedate;

    private String appraisename;

    private String appraisecode;

    private String appraiselevel;

    private Integer appraisenumber;

    private Integer appraiseschool;

    private Integer appraisequota;

    private String  operator;
    private String organcode;
    private String remark;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppraisedate() {
        return appraisedate;
    }

    public void setAppraisedate(String appraisedate) {
        this.appraisedate = appraisedate == null ? null : appraisedate.trim();
    }

    public String getAppraisename() {
        return appraisename;
    }

    public void setAppraisename(String appraisename) {
        this.appraisename = appraisename == null ? null : appraisename.trim();
    }

    public String getAppraisecode() {
        return appraisecode;
    }

    public void setAppraisecode(String appraisecode) {
        this.appraisecode = appraisecode == null ? null : appraisecode.trim();
    }

    public String getAppraiselevel() {
        return appraiselevel;
    }

    public void setAppraiselevel(String appraiselevel) {
        this.appraiselevel = appraiselevel == null ? null : appraiselevel.trim();
    }

    public Integer getAppraisenumber() {
        return appraisenumber;
    }

    public void setAppraisenumber(Integer appraisenumber) {
        this.appraisenumber = appraisenumber;
    }

    public Integer getAppraiseschool() {
        return appraiseschool;
    }

    public void setAppraiseschool(Integer appraiseschool) {
        this.appraiseschool = appraiseschool;
    }

    public Integer getAppraisequota() {
        return appraisequota;
    }

    public void setAppraisequota(Integer appraisequota) {
        this.appraisequota = appraisequota;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode;
    }
}