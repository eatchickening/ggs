package io.chicken.ggs.common.vo;

import java.util.List;

public class AwardInfoSchoolVo {
    private Long id;
    private String awardname;


    private String awardlevel;

    private String remark;

    List<AwardClasslVo> awardClasslVoList;

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

    public List<AwardClasslVo> getAwardClasslVoList() {
        return awardClasslVoList;
    }

    public void setAwardClasslVoList(List<AwardClasslVo> awardClasslVoList) {
        this.awardClasslVoList = awardClasslVoList;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AwardInfoSchoolVo{" +
                "id=" + id +
                ", awardname='" + awardname + '\'' +
                ", awardlevel='" + awardlevel + '\'' +
                ", remark='" + remark + '\'' +
                ", awardClasslVoList=" + awardClasslVoList +
                ", awardFileList=" + awardFileList +
                ", awardQuotaList=" + awardQuotaList +
                '}';
    }
}