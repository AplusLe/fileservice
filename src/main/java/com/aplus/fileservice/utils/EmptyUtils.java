package com.aplus.fileservice.utils;

import com.aplus.fileservice.exception.BizException;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * @packae com.aplus.fileservice.utils
 * @auther Kevin
 * @date 08/07/2019 15:13
 */

public class EmptyUtils {
    private EmptyUtils() {
    }

    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String && obj.toString().length() == 0) {
            return true;
        }
        if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            return true;
        }
        if (obj instanceof Collection && ((Collection<?>) obj).isEmpty()) {
            return true;
        }
        return obj instanceof Map && ((Map<?,?>) obj).isEmpty();
    }

    /**
     * 判断对象是否非空
     *
     * @param objs
     * @return
     */
    public static boolean isNotEmpty(Object... objs) {
        if (ArrayUtils.isEmpty(objs)) {
            return false;
        }
        for (Object obj : objs) {
            if (isEmpty(obj)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否有空对象
     *
     * @param objs
     * @return
     */
    public static boolean isAnyEmpty(Object... objs) {
        if (ArrayUtils.isEmpty(objs)) {
            return true;
        }

        for (Object obj : objs) {
            if (isEmpty(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否都为空
     *
     * @param objs
     * @return
     */
    public static boolean isAllEmpty(Object... objs) {
        if (ArrayUtils.isEmpty(objs)) {
            return true;
        }

        for (Object obj : objs) {
            if (!isEmpty(obj)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断对象属性都为空
     *
     * @param obj
     * @return
     */
    public static boolean isAllFieldEmpty(Object obj) {
        Class stuCla = obj.getClass();
        Field[] fs = stuCla.getDeclaredFields();
        boolean flag = true;
        try {
            for (Field f : fs) {
                f.setAccessible(true);
                Object val = f.get(obj);
                // 只要有1个属性不为空,那么就不是所有的属性值都为空
                if (val != null) {
                    flag = false;
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            throw new BizException(e);
        }

        return flag;
    }

    /**
     * 不是所有对象属性都为空
     *
     * @param obj
     * @return
     */
    public static boolean notAllFieldEmpty(Object obj) {
        Class stuCla = obj.getClass();
        Field[] fs = stuCla.getDeclaredFields();

        boolean flag = false;
        try {
            for (Field f : fs) {
                f.setAccessible(true);
                Object val = f.get(obj);
                // 只要有1个属性不为空,那么就不是所有的属性值都为空
                if (val != null && val != "") {
                    flag = true;
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            throw new BizException(e);
        }

        return flag;
    }

}
