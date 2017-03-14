package sun.quan.test.spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by sunquan on 16/8/11.
 */

public class SleepHelperPojo {

    public void beforeSleep(){
        System.out.println("睡觉前要脱衣服!");
    }

    public void afterSleep(){
        System.out.println("睡醒了要穿衣服！");
    }

}
