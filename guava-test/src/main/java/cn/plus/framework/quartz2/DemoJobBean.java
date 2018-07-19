package cn.plus.framework.quartz2;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author plus me
 * @date 2018/6/27
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class DemoJobBean extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.err.println("laji");
    }
}
