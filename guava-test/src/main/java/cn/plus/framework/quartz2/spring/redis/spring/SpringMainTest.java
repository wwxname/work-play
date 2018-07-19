package cn.plus.framework.quartz2.spring.redis.spring;/**
 * @author plus me
 * @date 2018/6/25
 */

import cn.plus.framework.spring.SpringContextUtils;
import javafx.application.Application;
import javafx.stage.Stage;
import net.joelinn.quartz.jobstore.RedisJobStore;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringMainTest   {

    private static Logger logger = LoggerFactory.getLogger(SpringMainTest.class);


    public static void main(String[] args) {
      //  LogFactory.
        logger.info("aaaaa");
        logger.debug("debug");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.err.println(classLoader);
        LogFactory.getFactory();
        AnnotationConfigApplicationContext context =  SpringContextUtils.getContext(
                "cn.plus.framework.quartz2.spring.redis.spring","cn.plus.framework.quartz2.spring.redis.spring");
        //context.re
        ScheduleServcie scheduleServcie = (ScheduleServcie) context.getBean("scheduleServcie");
        scheduleServcie.test();
        RedisJobStore redisJobStore;

    }


}
