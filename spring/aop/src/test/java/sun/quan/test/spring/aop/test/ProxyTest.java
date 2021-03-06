package sun.quan.test.spring.aop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.quan.test.spring.aop.Sleepable;

/**
 * Created by sunquan on 16/7/4.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-autoProxyCreator.xml")
public class ProxyTest {

    @Autowired
    Sleepable sleepable;

    @Test
    public void test1(){
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Sleepable sleeper = (Sleepable)appCtx.getBean("humanProxy");
        sleeper.sleep();
    }

    @Test
    public void test2(){
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext-autoProxyCreator.xml");
        Sleepable sleeper = (Sleepable)appCtx.getBean("human");
        sleeper.sleep();
    }

    @Test
    public void test3(){
        sleepable.sleep();
    }

}
