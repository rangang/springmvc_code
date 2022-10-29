package com.rg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: springmvc_quickstart
 * @Author: RG
 * @CreateTime: 2022/10/29 2:01 下午
 * @Description:
 */
@Controller
public class ExceptionController {

    @RequestMapping("/testException")
    public String testException() {

        int i = 1 / 0;

        return "success";
    }

}
