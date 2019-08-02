package com.aplus.fileservice.exception;

import com.aplus.fileservice.enums.BizExceptionEnum;
import com.aplus.fileservice.enums.IExceptionEnum;

/**
 * @packae com.aplus.fileservice.exception
 * @auther Kevin
 * @date 08/07/2019 15:32
 */

public class BizException extends RuntimeException {
    private Integer code;
    private String errorMessage;

    public BizException() {
        throw new BizException(BizExceptionEnum.SERVICE_ERROR);
    }

    public BizException(Integer code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public BizException(Exception e) {
        super(e);
        this.code = BizExceptionEnum.SERVICE_ERROR.getCode();
        this.errorMessage = BizExceptionEnum.SERVICE_ERROR.getMessage();
    }

    public BizException(String errorMessage, Exception e) {
        super(e);
        this.code = BizExceptionEnum.SERVICE_ERROR.getCode();
        this.errorMessage = errorMessage;
    }

    public BizException(IExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
