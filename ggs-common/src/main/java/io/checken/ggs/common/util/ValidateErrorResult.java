/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package io.checken.ggs.common.util;

/**
 * 检验的错误信息包装类，包含属性名和错误信息
 *
 * @author wungmc 2017/7/26.
 */
public class ValidateErrorResult {

    /** 属性名称 */
    private String fieldName;

    /** 错误提示 */
    private String message;

    public ValidateErrorResult() {}

    public ValidateErrorResult(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ValidateErrorResult{" +
                "fieldName='" + fieldName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
