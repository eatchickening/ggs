package io.chicken.ggs.common;

/**
 *
 * 统用异常
 */
public class GGSException extends RuntimeException {

    private static final long serialVersionUID = 4481476441398126394L;

    protected Integer code = -1;

    private String message;

    private ResultCode resultCode;

    public GGSException() {
        super();
    }

    public GGSException(String message) {
        super(message);
    }

    public GGSException(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    public GGSException(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.message = resultCode.getMessage();
        this.code = resultCode.getCode();
    }

    public GGSException(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
        this.code = resultCode.getCode();
    }

    public GGSException(Throwable cause) {
        super(cause);
    }

    public GGSException(String message, Throwable cause) {
        super(message, cause);
    }

    public GGSException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
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

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
