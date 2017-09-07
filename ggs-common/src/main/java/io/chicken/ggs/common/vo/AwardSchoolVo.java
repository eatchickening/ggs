package io.chicken.ggs.common.vo;

import java.util.Date;

public class AwardSchoolVo {
    private Long id;
    private String schoolcode;

    private Integer schoolquota;

    private String remark;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AwardSchoolVo{" +
                "id=" + id +
                ", schoolcode='" + schoolcode + '\'' +
                ", schoolquota=" + schoolquota +
                ", remark='" + remark + '\'' +
                '}';
    }
}