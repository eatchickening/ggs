package io.chicken.ggs.common.vo;

import java.util.Date;

public class AwardSchoolVo {



    private String schoolcode;

    private Integer schoolquota;

    private String remark;

    private Date createTime;



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

    @Override
    public String toString() {
        return "AwardSchoolVo{" +
                ", schoolcode='" + schoolcode + '\'' +
                ", schoolquota=" + schoolquota +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}