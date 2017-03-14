package sun.quan.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunquan on 16/8/2.
 */
public class HelloWorldCommand extends HystrixCommand<String> {
    private final String name;

    public HelloWorldCommand(String name){
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }
    protected String run() throws Exception {
        return "Hello " + name +" thread:" + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws Exception{
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("Synchronous-hystrix");
        String result = helloWorldCommand.execute();
        System.out.println("result:" + result);

        helloWorldCommand = new HelloWorldCommand("Asynchronous-hystrix");
        //异步调用,可自由控制获取结果时机,
        Future<String> future = helloWorldCommand.queue();
        //get操作不能超过command定义的超时时间,默认:1秒
        result = future.get(100, TimeUnit.MILLISECONDS);
        System.out.println("result=" + result);
        System.out.println("mainThread=" + Thread.currentThread().getName());

        helloWorldCommand = new HelloWorldCommand("world");
        Observable<String> fs = helloWorldCommand.observe();
        fs.subscribe(new Action1<String>() {
            public void call(String s) {
                System.out.println("observable:" + s);
            }
        });

        fs.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                // onNext/onError完成之后最后回调
                System.out.println("execute onCompleted");
            }
            @Override
            public void onError(Throwable e) {
                // 当产生异常时回调
                System.out.println("onError " + e.getMessage());
                e.printStackTrace();
            }
            @Override
            public void onNext(String v) {
                // 获取结果后回调
                System.out.println("onNext: " + v);
            }
        });

    }



}
