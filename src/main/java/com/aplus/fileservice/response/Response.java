package com.aplus.fileservice.response;

import com.aplus.fileservice.enums.BizExceptionEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @packae com.aplus.fileservice.response
 * @auther Kevin
 * @date 08/07/2019 17:01
 */

/**
 * 响应前台
 *
 * @param <T>
 */
@Data
public class Response<T> implements Serializable {

    public static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";

    public static final String DEFAULT_ERROR_MESSAGE = "系统异常";

    public static final Integer DEFAULT_SUCCESS_CODE = 200;

    public static final Integer DEFAULT_ERROR_CODE = 9999;

    /**
     * 请求是否成功
     */
    private Boolean result;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应对象
     */
    private T data;

    public Response() {
    }

    public Response(Boolean result, Integer code, String message, T data) {
        this.result = result;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success() {
        return new Response<>(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, null);
    }

    public static <T> Response<T> success(T object) {
        return new Response<>(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, object);

    }

    public static <T> Response<T> success(Integer code, String message, T object) {
        return new Response<>(true, code, message, object);

    }

    public static <T> Response<T> error(String message) {
        return new Response<>(false, DEFAULT_ERROR_CODE, message, null);
    }

    public static <T> Response<T> error(Integer code, String message) {
        return new Response<>(false, code, message, null);
    }

    public static <T> Response<T> error(Integer code, String message, T object) {
        return new Response<>(false, code, message, object);
    }

    public static <T> Response<T> error(BizExceptionEnum errorEnum) {
        return new Response<>(false, errorEnum.getCode(), errorEnum.getMessage(), null);
    }

//    public static <T> Response<PageResult<T>> pageResult(IPage<T> page) {
//        return new Response<>(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, new PageResult<>(page));
//    }
}
