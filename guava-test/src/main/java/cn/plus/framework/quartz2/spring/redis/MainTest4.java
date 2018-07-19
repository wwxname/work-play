package cn.plus.framework.quartz2.spring.redis;

import cn.plus.framework.quartz2.PlusMethodInvokingJobDetailFactoryBean;
import cn.plus.framework.quartz2.example.HelloJob;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.core.QuartzScheduler;
import org.quartz.core.QuartzSchedulerThread;
import org.quartz.simpl.SimpleThreadPool;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author plus me
 * @date 2018/6/19
 */
class A implements Serializable {
    public static void test() {
        System.err.println("123");
    }
}

public class MainTest4 {
    public static void main(String args[]) throws Exception {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        Resource resource = new ClassPathResource("redis-quartz.properties");
        schedulerFactoryBean.setConfigLocation(resource);
        schedulerFactoryBean.afterPropertiesSet();

        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(HelloJob.class);
        jobDetailFactoryBean.setName("redis-01");
        jobDetailFactoryBean.setGroup("wwx");
        jobDetailFactoryBean.afterPropertiesSet();
        QuartzScheduler scheduler;
//Class.forName("org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean$StatefulMethodInvokingJob");
        PlusMethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean;
        methodInvokingJobDetailFactoryBean = new PlusMethodInvokingJobDetailFactoryBean();
        methodInvokingJobDetailFactoryBean.setConcurrent(false);
        methodInvokingJobDetailFactoryBean.setGroup("wwx");
        methodInvokingJobDetailFactoryBean.setBeanClassLoader(methodInvokingJobDetailFactoryBean.getClass().getClassLoader());
        methodInvokingJobDetailFactoryBean.setName("redis-01");
        methodInvokingJobDetailFactoryBean.setTargetClass(A.class);
        methodInvokingJobDetailFactoryBean.setTargetObject(new A());
        methodInvokingJobDetailFactoryBean.setTargetMethod("test");
        methodInvokingJobDetailFactoryBean.afterPropertiesSet();
        SimpleThreadPool simpleThreadPool;
        JobDetail jobDetail = methodInvokingJobDetailFactoryBean.getObject();
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        simpleTriggerFactoryBean.setGroup("wwx");
        simpleTriggerFactoryBean.setName("redis-01");
        simpleTriggerFactoryBean.setRepeatInterval(10000);
        simpleTriggerFactoryBean.setStartDelay(0);
        simpleTriggerFactoryBean.setStartTime(new Date());
        simpleTriggerFactoryBean.afterPropertiesSet();
        SimpleTrigger trigger = simpleTriggerFactoryBean.getObject();
        //schedulerFactoryBean.setTriggers(trigger);
        //schedulerFactoryBean.getScheduler().scheduleJob(jobDetail, trigger);
        //schedulerFactoryBean.getScheduler().scheduleJob(trigger);

        schedulerFactoryBean.start();


    }
}
