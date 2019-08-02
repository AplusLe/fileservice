package com.aplus.fileservice.enums;

/**
 * @packae com.aplus.fileservice.enums
 * @auther Kevin
 * @date 08/07/2019 16:02
 */

/**
 * 异常规范
 */
public interface IExceptionEnum {

    /**
     * 获取异常的状态码
     */
    Integer getCode();

    /**
     * 获取异常的提示信息
     */
    String getMessage();

}
