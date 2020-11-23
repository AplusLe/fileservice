package com.aplus.fileservice.pattern.statePattern;

/**
 * 抓取糖果
 */
public class SoldState extends State {

    private final CandyMachine candyMachine;

    public SoldState(CandyMachine candyMachine) {
       this.candyMachine = candyMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("请勿重复投币");
        returnQuarter();
    }

    @Override
    public void ejectQuarter() {
        System.out.println("无法退币，正在发放糖果，请等待");

    }

    @Override
    public void pullCandy() {
        System.out.println("糖果抓取完成，请等待");
    }

    @Override
    public void dispense() {
        int candyCount = candyMachine.getCount();
        if ((candyCount > 0)) {
            System.out.println("分发一个糖果");
            candyCount --;
            candyMachine.setCount(candyCount);
            candyMachine.setState(candyCount > 0 ? candyMachine.noQuarterState : candyMachine.soldOutState);
        }
    }
}
