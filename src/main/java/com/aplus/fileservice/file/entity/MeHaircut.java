package com.aplus.fileservice.file.entity;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/10 10:40
 */
public class MeHaircut extends Haircut{

    @Override
    protected void chooseHair() {
        System.out.println("选择麦克老师");
    }

    @Override
    protected void shampoo() {
        System.out.println("用便宜的洗发水");
    }
}
