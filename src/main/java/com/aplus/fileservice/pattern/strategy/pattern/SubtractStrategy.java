package com.aplus.fileservice.pattern.strategy.pattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/20 19:04
 */

/**
 * 策略B
 */
public class SubtractStrategy implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
