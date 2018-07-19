package cn.plus.framework.quartz2.spring.mysql.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * @author plus me
 * @date 2018/6/25
 */
@Configuration
public class BeanConfig {
    @Bean(name = "dataSource", destroyMethod = "close")
    public ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = null;
        dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3307/test?useUnicode=true&amp;characterEncoding=UTF-8");
        dataSource.setUser("root");
        dataSource.setPassword("root1234");
        dataSource.setInitialPoolSize(2);
        dataSource.setMinPoolSize(10);
        dataSource.setAcquireIncrement(2);
        dataSource.setMaxIdleTime(1800);
        return dataSource;
    }
}
