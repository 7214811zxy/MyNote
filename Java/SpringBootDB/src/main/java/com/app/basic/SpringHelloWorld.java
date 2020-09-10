package com.app.basic;

import org.springframework.stereotype.Component;


@Component(value = "springHello")
public class SpringHelloWorld {
    public void sayHello(){
        System.out.println("HelloWorld");
    }
}
