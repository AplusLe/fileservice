package com.aplus.fileservice.exception;

/**
 * @packae com.aplus.fileservice.exception
 * @auther Kevin
 * @date 08/07/2019 16:31
 */

import com.aplus.fileservice.enums.BizExceptionEnum;
import com.aplus.fileservice.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Response error(BizException e) {
        log.error(">>>>>>>> 业务异常:", e);
        return Response.error(e.getCode(), e.getErrorMessage());
    }

    /**
     * 拦截文件过大异常
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    public Response error(MaxUploadSizeExceededException e) {
        log.error(">>>>>>>> 上传文件过大:", e);
        return Response.error(BizExceptionEnum.FILE_TOO_LARGE);
    }

    /**
     * 类型不匹配
     */
    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    public Response error(TypeMismatchException e) {
        log.error(">>>>>>>> 参数类型不匹配:", e);
        return Response.error(e.getMessage());
    }

    /**
     * 请求方式错误
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Response error(HttpRequestMethodNotSupportedException e) {
        log.error(">>>>>>>> 请求方式错误:", e);
        return Response.error(e.getMessage());
    }

    /**
     * JSON parse error
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Response error(HttpMessageNotReadableException e) {
        log.error(">>>>>>>> JSON parse error:", e);
        return Response.error(e.getMessage());
    }

    /**
     * MissingServletRequestParameterException
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public Response error(MissingServletRequestParameterException e) {
        log.error(">>>>>>>> 缺少参数:", e);
        return Response.error(e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response serverError(Exception e) {
        log.error(">>>>>>>> 系统异常:", e);
        return Response.error(BizExceptionEnum.SERVICE_ERROR);
    }
}
