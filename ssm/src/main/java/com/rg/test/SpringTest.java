package com.rg.test;

import com.rg.domain.Account;
import com.rg.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @BelongsProject: ssm
 * @Author: RG
 * @CreateTime: 2022/10/31 10:38 上午
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testSpring() {
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void save() {
        Account account = new Account();
        account.setName("测试");
        account.setMoney(111d);

        accountService.save(account);
    }

}
