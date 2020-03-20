package com.hqf.ui;

import com.hqf.log.LogUtil;
import com.hqf.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，调用业务层
 */
public class Client {
    final static Logger logger = LoggerFactory.getLogger(Client.class);

    /**
     * 获取Spring的Ioc核心容器，并更具Id获取对象
     * ApplicationContext三个常用实现类
     * 1. ClassPathXmlApplicationContext:加载类路径下的配置文件
     * 2. FileSystemXmlApplicationContext:加载磁盘路径的配置文件(必须有访问权限)
     * 3. AnnotationConfigApplicationContext:用于读取注解创建容器的
     * 容器两个接口的区别 Spring会根据配置文件选择合适的接口，所以我们经常使用ApplicationContext
     * 1. ApplicationContext：（立即加载）读取配置文件后立刻创建对象 （单例模式适用）
     * 2. BeanFactory：（延迟加载） （多例模式适用）
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("spring.xml");
//        Resource resource = new ClassPathResource("spring.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
        for (int i = 0; i < 5; i++) {
            IAccountService as = ac.getBean("accountService", IAccountService.class);
            LogUtil.info(as.toString());
            as.saveAccount();
        }
    }
}
