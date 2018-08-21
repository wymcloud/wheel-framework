import com.wheel.ioc.beans.factory.AutowireCapableBeanFactory;
import com.wheel.ioc.beans.factory.BeanFactory;
import com.wheel.ioc.beans.support.BeanDefinition;
import jp.spring.ioc.beans.factory.BeanFactory;
import jp.spring.ioc.beans.factory.impl.AutowireCapableBeanFactory;
import jp.spring.ioc.beans.support.BeanDefinition;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 12/24/2016.
 */
public class BeanFactoryTest {

    @Test
    public void test()  {
        try {
            //initialized the Factory
            BeanFactory beanFactory = new AutowireCapableBeanFactory();

            //bean definition
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setBeanClassName("jp.spring.ioc.HelloService");

            //Setting values
           /* PropertyValues propertyValues = new PropertyValues();
            propertyValues.addPropertyValue(new PropertyValue("text", "Hello PJ_ZHONG!"));
            List<String> test = new ArrayList<>();
            test.add("pj_zhong");
            test.add("jp_zhong");
            propertyValues.addPropertyValue(new PropertyValue("list", test));
            beanDefinition.setPropertyValues(propertyValues);
*/
            //create bean
            beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

            //obtain bean
            HelloService helloService = (HelloService) beanFactory.getBean("helloWorldService");
            helloService.helloWorld();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Field field = null;
    }
}
