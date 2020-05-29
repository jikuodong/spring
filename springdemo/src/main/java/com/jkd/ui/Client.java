package com.jkd.ui;

import com.jkd.dao.AccountDao;
import com.jkd.service.AccountService;
import com.jkd.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @projectName: springdemo
 * @package: com.jkd.ui
 * @className: Client
 * @author: JKD
 * @description:
 * @date: 2020/5/29 14:11
 * @version: 1.0
 */
public class Client {

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     * 核心容器的两个接口引发出的问题：
     *  ApplicationContext: 单利对象适用
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也即是说，只要一读玩配置文件马上就创建配置文件中的对象。
     *  BeanFactory: 多例对象适用
     *      它在构建核心容器时，创建对象采用的策略是采用延迟加载的方式。也即是说。什么时候根据id获取对象了，什么时候才真正的创建对象。
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//
//        // 2.根据id获取Bean对象
//
//        AccountService as = (AccountService) ac.getBean("accountService");
//        AccountDao adao = ac.getBean("accountDao", AccountDao.class);
//        System.out.println(as);
//        System.out.println(adao);
//        as.saveAccount()

        // --------------BeanFactory----------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService as = (AccountService) factory.getBean("accountService");
        System.out.println(as);
    }
}
