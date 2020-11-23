package com.aplus.fileservice.pattern.proxyPattern;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/19 18:39
 */
public class ProxyImage implements Image {

    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // do things...
        if (realImage == null) {
            // 建立代理关系
            realImage = new RealImage(fileName);
        }
        realImage.display();
        // do things ...
    }


}
