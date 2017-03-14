package sun.quan.test.spring.aop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.quan.test.spring.aop.Sleepable;

/**
 * Created by sunquan on 16/7/4.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-pojo.xml")
public class PojoTest {

    @Autowired
    Sleepable sleepable;

    @Test
    public void test3(){
        sleepable.sleep();
    }

}
