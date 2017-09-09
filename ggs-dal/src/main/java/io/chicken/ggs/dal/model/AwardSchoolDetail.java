package io.chicken.ggs.dal.model;

import io.chicken.ggs.common.vo.AwardQuotaShowVo;

import java.util.Date;
import java.util.List;

public class AwardSchoolDetail {

    private Long id;

    private String name;
    private String schoolcode;
    private String areacode;

    private String areaname;
    private String schooltype;
    private String schoolname;

    private List<AwardQuotaShowVo> awardquota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSchoolcode() {
        return schoolcode;
    }

    public void setSchoolcode(String schoolcode) {
        this.schoolcode = schoolcode;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getSchooltype() {
        return schooltype;
    }

    public void setSchooltype(String schooltype) {
        this.schooltype = schooltype == null ? null : schooltype.trim();
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public List<AwardQuotaShowVo> getAwardquota() {
        return awardquota;
    }

    public void setAwardquota(List<AwardQuotaShowVo> awardquota) {
        this.awardquota = awardquota;
    }

    @Override
    public String toString() {
        return "AwardSchoolDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", schoolcode='" + schoolcode + '\'' +
                ", areacode='" + areacode + '\'' +
                ", areaname='" + areaname + '\'' +
                ", schooltype='" + schooltype + '\'' +
                ", schoolname='" + schoolname + '\'' +
                ", awardInfoList=" + awardquota +
                '}';
    }
}