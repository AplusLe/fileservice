package com.aplus.fileservice.pattern.statePattern;

public class SoldOutState extends State {

    public SoldOutState(CandyMachine candyMachine) {
    }

    @Override
    public void insertQuarter() {
        System.out.println("糖果已告罄");
        returnQuarter();
    }

    @Override
    public void ejectQuarter() {
        System.out.println("没有投币，无法退币");
    }

    @Override
    public void pullCandy() {
        System.out.println("糖果已告罄");
    }

    @Override
    public void dispense() {
        System.out.println("糖果已告罄");
    }
}
