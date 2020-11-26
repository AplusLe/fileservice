package com.aplus.fileservice.pattern.prototypePattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/26 19:57
 */
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println(" Square  draw");
    }
}
