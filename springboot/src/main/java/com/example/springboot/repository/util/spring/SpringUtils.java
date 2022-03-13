package com.example.springboot.repository.util.spring;

import org.apache.commons.lang3.Validate;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 获取Spring注入bean，接口实现
 * ServiceFactoryLocator.java
 * @author chenjh
 * @date 2019/6/14
 **/
@Component
public class SpringUtils implements ApplicationContextAware {


    private static ApplicationContext applicationContext;

    /**
     * 从静态变量applicationContext中得到Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量applicationContext中得到Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return applicationContext.getBean(requiredType);
    }

    /**
     * 清除SpringContextHolder中的ApplicationContext为Null.
     */
    public static void clearHolder() {
        applicationContext = null;
    }

    /**
     * 实现ApplicationContextAware接口, 注入Context到静态变量中.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 检查ApplicationContext不为空.
     */
    private static void assertContextInjected() {
        Validate.validState(applicationContext != null,
                "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
    }


    /**
     * 根据接口类型返回 所有的实现类
     */
    public static <T> Map<String, T> getAllBeansByInterface(Class<T> clazz) {
        return applicationContext.getBeansOfType(clazz);
    }

    /**
     * 根据泛型获取对应的 实现类
     **/

    @SuppressWarnings("rawtypes")
    public static Object getAllBean(Class<?> clazzInterface, Class<?> parClazz) throws Exception {
        Map map = applicationContext.getBeansOfType(clazzInterface);
        for (Object o : map.keySet()) {
            String beanName = (String) o;
            Object obj = applicationContext.getBean(beanName);
            Object target = doPorxy(obj);
            Class<?> beanClass = target.getClass();
            Type[] types = beanClass.getGenericInterfaces();
            //ParameterizedType参数化类型，即泛型
            for (Type type : types) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) type;
                    Type[] actualTypes = pt.getActualTypeArguments();
                    Type type1 = actualTypes[0];
                    if (type1.getTypeName().equals(parClazz.getName())) {
                        return obj;
                    }
                }
            }

        }
        return null;
    }

    /**
     * 对代理对象的处理 如果是代理对象 则返回targte 对象
     * 如果不是代理对象 返回原object
     */
    public static Object doPorxy(Object object) throws Exception {
        //不是代理对象
        if (!AopUtils.isAopProxy(object)) {
            return object;
        }

        if (AopUtils.isJdkDynamicProxy(object)) {
            return getJdkDynamicProxyTargetObject(object);
        } else { //cglib
            return getCglibProxyTargetObject(object);
        }

    }

    private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        ReflectionUtils.makeAccessible(h);
        Object dynamicAdvisedInterceptor = h.get(proxy);
        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        ReflectionUtils.makeAccessible(advised);
        return ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();
    }


    private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        ReflectionUtils.makeAccessible(h);
        AopProxy aopProxy = (AopProxy) h.get(proxy);
        Field advised = aopProxy.getClass().getDeclaredField("advised");
        ReflectionUtils.makeAccessible(advised);

        return ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();
    }
}
