package com.aplus.fileservice.pattern.strategyPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/20 19:47
 */
public class StrategyContext {
    private Strategy strategy;

    public StrategyContext(Strategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1,num2);
    }
}
