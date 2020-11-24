package com.aplus.fileservice.pattern.bridgePattern;

/**
 * 桥接模式：
 * 将抽象和实现放在两个不同的类层次中，使它们可以独立地变化
 * 将类的功能层次结构和实现层次结构相分离，使二者能够独立地变化，并在两者之间搭建桥梁，实现桥接。
 *
 * 优点：1、抽象和实现的分离。 2、优秀的扩展能力。 3、实现细节对客户透明。
 * 缺点：桥接模式的引入会增加系统的理解与设计难度，由于聚合关联关系建立在抽象层，要求开发者针对抽象进行设计与编程。
 *
 * 使用场景：
 *  1、如果一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性，避免在两个层次之间建立静态的继承联系
 *  ，通过桥接模式可以使它们在抽象层建立一个关联关系。 比如说 JDBC的实现
 *  2、对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥接模式尤为适用。
 *  3、一个类存在两个独立变化的维度，且这两个维度都需要进行扩展。
 */
public class Circle extends Shape {

    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }

    public static void main(String[] args) {
        Shape circle = new Circle(5, 5, 2, new RedCircle());
        circle.draw();
    }
}
