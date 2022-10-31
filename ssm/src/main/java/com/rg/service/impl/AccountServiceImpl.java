package com.rg.service.impl;

import com.rg.domain.Account;
import com.rg.mapper.AccountMapper;
import com.rg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: ssm
 * @Author: RG
 * @CreateTime: 2022/10/31 10:36 上午
 * @Description:
 */
@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        System.out.println("findAll");
        return accountMapper.findAll();
    }
}
