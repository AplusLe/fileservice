package com.aplus.fileservice.pattern.proxyPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/19 19:56
 */
public class IndependentImage {
    private  String fileName;

    public  IndependentImage (){}

    public IndependentImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        System.out.println("展示图片" + fileName);
    }
}
