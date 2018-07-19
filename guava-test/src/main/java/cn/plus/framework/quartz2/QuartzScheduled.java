package cn.plus.framework.quartz2;


import com.sun.istack.internal.NotNull;

import java.lang.annotation.*;

/**
 * @author plus me
 * @date 2018/6/25
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(QuartzSchedules.class)
public @interface QuartzScheduled  {
    /**
     *
     * @return
     */

    String cron() default "";

    String name() ;

    /**
     *
     * @return
     */
    long fixedRate() default -1;
    long initialDelay() default -1;
}
