package com.rg.service;

import com.rg.domain.Account;

import java.util.List;

/**
 * @BelongsProject: ssm
 * @Author: RG
 * @CreateTime: 2022/10/31 10:35 上午
 * @Description:
 */
public interface AccountService {

    public List<Account> findAll();

}
