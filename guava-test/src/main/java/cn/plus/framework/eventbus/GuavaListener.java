package cn.plus.framework.eventbus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public interface GuavaListener<E extends GuavaEvent> {
    public static final Log log = LogFactory.getLog(GuavaListener.class);
    /**
     *
     * 监听设置
     * @param event
     */
    @AllowConcurrentEvents
    @Subscribe
    public default void lister(E event){
        log.info("accept event "+event.getClass().getSimpleName());
    }


}
