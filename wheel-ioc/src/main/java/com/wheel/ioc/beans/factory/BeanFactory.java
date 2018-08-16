package com.wheel.ioc.beans.factory;

/**
 * @author wym
 * @create 2018-08-16 1:40
 **/
public interface BeanFactory {

    public Object getBean(String name) throws Exception;

}
