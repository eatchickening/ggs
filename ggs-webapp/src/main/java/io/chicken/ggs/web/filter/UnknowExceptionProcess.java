package io.chicken.ggs.web.filter;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mengxiangxiang on 2017/9/6.
 */
@ControllerAdvice
public class UnknowExceptionProcess {
    public static final Logger logger = LoggerFactory.getLogger(UnknowExceptionProcess.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result jsonErrorHandler(Exception e) {
        logger.error("发生未知错误",e);
        Result result=  new Result<>(ResultCode.SYS_EXCEPTION);
        return result;
    }

}
