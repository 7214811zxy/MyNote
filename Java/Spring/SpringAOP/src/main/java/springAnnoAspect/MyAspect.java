package springAnnoAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Component("Aspect")
@Aspect // 声明这个bean是一个Aspect
public class MyAspect {

    // 配置前置增强通知
    // 配置切点表达式
    @Before("execution(* springAnnoAspect.*.save(..))")
    public void adviceBefore(){
        System.out.println("adviceBefore");
    }

    public void adviceAfter(){
        System.out.println("adviceAfter");
    }

    // 传入正在执行的切点ProceedingJoinPoint
    public Object adviceAround(ProceedingJoinPoint pjq) throws Throwable {
        System.out.println("aroundBefore");
        Object proceed = pjq.proceed(); // 执行切点方法
        System.out.println("aroundAfter");
        return proceed;
    }

}
