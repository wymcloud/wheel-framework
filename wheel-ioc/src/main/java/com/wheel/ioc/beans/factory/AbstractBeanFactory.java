package com.wheel.ioc.beans.factory;

import com.wheel.ioc.beans.aware.BeanFactoryAware;
import com.wheel.ioc.beans.support.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wym
 * @create 2018-08-16 1:43
 **/
public abstract class AbstractBeanFactory implements BeanFactory {

    private final Map<String, BeanDefinition> beanNameDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionIds = new ArrayList<String>();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanNameDefinitionMap.get(name);
        if(beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if(bean == null) {
            bean = doCreateBean(beanDefinition);
            bean = afterInitializeBean(bean, name);
            beanDefinition.setBean(bean);
        }
        return null;
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

    protected Object afterInitializeBean(Object bean, String name) throws Exception {
        if(!beanPostProcessors.isEmpty()) {
            for(BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
            }
        }
        invokeAware(bean);
        return bean;
    }

    private void invokeAware(Object bean) throws Exception{
        if(bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        if(beanNameDefinitionMap.containsKey(name)) {
            throw new IllegalArgumentException("Bean name " + name + " must be unique");
        }
        beanNameDefinitionMap.put(name, beanDefinition);
        beanDefinitionIds.add(name);
    }
}
