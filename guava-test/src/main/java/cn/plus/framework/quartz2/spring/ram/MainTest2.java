package cn.plus.framework.quartz2.spring.ram;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.beans.PropertyVetoException;
import java.util.Date;

/**
 * @author plus me
 * @date 2018/6/19
 */

public class MainTest2 {

    public static SchedulerFactoryBean schedulerFactoryBean() throws Exception {
        Resource resource = new ClassPathResource("ram-quartz.properties");
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setConfigLocation(resource);
        schedulerFactoryBean.afterPropertiesSet();
        return schedulerFactoryBean;
    }

    public static void main(String args[]) throws Exception {
        Scheduler scheduler = schedulerFactoryBean().getScheduler();

        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(HelloJob.class);
        jobDetailFactoryBean.setGroup("wwx");
        jobDetailFactoryBean.setName("mysql-test-1");
        jobDetailFactoryBean.afterPropertiesSet();
        JobDetail job = jobDetailFactoryBean.getObject();
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        simpleTriggerFactoryBean.setGroup("wwx");
        simpleTriggerFactoryBean.setName("mysql-test-1");
        simpleTriggerFactoryBean.setRepeatInterval(1000);
        simpleTriggerFactoryBean.setStartDelay(0);
        simpleTriggerFactoryBean.setStartTime(new Date());
        simpleTriggerFactoryBean.afterPropertiesSet();
        SimpleTrigger trigger = simpleTriggerFactoryBean.getObject();
//        scheduler.scheduleJob(job, trigger);
        scheduler.start();

    }
}
