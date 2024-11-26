package com.example.shoputils.exception;
import com.example.shoputils.resp.Result;
import com.example.shoputils.constants.HttpCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestControllerAdvice
public class RestCtrlExceptionHandler {
    private final Logger logger =
            LoggerFactory.getLogger(RestCtrlExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        logger.error("服务器抛出了异常：{}", e);
        return new Result<String>(HttpCode.FAILURE, "执⾏失败", e.getMessage());
    }
}