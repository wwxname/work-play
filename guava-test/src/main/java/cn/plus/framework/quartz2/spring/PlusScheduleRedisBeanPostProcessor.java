package cn.plus.framework.quartz2.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author plus me
 * @date 2018/6/29
 */

@Component
public class PlusScheduleRedisBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("postProcessBeforeInitialization --- ok");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("postProcessAfterInitialization --- ok");
        return bean;
    }
}
