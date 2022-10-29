package com.rg.controller;

import com.rg.domain.QueryVo;
import com.rg.domain.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: springmvc_quickstart
 * @Author: RG
 * @CreateTime: 2022/10/27 11:50 上午
 * @Description:
 */
@Controller
@SessionAttributes("username")
@RequestMapping("/user")    // 一级访问目录
public class UserController {

    /**
     * path:作用等同于value，同样是设置方法的映射地址
     * method:用来限定请求的方式RequestMethod.POST：只能以post的请求方式访问该访问，其他请求方式会报错
     * params:用来限定请求参数的条件 params={"id"}表示请求参数必须有id
     * @return
     */
    @RequestMapping(path = "/quick",method = RequestMethod.GET,params = {"id"})   // 二级访问目录
    public String quick() {
        // 业务逻辑
        System.out.println("springmvc快速入门");
        // 视图跳转 逻辑视图名
        return "success";

    }

    /**
     * 获取基本类型请求参数
     * @param id
     * @param username
     * @return
     */
    @RequestMapping("/simpleParam")
    public String simpleParam(Integer id,String username) {

        System.out.println(id);
        System.out.println(username);

        return "success";
    }

    /**
     * 获取对象类型请求参数
     * @param user
     * @return
     */
    @RequestMapping("/pojoParam")
    public String pojoParam(User user) {
        System.out.println(user);
        return "success";
    }

    /**
     * 获取数组类型请求参数
     * @param ids
     * @return
     */
    @RequestMapping("/arrayParam")
    public String arrayParam(Integer[] ids) {
        System.out.println(Arrays.toString(ids));
        return "success";
    }

    /**
     * 获取集合类型请求参数
     * @param queryVo
     * @return
     */
    @RequestMapping("/queryParam")
    public String queryParam(QueryVo queryVo) {
        System.out.println(queryVo);
        return "success";
    }

    /**
     * 获取日期类型：（自定义类型转换器）
     * @param birthday
     * @return
     */
    @RequestMapping("/converterParam")
    public String converterParam(Date birthday) {
        System.out.println(birthday);
        return "success";
    }

    /**
     * 演示@RequestParam注解
     * name:匹配页面传递参数的名称
     * defaultValue:设置参数的默认值
     * required:设置是否必须传递该参数，默认值为true,如果设置了默认值,值自动改为false
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findByPage")
    public String findByPage(@RequestParam(name = "pageNo",defaultValue = "1",required = false) Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        System.out.println(pageNum);
        System.out.println(pageSize);
        return "success";
    }

    /**
     * 获取请求头的数据
     * @param cookie
     * @return
     */
    @RequestMapping("/requestHeader")
    public String requestHeader(@RequestHeader("cookie") String cookie) {
        System.out.println(cookie);
        return "success";
    }

    /**
     * 获取cookie中的数据
     * @param jsessionId
     * @return
     */
    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String jsessionId) {
        System.out.println(jsessionId);
        return "success";
    }

    /**
     * 原始servletAPI的获取
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping("/servletAPI")
    public String servletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "success";
    }

    /**
     * void原始servletAPI
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/returnVoid")
    public void returnVoid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        // 借助request对象完成请求转发 一次请求
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 借助response对象完成重定向 两次请求 WEB-INF：完全目录：不允许外部请求直接访问该目录资源，只可以进行服务器内部转发
        // response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    /**
     * 演示forward关键字进行请求转发
     * @return
     */
    @RequestMapping("/forward")
    public String forward(Model model) {
        // 设置参数
        model.addAttribute("username","RG");
        // 使用请求转发，既可以转发到jsp，也可以转发到其他的控制器方法
        // return "forward:/user/quick";
        return "forward:/WEB-INF/pages/success.jsp";
    }

    /**
     * @SessionAttributes的效果：多个请求之间共享数据
     * @return
     */
    @RequestMapping("/returnString")
    public String returnString() {
        return "success";
    }

    /**
     * 演示redirect关键字进行重定向
     * @return
     */
    @RequestMapping("/redirect")
    public String redirect() {

        return "redirect:/index.jsp";
    }

    /**
     * modelAndView进行页面跳转：方式一
     * @return
     */
    @RequestMapping("/returnModelAndView")
    public ModelAndView returnModelAndView() {

        /**
         * model：模型：作用封装存放数据
         * view：视图：用来展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        // 设置模型数据
        modelAndView.addObject("username","modelAndView方式一");
        // 设置视图名称 视图解析器解析modelAndView拼接前缀和后缀
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * modelAndView进行页面跳转：方式二
     * @return
     */
    @RequestMapping("/returnModelAndView2")
    public ModelAndView returnModelAndView2(ModelAndView modelAndView) {

        /**
         * model：模型：作用封装存放数据
         * view：视图：用来展示数据
         */
        // 设置模型数据
        modelAndView.addObject("username","modelAndView方式二");
        // 设置视图名称 视图解析器解析modelAndView拼接前缀和后缀
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * ajax异步交互
     * @param list
     * @return
     */
    @RequestMapping("/ajaxRequest")
    @ResponseBody
    public List<User> ajaxRequest(@RequestBody List<User> list) {
        System.out.println(list);
        return list;
    }

}
