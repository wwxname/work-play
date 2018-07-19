package cn.plus.framework.quartz2;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.impl.JobDetailImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.core.ResolvableType;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.util.MethodInvoker;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author plus me
 * @date 2018/6/26
 */
public class PlusMethodInvokingJobDetailFactoryBean extends MethodInvokingJobDetailFactoryBean implements Serializable {
    private String springName;

    public String getSpringName() {
        return springName;
    }

    public void setSpringName(String springName) {
        this.springName = springName;
    }

    @Override
    protected void postProcessJobDetail(JobDetail jobDetail) {
        Class<?> jobClass = PlusMethodInvokingJobDetailFactoryBean.StatefulMethodInvokingJob.class;
        super.postProcessJobDetail(jobDetail);
        jobDetail.getJobDataMap().clear();
        Map map = new HashMap();
        map.put("clazz",this.getTargetClass());
        map.put("method",this.getTargetMethod());
        jobDetail.getJobDataMap().put("dataJsonInfo", JSONObject.toJSONString(map));
        ((JobDetailImpl)jobDetail).setJobClass((Class<? extends Job>) jobClass);
    }

    @PersistJobDataAfterExecution
    @DisallowConcurrentExecution
    public static class StatefulMethodInvokingJob extends MethodInvokingJob {

        protected static final Log logger = LogFactory.getLog(MethodInvokingJob.class);

        Class clazz = null;
        String method = null;
        String springName = null;
        String dataJsonInfo = null;

        public void setDataJsonInfo(String dataJsonInfo) throws ClassNotFoundException, NoSuchMethodException {
            this.dataJsonInfo = dataJsonInfo;
            JSONObject jsonObject = JSONObject.parseObject(dataJsonInfo);
            this.clazz = Class.forName(jsonObject.getString("clazz"));
            this.method = jsonObject.getString("method");

            PlusMethodInvokingJobDetailFactoryBean plus = new PlusMethodInvokingJobDetailFactoryBean();
            plus.setTargetClass(clazz);
            plus.setTargetMethod(method);
            plus.prepare();
            this.setMethodInvoker(plus);
        }


    }

}
