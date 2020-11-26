package com.aplus.fileservice.pattern.prototypePattern;

import java.util.Hashtable;

/**
 * @description:
 * @author: libw
 * @time: 2020/11/26 20:15
 */

/**
 *  原型模式
 *  用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象  在运行期建立和删除原型
 *
 *  优点： 1、性能提高。 2、逃避构造函数的约束。
 *
 *  缺点： 1、配备克隆方法需要对类的功能进行通盘考虑，这对于全新的类不是很难，
 *  但对于已有的类不一定很容易，特别当一个类引用不支持串行化的间接对象，或者引用含有循环结构的时候。
 *  2、必须实现 Cloneable 接口。
 *
 * 使用场景
 *   1、资源优化场景。 2、类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。 3、性能和安全要求的场景。
 *   4、通过 new 产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。 5、一个对象多个修改者的场景。
 *   6、一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。
 *   7、在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过 clone 的方法创建一个对象
 *   ，然后由工厂方法提供给调用者。原型模式已经与 Java 融为浑然一体，大家可以随手拿来使用。
 */
public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap  =  new Hashtable<String, Shape>();

    private static  Shape getShape(String shapeId) {  //提供一个获取新实例的方法
        Shape shape = shapeMap.get(shapeId); //提供一个找出正确实例原型的方法
        return (Shape)shape.clone(); //委托复制实例的方法生成新实例
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }

    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape shape = ShapeCache.getShape("1");
        shape.setId("4");
        System.out.println(shape.getId());
        shape.draw();
    }
}
