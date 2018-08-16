package com.wheel.ioc.beans.aware;

import com.wheel.ioc.beans.factory.BeanFactory;

/**
 * Created by Administrator on 12/27/2016.
 */
public interface BeanFactoryAware {

    public void setBeanFactory(BeanFactory beanFactory);
}
