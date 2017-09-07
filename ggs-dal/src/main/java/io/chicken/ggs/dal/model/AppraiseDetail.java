package io.chicken.ggs.dal.model;

import java.util.List;

public class AppraiseDetail extends Appraise{
    List<AwardInfoDetail> awardInfoList;

    public List<AwardInfoDetail> getAwardInfoList() {
        return awardInfoList;
    }

    public void setAwardInfoList(List<AwardInfoDetail> awardInfoList) {
        this.awardInfoList = awardInfoList;
    }
}