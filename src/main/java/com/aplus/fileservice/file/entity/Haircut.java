package com.aplus.fileservice.file.entity;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/10 10:14
 */

/**
 *  模板方法模式
 *
 *  模板方法  添加final修饰，不能被子类重写
 *  钩子方法
 *  公用方法
 *  抽象方法
 */
public abstract class Haircut {
    public final void haveHaircut () {
        chooseHair();
        wash();
        shampoo();
        pay();
    }
    // 子类必须实现的方法 比如说进去理发店选择洗头的老师
    protected abstract void chooseHair ();

    // 钩子方法 子类可以选择自己实现或者不实现
    protected void shampoo(){}

    // 洗头方法 公共方法 用private修饰
    private void wash() {
        System.out.println("开始洗头");
    }

    // 付钱方法 公共方法 用private修饰
    private void pay() {
        System.out.println("开始付钱");
    }
}
