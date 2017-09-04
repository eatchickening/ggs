package io.chicken.ggs.common.vo;

import java.util.Date;
import java.util.List;

public class AwardInfoVo {

    private String awardname;


    private String awardlevel;

    private String remark;

    List<AwardSchoolVo> awardSchoolList;

    List<AwardFileVo> awardFileList;

    List<AwardQuotaVo> awardQuotaList;

    public String getAwardname() {
        return awardname;
    }

    public void setAwardname(String awardname) {
        this.awardname = awardname;
    }



    public String getAwardlevel() {
        return awardlevel;
    }

    public void setAwardlevel(String awardlevel) {
        this.awardlevel = awardlevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<AwardSchoolVo> getAwardSchoolList() {
        return awardSchoolList;
    }

    public void setAwardSchoolList(List<AwardSchoolVo> awardSchoolList) {
        this.awardSchoolList = awardSchoolList;
    }

    public List<AwardFileVo> getAwardFileList() {
        return awardFileList;
    }

    public void setAwardFileList(List<AwardFileVo> awardFileList) {
        this.awardFileList = awardFileList;
    }

    public List<AwardQuotaVo> getAwardQuotaList() {
        return awardQuotaList;
    }

    public void setAwardQuotaList(List<AwardQuotaVo> awardQuotaList) {
        this.awardQuotaList = awardQuotaList;
    }

    @Override
    public String toString() {
        return "AwardInfoVo{" +
                "awardname='" + awardname + '\'' +
                ", awardlevel='" + awardlevel + '\'' +
                ", remark='" + remark + '\'' +
                ", awardSchoolList=" + awardSchoolList +
                ", awardFileList=" + awardFileList +
                ", awardQuotaList=" + awardQuotaList +
                '}';
    }
}