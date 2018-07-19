package cn.plus.framework.eventbus;

import com.google.common.eventbus.*;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class GuavaEventBus{
    private static final AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(10));
    public static void register(GuavaListener listener,GuavaListener ...guavaListeners){
        asyncEventBus.register(listener);
        for(GuavaListener guavaListener :guavaListeners){
            asyncEventBus.register(guavaListener);
        }
    }
    public static void post(GuavaEvent event){
        asyncEventBus.post(event);
    }
}
