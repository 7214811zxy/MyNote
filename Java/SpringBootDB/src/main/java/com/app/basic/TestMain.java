package com.app.basic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {

    private static final List<Integer> list = new ArrayList<>(200);

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(()->{
            r();
        });

        Thread t2 = new Thread(() -> {
            r();
        });

        t1.start();
        t2.start();

        Thread.sleep(10000L);
        //printR();
    }

    private static void printR() {
        for(Integer i : list){
            System.out.println(i);
        }
    }

    public static void r() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
            System.out.println(i);

//            try {
//                Thread.sleep(10L);
//            } catch (InterruptedException e) {
//
//            }
        }
    }
}