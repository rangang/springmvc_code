package com.rg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: springmvc_quickstart
 * @Author: RG
 * @CreateTime: 2022/10/29 2:39 下午
 * @Description:
 */
@Controller
public class TargetController {

    @RequestMapping("/target")
    public String targetMethod() {

        System.out.println("目标方法执行了...");
        return "success";
    }

}
