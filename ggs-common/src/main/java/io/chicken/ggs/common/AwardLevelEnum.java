package io.chicken.ggs.common;


import org.springframework.util.StringUtils;

/**
 * 账户类型
 * 
 * @author xuliang.will
 * time : 2016年7月8日 下午3:31:54
 */
public enum AwardLevelEnum {
    CITYLEVEL("1", "市级"),
    AREALEVEL("2", "区级"),
	SCHOOLLEVEL("3", "校级");

    /** 代码 */
    private final String code;
    /** 信息 */
    private final String message;

    /**
     * 构造
     * @param code
     * @param message
     */
    AwardLevelEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取
     * @param code
     * @return
     */
    public static AwardLevelEnum getByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }

        for (AwardLevelEnum type : AwardLevelEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
