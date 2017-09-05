package io.chicken.ggs.dal.model;

import java.io.Serializable;
import java.util.Date;

public class ActivityFile implements Serializable {

    private static final long serialVersionUID = -5549197274699126295L;

    private Long id;

    private Long activityId;

    private String origFileName;

    private String sysFileName;

    private String fileType;

    private String filePath;

    private String fileDetail;

    private String remark;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getOrigFileName() {
        return origFileName;
    }

    public void setOrigFileName(String origFileName) {
        this.origFileName = origFileName == null ? null : origFileName.trim();
    }

    public String getSysFileName() {
        return sysFileName;
    }

    public void setSysFileName(String sysFileName) {
        this.sysFileName = sysFileName == null ? null : sysFileName.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileDetail() {
        return fileDetail;
    }

    public void setFileDetail(String fileDetail) {
        this.fileDetail = fileDetail == null ? null : fileDetail.trim();
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

    @Override
    public String toString() {
        return "ActivityFile{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", origFileName='" + origFileName + '\'' +
                ", sysFileName='" + sysFileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileDetail='" + fileDetail + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}