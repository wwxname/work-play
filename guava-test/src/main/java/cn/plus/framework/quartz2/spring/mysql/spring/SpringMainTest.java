package cn.plus.framework.quartz2.spring.mysql.spring;/**
 * @author plus me
 * @date 2018/6/25
 */

import cn.plus.framework.spring.SpringContextUtils;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

public class SpringMainTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ApplicationContext context =  SpringContextUtils.getCurrentBasePackageContext(SpringMainTest.class);


    }
}
