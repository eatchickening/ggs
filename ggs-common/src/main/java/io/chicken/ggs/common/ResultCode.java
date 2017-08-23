package io.chicken.ggs.common;

/**
 *
 * @author wungmc
 * @date 2017/6/20
 *
 */
public enum ResultCode {

    SUCCESS(0, "成功"),

    /**
     * 通用错误码 100
     */
    SYS_EXCEPTION(101, "系统异常"),
    OPERATION_REPEAT(103, "重复操作"),
    OPERATION_FAIL(104, "非法操作"),
    UN_OPERATION(105, "不可操作"),

    /**
     * 参数相关 200
     */
    PARAMETER_EMPTY(201, "参数为空"),
    PARAMETER_INVALID(202, "参数无效"),

    /**
     * 登录相关 300
     */
    LOGIN_FAIL(301, "用户名或密码错误"),
    LOGIN_EXCEPTION(302, "登录异常"),
    LOGIN_OLDPWD_ERROR(303, "原密码错误"),
    LOGIN_NO_LOGIN(304, "用户未登录或登录超时"),
    LOGIN_NO_AUTH(305, "权限不够"),

    /**
     * 数据库操作相关 400
     */
    DB_EXCEPTION(401, "数据库操作异常");

    ;

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
