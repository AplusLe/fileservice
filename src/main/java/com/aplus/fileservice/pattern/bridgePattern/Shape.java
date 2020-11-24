package com.aplus.fileservice.pattern.bridgePattern;

public abstract class Shape {
    DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
