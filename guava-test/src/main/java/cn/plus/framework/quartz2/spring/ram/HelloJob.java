package cn.plus.framework.quartz2.spring.ram;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author plus me
 * @date 2018/6/19
 */
@Component
public class HelloJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Date date = context.getFireTime();
        //context.getScheduler().getContext().get()
        System.out.println(date);
        System.err.println("mysql");
    }
}
