package io.checken.ggs.common;


import io.checken.ggs.common.util.ValidateErrorResult;

import java.io.Serializable;

/**
 * 通用返回结果
 *
 * @param <T>
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -671853489104226104L;
    
    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 错误详细信息
     */
    private String message;

    /**
     * 操作是否成功
     */
    private boolean success = false;

    /**
     * 返回的数据，调用失败的是，返回数据为null
     */
    private T data;

    /**
     * 总数
     */
    private Long total;

    public Result() {}

    public Result(ResultCode respCode, String message) {
        this.code = respCode.getCode();
        this.message = message;

        if(respCode.getCode() == ResultCode.SUCCESS.getCode()){
            this.success = true;
        }
    }

    public Result(ResultCode respCode) {
        this.code = respCode.getCode();
        this.message = respCode.getMessage();

        if(respCode.getCode() == ResultCode.SUCCESS.getCode()){
            this.success = true;
        }
    }


    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;

        if(ResultCode.SUCCESS.getCode().equals(code)){
            this.success = true;
        }
    }

    public Result(T data, String code, String msg) {
        this.data = data;
        this.code = ResultCode.SUCCESS.getCode();
        if(msg == null || msg.isEmpty()){
            this.message = ResultCode.SUCCESS.getMessage();
        }else{
            this.message = msg;
        }
        this.success = true;
    }

    public Result(T data) {
        this.data = data;
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
        this.success = true;
    }

    public Result(ValidateErrorResult error) {
        this(ResultCode.PARAMETER_INVALID);
        this.message = error.getMessage();
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
