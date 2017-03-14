package sun.quan.test.spring.aop;

import org.aspectj.lang.annotation.*;

/**
 * Created by sunquan on 16/8/11.
 */

@Aspect
public class SleepHelperAspect {

    @Pointcut("execution(* *.sleep())")
    public void sleepPoint(){}

    @Before("sleepPoint()")
    public void beforeSleep(){
        System.out.println("睡觉前要脱衣服!");
    }

    @AfterReturning("sleepPoint()")
    public void afterSleep(){
        System.out.println("睡醒了要穿衣服！");
    }
}
