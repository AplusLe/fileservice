package com.aplus.fileservice.pattern.statePattern;

/**
 * 投入硬币的状态
 */
public class HasQuarterState extends State {

    private final CandyMachine candyMachine;

    public HasQuarterState(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("请勿重复投币");
        returnQuarter();
    }

    @Override
    public void ejectQuarter() {
        returnQuarter();
        candyMachine.setState(candyMachine.noQuarterState);
    }

    @Override
    public void pullCandy() {
        System.out.println("正在抓取糖果");
        candyMachine.setState(candyMachine.soldState);
    }

    @Override
    public void dispense() {
        System.out.println("请先选择糖果");
    }
}
