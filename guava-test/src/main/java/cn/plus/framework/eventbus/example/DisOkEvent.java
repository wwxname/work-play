package cn.plus.framework.eventbus.example;

import cn.plus.framework.eventbus.GuavaEvent;

/**
 * @author plus me
 * @date 2018/6/14
 */
public class DisOkEvent extends GuavaEvent<String>{
    public DisOkEvent(String s) {
        super(s);
    }
}
