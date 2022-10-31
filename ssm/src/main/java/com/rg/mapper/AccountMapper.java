package com.rg.mapper;

import com.rg.domain.Account;

import java.util.List;

/**
 * @BelongsProject: ssm
 * @Author: RG
 * @CreateTime: 2022/10/31 10:01 上午
 * @Description:
 */
public interface AccountMapper {

    public List<Account> findAll();

}
