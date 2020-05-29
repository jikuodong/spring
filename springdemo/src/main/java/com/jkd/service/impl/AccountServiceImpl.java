package com.jkd.service.impl;

import com.jkd.dao.AccountDao;
import com.jkd.dao.impl.AccountDaoImpl;
import com.jkd.service.AccountService;

/**
 * @projectName: springdemo
 * @package: com.jkd.service.impl
 * @className: AccountServiceImpl
 * @author: JKD
 * @description:
 * @date: 2020/5/29 14:12
 * @version: 1.0
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
