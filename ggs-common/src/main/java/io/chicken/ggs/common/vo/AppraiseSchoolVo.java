package io.chicken.ggs.common.vo;

import java.util.List;

/**
 * 奖项信息表
 */
public class AppraiseSchoolVo {

    private Long id;
    private String appraisedate;

    private String appraisename;

    private String appraiselevel;
    private String  operator;
    private String organcode;
    List<AwardInfoSchoolVo> awardInfoList;

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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode;
    }

    public String getAppraiselevel() {
        return appraiselevel;
    }

    public void setAppraiselevel(String appraiselevel) {
        this.appraiselevel = appraiselevel;
    }

    public List<AwardInfoSchoolVo> getAwardInfoList() {
        return awardInfoList;
    }

    public void setAwardInfoList(List<AwardInfoSchoolVo> awardInfoList) {
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
        return "AppraiseSchoolVo{" +
                "id=" + id +
                ", appraisedate='" + appraisedate + '\'' +
                ", appraisename='" + appraisename + '\'' +
                ", appraiselevel='" + appraiselevel + '\'' +
                ", operator='" + operator + '\'' +
                ", organcode='" + organcode + '\'' +
                ", awardInfoList=" + awardInfoList +
                '}';
    }
}
