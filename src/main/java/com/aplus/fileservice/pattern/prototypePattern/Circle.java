package com.aplus.fileservice.pattern.prototypePattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/26 19:57
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println(" Circle  draw");
    }
}
