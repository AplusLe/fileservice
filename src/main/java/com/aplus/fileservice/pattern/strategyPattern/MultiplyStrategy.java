package com.aplus.fileservice.pattern.strategyPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/20 19:07
 */
public class MultiplyStrategy implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
