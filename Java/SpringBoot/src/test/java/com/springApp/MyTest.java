package com.springApp;

import com.appSpring.HelloSpring;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyTest {

    @Autowired
    HelloSpring helloSpring;

    @Test
    void testHello() {
        helloSpring.sayHello();
    }

}
