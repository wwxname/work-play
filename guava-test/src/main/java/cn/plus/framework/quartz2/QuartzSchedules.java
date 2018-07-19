package cn.plus.framework.quartz2;

import java.lang.annotation.*;

/**
 * @author plus me
 * @date 2018/6/25
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QuartzSchedules {
    QuartzScheduled[] value();
}
