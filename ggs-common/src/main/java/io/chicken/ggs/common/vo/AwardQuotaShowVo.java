package io.chicken.ggs.common.vo;

public class AwardQuotaShowVo {

    private String schoolquota;

    private String awardcode;

    private String awardname;

    public String getSchoolquota() {
        return schoolquota;
    }

    public void setSchoolquota(String schoolquota) {
        this.schoolquota = schoolquota;
    }

    public String getAwardcode() {
        return awardcode;
    }

    public void setAwardcode(String awardcode) {
        this.awardcode = awardcode;
    }

    public String getAwardname() {
        return awardname;
    }

    public void setAwardname(String awardname) {
        this.awardname = awardname;
    }

    @Override
    public String toString() {
        return "AwardQuotaShowVo{" +
                "schoolquota='" + schoolquota + '\'' +
                ", awardcode='" + awardcode + '\'' +
                ", awardname='" + awardname + '\'' +
                '}';
    }
}