package sun.quan.test.spring.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by sunquan on 16/8/11.
 */
public class SleepHelper implements MethodBeforeAdvice, AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("通常情况下睡觉之前要脱衣服！");
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("起床后要先穿衣服！");
    }
}
