package cglib;

public class Advice {

    public void before(){
        System.out.println("Before Enhance Cglib");
    }

    public void afterReturning(){
        System.out.println("After Enhance Cglib");
    }

}
