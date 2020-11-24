package com.aplus.fileservice.pattern.statePattern;

/**
 * 状态模式
 *  允许对象在内部状态发生改变时改变它的行为，对象看起来好像修改了它的类
 *  对象的行为依赖于它的状态（属性），并且可以根据它的状态改变而改变它的相关行为 eg:流程
 *  优点：
 *   1、封装了转换规则。 2、枚举可能的状态，在枚举状态之前需要确定状态种类。
 *   3.将所有与某个状态有关的行为放到一个类中，并且可以方便地增加新的状态，只需要改变对象状态即可改变对象的行为
 *   4、允许状态转换逻辑与状态对象合成一体，而不是某一个巨大的条件语句块。 5、可以让多个环境对象共享一个状态对象，从而减少系统中对象的个数。
 *
 *  缺点：
 *   1、状态模式的使用必然会增加系统类和对象的个数。 2、状态模式的结构与实现都较为复杂，如果使用不当将导致程序结构和代码的混乱。
 *   3、状态模式对"开闭原则"的支持并不太好，对于可以切换状态的状态模式，增加新的状态类需要修改那些负责状态转换的源代码，
 *   否则无法切换到新增状态，而且修改某个状态类的行为也需修改对应类的源代码。
 *
 *   注意：在行为受状态约束的时候使用状态模式，而且状态不超过 5 个。
 */
public class CandyMachine extends State{
    public State noQuarterState = new NoQuarterState(this);
    public State hasQuarterState = new HasQuarterState(this);
    public State soldState = new SoldState(this);
    public State soldOutState  = new SoldOutState();

    private State state = soldState;
    private int count;

    public CandyMachine(int count) {
        this.count = count;
        if (count > 0) {
            setState(noQuarterState);
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void insertQuarter() {
        state.insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    @Override
    public void pullCandy() {
        state.pullCandy();
    }

    @Override
    public void dispense() {
        state.dispense();
    }

    public static void main(String[] args) {
        CandyMachine candyMachine = new CandyMachine(2);
        candyMachine.insertQuarter();
        candyMachine.pullCandy();
        candyMachine.dispense();
        candyMachine.insertQuarter();
        candyMachine.pullCandy();
        candyMachine.dispense();
        candyMachine.insertQuarter();
        System.out.println(candyMachine.getState());

    }
}
