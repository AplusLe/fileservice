package com.aplus.fileservice.pattern.statePattern;


/**
 *  没有硬币的状态
 */
public class NoQuarterState extends State {

    // 上下文建立关系
     private final CandyMachine candyMachine;

    public NoQuarterState(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("投入一枚硬币");
        // 状态模式状态转换
        candyMachine.setState(candyMachine.hasQuarterState);
    }

    @Override
    public void ejectQuarter() {
        System.out.println("没有硬币，无法取出");
    }

    @Override
    public void pullCandy() {
        System.out.println("请先投币,无法抓取糖果");
    }

    @Override
    public void dispense() {
        System.out.println("请先投币，无法获得糖果");
    }
}
