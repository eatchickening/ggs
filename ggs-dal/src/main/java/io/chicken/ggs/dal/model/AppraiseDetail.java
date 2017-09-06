package io.chicken.ggs.dal.model;

import java.util.List;

public class AppraiseDetail extends Appraise{
    List<AwardInfo> awardInfoList;

    public List<AwardInfo> getAwardInfoList() {
        return awardInfoList;
    }

    public void setAwardInfoList(List<AwardInfo> awardInfoList) {
        this.awardInfoList = awardInfoList;
    }
}