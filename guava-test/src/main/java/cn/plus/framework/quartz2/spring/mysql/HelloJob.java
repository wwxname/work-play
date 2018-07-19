package cn.plus.framework.quartz2.spring.mysql;

import cn.plus.framework.quartz2.QuartzGroup;
import cn.plus.framework.quartz2.QuartzScheduled;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author plus me
 * @date 2018/6/19
 */
@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class HelloJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Date date = context.getFireTime();
        //context.getScheduler().getContext().get()
        System.out.println(date);
        System.err.println("mysql-demo");
    }
}
