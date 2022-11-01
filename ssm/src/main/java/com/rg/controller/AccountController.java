package com.rg.controller;

import com.rg.domain.Account;
import com.rg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ssm
 * @Author: RG
 * @CreateTime: 2022/11/1 2:16 下午
 * @Description:
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 查询所有账户
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {

        List<Account> list = accountService.findAll();

        // 把封装好的list存到model中
        model.addAttribute("list",list);

        return "list";
    }

    /**
     * 添加账户
     * @param account
     * @return
     */
    @RequestMapping("/save")
    public String save(Account account) {

        System.out.println(account);
        accountService.save(account);

        return "redirect:/account/findAll";
    }

    @RequestMapping("/findById")
    public String findById(Integer id,Model model) {

        Account account = accountService.findById(id);

        model.addAttribute("account",account);

        return "update";

    }

    @RequestMapping("/update")
    public String update(Account account) {

        accountService.update(account);

        return "redirect:/account/findAll";
    }

    @RequestMapping("/deleteBatch")
    public String deleteBatch(Integer[] ids) {

        accountService.deleteBatch(ids);
        return "redirect:/account/findAll";
    }

}
