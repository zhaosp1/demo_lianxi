package com.example.springboot.repository.util.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @Author huangwei
 * @Description 上下文类加载器
 * @Date 2020/11/3 16:52
 **/
@Slf4j
@Component("smifcServiceFactory")
public class ServiceFactory implements ApplicationContextAware , EmbeddedValueResolverAware , BeanFactoryPostProcessor {
    protected static ApplicationContext ctx = null;
    private static StringValueResolver stringValueResolver;
    public ServiceFactory() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    public static ApplicationContext getCtx() {
        return ctx;
    }

    public static Object getBean(String beanid) {
        return ctx.getBean(beanid);
    }
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        stringValueResolver = resolver;
    }
    /**
     * 动态获取配置文件中的值
     * @param name
     * @return
     */
    public static String getPropertiesValue(String name) {
        try {
            name = "${" + name + "}";
            return stringValueResolver.resolveStringValue(name);
        } catch (Exception e) {
            log.error(String.format("当前环境变量中没有{%s}的配置", name));
            // 获取失败则返回null
            return null;
        }
    }

    public static <T> T getBean(Class<T> requiredType) {
        return ctx == null ? null : ctx.getBean(requiredType);
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}