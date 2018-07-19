package cn.plus.framework.eventbus.example;

import cn.plus.framework.eventbus.GuavaEvent;
import cn.plus.framework.eventbus.GuavaListener;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * @author plus me
 * @date 2018/6/14
 */
public class DisListener implements GuavaListener{
    @AllowConcurrentEvents
    @Subscribe
    public void lister(DisErrEvent errEvent){
        System.err.println("err:"+errEvent.getInfo());
    }
    @AllowConcurrentEvents
    @Subscribe
    public  void lister(DisOkEvent okEvent){
        System.err.println("ok:"+okEvent.getInfo());
    }
}
