/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.common;

/**
 * 评优活动的状态
 *
 * @author wung 2017/9/4.
 */
public enum AppraisedActivityStatusEnum {
    NOT_START(1, "未开始"),
    STARTING(2, "进行中"),
    END(3, "已结束"),
    ;

    private Integer code;
    private String desc;

    AppraisedActivityStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static AppraisedActivityStatusEnum valueOf(Integer code) {
        if (code == null) {
            return null;
        }
        AppraisedActivityStatusEnum[] enums = AppraisedActivityStatusEnum.values();
        for (AppraisedActivityStatusEnum appraisedActivityStatusEnum : enums) {
            if (appraisedActivityStatusEnum.getCode().equals(code)) {
                return appraisedActivityStatusEnum;
            }
        }
        return null;
    }

    public static String getDesc(Integer code) {
        AppraisedActivityStatusEnum appraisedActivityStatusEnum = valueOf(code);
        if (appraisedActivityStatusEnum != null) {
            return appraisedActivityStatusEnum.getDesc();
        }
        return null;
    }
}
