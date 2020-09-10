package springAnnoAspect;

import org.springframework.stereotype.Component;

// JoinPoint 连接点 —— 可以被增强的方法
@Component("Target")
public class Target implements TargetInterface {
    public void save() {
        System.out.println("saving...");
    }

    public void load(){
        System.out.println("loading...");
    }
}
