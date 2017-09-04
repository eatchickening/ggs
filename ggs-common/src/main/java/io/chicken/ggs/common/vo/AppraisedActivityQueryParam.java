/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.common.vo;

import java.io.Serializable;

/**
 * 评优活动列表查询条件
 *
 * @author wung 2017/9/4.
 */
public class AppraisedActivityQueryParam implements Serializable {

    private static final long serialVersionUID = -6454129136492784864L;

    private String activityName;

    private Integer pageNum;

    private Integer pageSize;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "AppraisedActivityQueryParam{" +
                "activityName='" + activityName + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
