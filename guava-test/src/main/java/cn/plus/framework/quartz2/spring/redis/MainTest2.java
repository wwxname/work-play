package cn.plus.framework.quartz2.spring.redis;


import net.joelinn.quartz.jobstore.RedisJobStore;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Date;

/**
 * @author plus me
 * @date 2018/6/19
 */
class Config {
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("127.0.0.1");
        redisStandaloneConfiguration.setPort(6379);
        redisStandaloneConfiguration.setDatabase(107);
        return  new JedisConnectionFactory(redisStandaloneConfiguration);
    }
}

public class MainTest2 {

    public static SchedulerFactoryBean schedulerFactoryBean() throws Exception {
        Resource resource = new ClassPathResource("redis-quartz.properties");
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setConfigLocation(resource);
        schedulerFactoryBean.afterPropertiesSet();
        return schedulerFactoryBean;
    }

    public static void main(String args[]) throws Exception {
        RedisJobStore redisJobStore;
        Scheduler scheduler = schedulerFactoryBean().getScheduler();

        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(HelloJob.class);
        jobDetailFactoryBean.setGroup("wwx");
        jobDetailFactoryBean.setName("redis-test-1");
        jobDetailFactoryBean.afterPropertiesSet();
        JobDetail job = jobDetailFactoryBean.getObject();
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        simpleTriggerFactoryBean.setGroup("wwx");
        simpleTriggerFactoryBean.setName("redis-test-1");
        simpleTriggerFactoryBean.setRepeatInterval(1000);
        simpleTriggerFactoryBean.setStartDelay(0);
        simpleTriggerFactoryBean.setStartTime(new Date());
        simpleTriggerFactoryBean.afterPropertiesSet();
        SimpleTrigger trigger = simpleTriggerFactoryBean.getObject();
        scheduler.start();
        try {
             scheduler.scheduleJob(job, trigger);
            //scheduler.re
        } catch (Exception e) {
            e.printStackTrace();
        }

       // scheduler.
        scheduler.start();

    }
}
