package cn.plus.framework.quartz2.example;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

/**
 * @author plus me
 * @date 2018/6/19
 */

public class HelloJob implements Job{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.err.println("123");
    }
}
