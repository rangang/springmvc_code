package com.rg.mapper;

import com.rg.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: ssm
 * @Author: RG
 * @CreateTime: 2022/10/31 10:01 上午
 * @Description:
 */
@Repository
public interface AccountMapper {

    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 添加账户
     * @param account
     */
    public void save(Account account);

    /**
     * 根据ID查询账户
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 修改账户
     * @param account
     */
    public void update(Account account);

    /**
     * 批量删除账户
     * @param ids
     */
    public void deleteBatch(Integer[] ids);

}
