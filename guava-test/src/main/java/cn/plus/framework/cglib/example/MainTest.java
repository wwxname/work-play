package cn.plus.framework.cglib.example;

import cn.plus.framework.util.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author plus me
 * @date 2018/7/2
 */
class Demo {
    public void test(String name) {
        System.out.println("woshi" + name);
    }
}

class DemoIntercepter implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(ObjectUtils.isObjectMethod(method)){
          return methodProxy.invoke(o,objects);
        }
        return methodProxy.invokeSuper(o, objects);
    }
}

@Slf4j
public class MainTest {


    public static void main(String args[]) {
        Demo demo = getInstance();
        demo.test("wwx");
    }

    public static Demo getInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Demo.class);
        enhancer.setCallback(new DemoIntercepter());
        return (Demo) enhancer.create();
    }
}
