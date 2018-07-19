package cn.plus.framework.quartz2.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.utils.ConnectionProvider;
import org.quartz.utils.DBConnectionManager;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author plus me
 * @date 2018/6/19
 */
public class MainTest {

    public static ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = null;
        dataSource = new ComboPooledDataSource();
        dataSource.setPassword("root1234");
        dataSource.setInitialPoolSize(2);
        dataSource.setMinPoolSize(10);
        dataSource.setAcquireIncrement(2);
        dataSource.setMaxIdleTime(1800);
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3307/test?useUnicode=true&amp;characterEncoding=UTF-8");
        dataSource.setUser("root");
        return dataSource;
    }

    public static void main(String args[]) throws SchedulerException, PropertyVetoException, SQLException {
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("hello", "group1").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("hello", "group1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionNextWithRemainingCount()
                                .withIntervalInSeconds(5).repeatForever())
                .build();
        int i = trigger.getMisfireInstruction();

        System.err.println(i);

        Trigger trigger2 = TriggerBuilder
                .newTrigger()
                .withIdentity("hello", "group2")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/5 * * * * ?").withMisfireHandlingInstructionDoNothing())
                .build();
        i = trigger2.getMisfireInstruction();
        System.err.println(i);
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();

        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        ConnectionProvider connectionProvider = new ConnectionProvider() {
            ComboPooledDataSource dataSource = null;

            @Override
            public Connection getConnection() throws SQLException {
                return dataSource.getConnection();
            }

            @Override
            public void shutdown() throws SQLException {
                dataSource = null;

            }

            @Override
            public void initialize() throws SQLException {
                try {
                    dataSource = comboPooledDataSource();
                } catch (PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        };
       // CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING;
        connectionProvider.initialize();
        DBConnectionManager.getInstance().addConnectionProvider("c3p0", connectionProvider);
        //scheduler.unscheduleJob(trigger.getKey());
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
        //scheduler.unscheduleJob(trigger.getKey());

    }
}
