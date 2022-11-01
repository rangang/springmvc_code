package com.rg.service.impl;

import com.rg.domain.Account;
import com.rg.mapper.AccountMapper;
import com.rg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: ssm
 * @Author: RG
 * @CreateTime: 2022/10/31 10:36 上午
 * @Description:
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        System.out.println("findAll");
        return accountMapper.findAll();
    }

    @Override
    public void save(Account account) {
        accountMapper.save(account);
    }

    @Override
    public Account findById(Integer id) {
        return accountMapper.findById(id);
    }

    @Override
    public void update(Account account) {
        accountMapper.update(account);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        accountMapper.deleteBatch(ids);
    }
}
