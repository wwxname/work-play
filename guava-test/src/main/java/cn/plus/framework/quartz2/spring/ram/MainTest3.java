package cn.plus.framework.quartz2.spring.ram;

import cn.plus.framework.quartz2.DemoJobBean;
import cn.plus.framework.quartz2.PlusMethodInvokingJobDetailFactoryBean;
import cn.plus.framework.quartz2.example.HelloJob;
import org.quartz.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author plus me
 * @date 2018/6/19
 */
class A implements Serializable {
    public void test() {
        System.err.println("123");
    }
}

public class MainTest3 {
    public static void main(String args[]) throws Exception {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        Resource resource = new ClassPathResource("ram-quartz.properties");
        schedulerFactoryBean.afterPropertiesSet();

        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(HelloJob.class);
        jobDetailFactoryBean.setName("ram-01");
        jobDetailFactoryBean.setGroup("wwx");
        jobDetailFactoryBean.afterPropertiesSet();


        PlusMethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean;
        methodInvokingJobDetailFactoryBean = new PlusMethodInvokingJobDetailFactoryBean();
        methodInvokingJobDetailFactoryBean.setGroup("wwx");
        methodInvokingJobDetailFactoryBean.setBeanClassLoader(methodInvokingJobDetailFactoryBean.getClass().getClassLoader());
        methodInvokingJobDetailFactoryBean.setName("ram-01");
        methodInvokingJobDetailFactoryBean.setConcurrent(false);
        methodInvokingJobDetailFactoryBean.setTargetClass(A.class);
        methodInvokingJobDetailFactoryBean.setTargetObject(new A());
        methodInvokingJobDetailFactoryBean.setTargetMethod("test");
        methodInvokingJobDetailFactoryBean.afterPropertiesSet();
        JobDetail jobDetail = methodInvokingJobDetailFactoryBean.getObject();
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        simpleTriggerFactoryBean.setGroup("wwx");
        simpleTriggerFactoryBean.setName("mysql-test-1");
        simpleTriggerFactoryBean.setRepeatInterval(100000);
        simpleTriggerFactoryBean.setStartDelay(0);
        simpleTriggerFactoryBean.setStartTime(new Date());
        simpleTriggerFactoryBean.afterPropertiesSet();
        SimpleTrigger trigger = simpleTriggerFactoryBean.getObject();

        schedulerFactoryBean.getScheduler().scheduleJob(jobDetail, trigger);
        schedulerFactoryBean.start();

    }
}
