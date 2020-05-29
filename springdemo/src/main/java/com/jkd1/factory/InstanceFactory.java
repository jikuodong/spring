package com.jkd1.factory;

import com.jkd.service.AccountService;
import com.jkd1.service.impl.AccountServiceImpl;

/**
 * @projectName: springdemo
 * @package: com.jkd1.factory
 * @className: InstanceFactory
 * @author: JKD
 * @description: 普通工厂类
 * @date: 2020/5/29 15:22
 * @version: 1.0
 */
public class InstanceFactory {

    public AccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
