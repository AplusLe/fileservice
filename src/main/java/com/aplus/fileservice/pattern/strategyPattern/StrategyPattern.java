package com.aplus.fileservice.pattern.strategyPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/20 19:08
 */


/**
 * 策略模式
 */
public class StrategyPattern {
    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext(new AddStrategy());
        System.out.println(strategyContext.executeStrategy(1,2));
        strategyContext.setStrategy(new SubtractStrategy());
        System.out.println(strategyContext.executeStrategy(1,2));

    }
}
