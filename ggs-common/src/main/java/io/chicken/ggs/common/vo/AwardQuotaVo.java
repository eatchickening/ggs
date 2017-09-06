package io.chicken.ggs.common.vo;

import java.util.Date;

public class AwardQuotaVo {


    private String awardquota;

    private String quotacontent;

    private String remark;



    public String getAwardquota() {
        return awardquota;
    }

    public void setAwardquota(String awardquota) {
        this.awardquota = awardquota == null ? null : awardquota.trim();
    }

    public String getQuotacontent() {
        return quotacontent;
    }

    public void setQuotacontent(String quotacontent) {
        this.quotacontent = quotacontent == null ? null : quotacontent.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }



    @Override
    public String toString() {
        return "AwardQuotaVo{" +
                ", awardquota='" + awardquota + '\'' +
                ", quotacontent='" + quotacontent + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}