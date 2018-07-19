package cn.plus.framework.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author plus me
 * @date 2018/6/25
 */
public abstract class SpringContextUtils {

    public static AnnotationConfigApplicationContext getContext(String... basePackages) {
        if (basePackages.length == 0) {
            return new AnnotationConfigApplicationContext();
        }
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(basePackages);
        return annotationConfigApplicationContext;
    }

    public static AnnotationConfigApplicationContext getCurrentBasePackageContext(Class clazz) {
        String basePackage = (String) clazz.getName().substring(0, clazz.getName().lastIndexOf("."));
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(basePackage);
        return annotationConfigApplicationContext;
    }
}
