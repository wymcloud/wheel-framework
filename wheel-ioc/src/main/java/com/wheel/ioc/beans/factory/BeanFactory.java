package com.wheel.ioc.beans.factory;

import com.wheel.ioc.beans.support.BeanDefinition; /**
 * @author wym
 * @create 2018-08-16 1:40
 **/
public interface BeanFactory {

    public Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
