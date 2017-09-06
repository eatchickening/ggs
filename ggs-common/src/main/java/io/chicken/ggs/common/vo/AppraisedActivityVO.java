package io.chicken.ggs.common.vo;

import java.io.Serializable;
import java.util.Date;

// 评优活动列表
public class AppraisedActivityVO implements Serializable {

    private static final long serialVersionUID = -6958297465600625620L;

    private Long id;

    private String activityName;

    private Long appraiseId;

    private Date beginDate;

    private Date endDate;

    private Date signEndDate;

    private Integer activityStatus;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private String remark;

    // 评优级别
    private String appraiselevel;

    // 奖项数量
    private Integer appraisenumber;

    // 评优指标
    private Integer appraisequota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public Long getAppraiseId() {
        return appraiseId;
    }

    public void setAppraiseId(Long appraiseId) {
        this.appraiseId = appraiseId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getSignEndDate() {
        return signEndDate;
    }

    public void setSignEndDate(Date signEndDate) {
        this.signEndDate = signEndDate;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAppraiselevel() {
        return appraiselevel;
    }

    public void setAppraiselevel(String appraiselevel) {
        this.appraiselevel = appraiselevel;
    }

    public Integer getAppraisenumber() {
        return appraisenumber;
    }

    public void setAppraisenumber(Integer appraisenumber) {
        this.appraisenumber = appraisenumber;
    }

    public Integer getAppraisequota() {
        return appraisequota;
    }

    public void setAppraisequota(Integer appraisequota) {
        this.appraisequota = appraisequota;
    }

    @Override
    public String toString() {
        return "AppraisedActivityVO{" +
                "id=" + id +
                ", activityName='" + activityName + '\'' +
                ", appraiseId=" + appraiseId +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", signEndDate=" + signEndDate +
                ", activityStatus=" + activityStatus +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", appraiselevel='" + appraiselevel + '\'' +
                ", appraisenumber=" + appraisenumber +
                ", appraisequota=" + appraisequota +
                '}';
    }
}