package com.aplus.fileservice.pattern.proxyPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/19 18:36
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFile(fileName);
    }

    private void loadFile(String fileName) {
        System.out.println("加载图片 Loading...");
    }

    @Override
    public void display() {
        System.out.println("展示图片"+fileName);
    }
}
