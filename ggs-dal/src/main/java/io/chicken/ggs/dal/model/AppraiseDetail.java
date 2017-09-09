package io.chicken.ggs.dal.model;

import java.util.List;

public class AppraiseDetail extends Appraise{
    List<AwardInfoDetail> awardInfoList;

    List<AwardSchoolDetail> awardSchoolDetailList;

    public List<AwardInfoDetail> getAwardInfoList() {
        return awardInfoList;
    }

    public void setAwardInfoList(List<AwardInfoDetail> awardInfoList) {
        this.awardInfoList = awardInfoList;
    }

    public List<AwardSchoolDetail> getAwardSchoolDetailList() {
        return awardSchoolDetailList;
    }

    public void setAwardSchoolDetailList(List<AwardSchoolDetail> awardSchoolDetailList) {
        this.awardSchoolDetailList = awardSchoolDetailList;
    }
}