package cn.plus.framework.quartz2.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author plus me
 * @date 2018/6/29
 */

@Component
public class PlusScheduleRedisBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.err.println("PlusScheduleRedisBeanFactoryPostProcessor --- ok");
    }
}
