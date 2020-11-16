package com.aplus.fileservice.file.entity;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/10 10:43
 */
public class RichManHaircut extends Haircut{
    @Override
    protected void chooseHair() {
        System.out.println("选择托尼老师");
    }

    @Override
    protected void shampoo() {
        System.out.println("使用昂贵的洗发水");
    }
}
