package com.aplus.fileservice.enums;

/**
 * @packae com.aplus.fileservice.enums
 * @auther Kevin
 * @date 08/07/2019 16:05
 */

public enum BizExceptionEnum implements IExceptionEnum {
    //系统
    DATE_PARSE_EXIST(600, "时间转换错误！"),


    //接口错误
    QUERY_STAFF_EXIST(700, "查询人员错误！"),
    PARAM_ERROR(701, "参数异常"),
    //未知异常
    SERVICE_ERROR(9999, "系统异常！"),

    //文件过大异常
    FILE_TOO_LARGE(501, "文件过大"),

    //文件上传异常
    FILE_UPLOAD_ERROR(500, "文件上传出错");

    BizExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }}
