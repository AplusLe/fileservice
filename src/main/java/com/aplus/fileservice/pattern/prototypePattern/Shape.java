package com.aplus.fileservice.pattern.prototypePattern;

/**
 * 原型抽象
 */
public abstract class Shape implements Cloneable{  // 实现 java.lang.Cloneable 接口
    private String id;
    protected String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    abstract void draw();

    @Override
    protected Object clone() {  // 定义,实现复制现有实例来生成新实例的方法
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
