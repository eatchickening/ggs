package io.chicken.ggs.common.vo;

import java.util.List;

/**
 * 奖项信息表
 */
public class AppraiseVo {

    private Long id;
    private String appraisedate;

    private String appraisename;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AppraiseVo{" +
                "appraisedate='" + appraisedate + '\'' +
                ", appraisename='" + appraisename + '\'' +
                ", id=" + id +
                ", appraiselevel='" + appraiselevel + '\'' +
                ", awardInfoList=" + awardInfoList +
                '}';
    }
}
