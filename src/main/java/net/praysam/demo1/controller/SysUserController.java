package net.praysam.demo1.controller;

import net.praysam.demo1.pojo.SysUser;
import net.praysam.demo1.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;//调用业务层

    /*@PostMapping("/login")
    @ResponseBody
    public String login(SysUser sysUser){
        return sysUserService.login(sysUser);
    }*/


        /*String state;
        String res = sysUserService.login(sysUser);
        System.out.println("业务层返回值："+res);
        if (res.equals("欢迎"+sysUser.getUsername()+"登录！")){
            state = "1";
        }else{
            state = "0";
        }*/
    @PostMapping("/login")
    @ResponseBody
    public String login(SysUser sysUser){
        System.out.println("=====账号====="
                +sysUser.getUsername());
        System.out.println("=====密码====="
                +sysUser.getPassword());
        String res =
        sysUserService.login(sysUser);
        System.out.println("----res="+res);
        if (res.equals("欢迎"+sysUser.getUsername()+"登录！")){
            return "1";//登录成功
        }else{
            return "0";//登录失败
        }
    }
        /* if (res != null) {
            return "redirect:../home.html";
        }else{
            return "login";
        }*/



    @PostMapping("/register")
//    @ResponseBody
    public String register(SysUser sysUser){

        if (sysUserService.register(sysUser) == 1) {
            return "redirect:../index.html";
        }else{
            return "";
        }
    }
    @RequestMapping ("hello")
    public String getThymeleaf(Model model){
           //model中的数据通过controller层(SysUserController)关联绑定到view层(hello.html)可以直接使用。
           model.addAttribute
                   ("name","Thymeleaf动态内容");
        return "hello";//tempplates中的hello.html

    }











}
