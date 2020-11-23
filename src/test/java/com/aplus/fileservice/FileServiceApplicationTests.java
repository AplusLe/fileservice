package com.aplus.fileservice;

import com.aplus.fileservice.pattern.proxyPattern.CglibProxyFactory;
import com.aplus.fileservice.pattern.proxyPattern.IndependentImage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceApplicationTests {


    @Test
    public void contextLoads() {
    }

    @Test
    public void test1(){
        for (int i = 0; i < 50; i++) {
          System.out.println(UUID.randomUUID().toString().replace("-",""));
        }
        // addAll 需要对对象判空;
//        String[]  x  = new String[] {"li","nbowen"};
//        // Arrays.asList 适配器设计模式 内核还是数组
//        List<String> strings = Arrays.asList(x);
//        strings.add("1");
    }
    @Test
    public  void test2() {
        IndependentImage image = new IndependentImage("精品独立图");
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(image);
        IndependentImage image2  = (IndependentImage)cglibProxyFactory.getProxyInstance();
        image2.display();
    }

}
