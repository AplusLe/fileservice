package com.aplus.fileservice.pattern.prototypePattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/26 19:43
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println(" Rectangle  draw");
    }
}
