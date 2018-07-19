package cn.plus.framework.eventbus.example;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * @author plus me
 * @date 2018/6/14
 */
public class EventTest {
    public static void main(String args[]) {
        //ListenableFuture listenableFuture;
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture future = service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.err.println("wo  bei  huidiao le");
                throw new Exception();
                //return "AbstractHttpService";
            }
        });
        Futures.addCallback(future, new FutureCallback() {

            @Override
            public void onSuccess(Object result) {
                System.err.println(result);
                System.err.println("wo chengong le");            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                System.err.println("wo  shibai le");

            }
        });
        service.shutdown();


    }
}




