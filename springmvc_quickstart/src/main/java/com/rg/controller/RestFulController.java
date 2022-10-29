package com.rg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: springmvc_quickstart
 * @Author: RG
 * @CreateTime: 2022/10/28 8:14 下午
 * @Description:
 */
@RestController
@RequestMapping("/restful")
public class RestFulController {

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")   // 相当于@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String get(@PathVariable Integer id) {
        return "get:" + id;
    }

    /**
     * 新增方法
     * @return
     */
    @PostMapping("/user")
    public String post() {
        return "post";
    }

    /**
     * 修改方法
     * @return
     */
    @PutMapping("/user")
    public String put() {
        return "put";
    }

    /**
     * 删除方法
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return "delete:" + id;
    }


}
