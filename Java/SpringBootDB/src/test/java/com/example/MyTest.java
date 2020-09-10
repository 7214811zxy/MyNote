package com.example;

import com.app.basic.SpringHelloWorld;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MyTest {

    @Resource(name="springHello")
    SpringHelloWorld springHelloWorld;

    @Test
    public void test(){

        springHelloWorld.sayHello();
    }
}
