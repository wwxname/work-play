package cn.plus.framework.quartz2.spring.mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.jdbcjobstore.StdRowLockSemaphore;
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

public class MainTest1 {
    public static ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = null;
        dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3307/test?useUnicode=true&amp;characterEncoding=UTF-8");
        dataSource.setUser("root");
        dataSource.setPassword("root1234");
        dataSource.setAcquireIncrement(2);
        dataSource.setMaxIdleTime(1800);
        dataSource.setInitialPoolSize(2);
        dataSource.setMinPoolSize(10);
        return dataSource;
    }

    public static SchedulerFactoryBean schedulerFactoryBean() throws Exception {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        Resource resource = new ClassPathResource("ram-quartz.properties");
        schedulerFactoryBean.setConfigLocation(resource);
        schedulerFactoryBean.setDataSource(comboPooledDataSource());
        schedulerFactoryBean.afterPropertiesSet();
        return schedulerFactoryBean;
    }

    public static void main(String args[]) throws Exception {
        Scheduler scheduler = schedulerFactoryBean().getScheduler();

        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(HelloJob.class);
        jobDetailFactoryBean.setGroup("wwx");
        jobDetailFactoryBean.setName("mysql-test-11");
        jobDetailFactoryBean.afterPropertiesSet();
        JobDetail job = jobDetailFactoryBean.getObject();
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        simpleTriggerFactoryBean.setGroup("wwx");
        simpleTriggerFactoryBean.setName("mysql-test-11");
        simpleTriggerFactoryBean.setRepeatInterval(1000);
        simpleTriggerFactoryBean.setStartDelay(0);
        simpleTriggerFactoryBean.setStartTime(new Date());
        simpleTriggerFactoryBean.afterPropertiesSet();
        SimpleTrigger trigger = simpleTriggerFactoryBean.getObject();
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StdRowLockSemaphore stdRowLockSemaphore;
        scheduler.start();

    }
}
