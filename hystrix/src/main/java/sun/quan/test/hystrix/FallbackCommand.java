package sun.quan.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunquan on 16/8/2.
 */
public class FallbackCommand extends HystrixCommand<String> {

    private final String name;

    public FallbackCommand(String name){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("FallbackCommand"))
        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(500)));
        this.name = name;
    }
    protected String run() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1000);
        return "Hello " + name +" thread:" + Thread.currentThread().getName();
    }

    @Override
    protected String getFallback() {
        return "exeucute Falled";
    }

    public static void main(String[] args) throws Exception{
        for(int i = 0; i < 100; i++) {
            FallbackCommand helloWorldCommand = new FallbackCommand("Synchronous-hystrix");
            long l = System.currentTimeMillis();
            String result = helloWorldCommand.execute();
            l = System.currentTimeMillis() - l;
            System.out.println("result:" + result + ",span:" + l);
        }
    }



}
