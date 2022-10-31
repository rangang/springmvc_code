package com.rg.test;

import com.rg.domain.Account;
import com.rg.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @BelongsProject: ssm
 * @Author: RG
 * @CreateTime: 2022/10/31 10:16 上午
 * @Description:
 */
public class MyBatisTest {

    @Test
    public void testMybatis() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> list = mapper.findAll();

        for (Account account : list) {
            System.out.println(account);
        }

    }

}
