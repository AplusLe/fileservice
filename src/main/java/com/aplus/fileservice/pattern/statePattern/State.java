package com.aplus.fileservice.pattern.statePattern;

public abstract class State {

    // 状态1 投入硬币
    public abstract void insertQuarter();

    // 状态2 退还硬币
    public abstract void ejectQuarter();

    // 状态3 抓取糖果
    public abstract void pullCandy();

    // 状态3 发糖果
    public abstract void  dispense();

    public void returnQuarter() {
        System.out.println("退币……");
    }
}
