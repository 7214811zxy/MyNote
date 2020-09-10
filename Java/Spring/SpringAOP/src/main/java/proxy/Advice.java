package proxy;

public class Advice {

    public void before(){
        System.out.println("Before Enhance....");
    }

    public void afterReturning(){
        System.out.println("After Enhance");
    }



}
