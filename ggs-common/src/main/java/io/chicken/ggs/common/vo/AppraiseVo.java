package io.chicken.ggs.common.vo;

import java.util.List;

/**
 * 奖项信息表
 */
public class AppraiseVo {

    private String appraisedate;

    private String appraisename;

    private String appraisecode;

    private String appraiselevel;

    List<AwardInfoVo> awardInfoList;

    public String getAppraisedate() {
        return appraisedate;
    }

    public void setAppraisedate(String appraisedate) {
        this.appraisedate = appraisedate;
    }

    public String getAppraisename() {
        return appraisename;
    }

    public void setAppraisename(String appraisename) {
        this.appraisename = appraisename;
    }

    public String getAppraisecode() {
        return appraisecode;
    }

    public void setAppraisecode(String appraisecode) {
        this.appraisecode = appraisecode;
    }

    public String getAppraiselevel() {
        return appraiselevel;
    }

    public void setAppraiselevel(String appraiselevel) {
        this.appraiselevel = appraiselevel;
    }

    public List<AwardInfoVo> getAwardInfoList() {
        return awardInfoList;
    }

    public void setAwardInfoList(List<AwardInfoVo> awardInfoList) {
        this.awardInfoList = awardInfoList;
    }

    @Override
    public String toString() {
        return "AppraiseVo{" +
                "appraisedate='" + appraisedate + '\'' +
                ", appraisename='" + appraisename + '\'' +
                ", appraisecode='" + appraisecode + '\'' +
                ", appraiselevel='" + appraiselevel + '\'' +
                ", awardInfoList=" + awardInfoList +
                '}';
    }
}
