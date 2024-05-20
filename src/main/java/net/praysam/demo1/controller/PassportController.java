package net.praysam.demo1.controller;

import net.praysam.demo1.util.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PassportController {

    @PostMapping("shirologin")
    @ResponseBody
    public ResultBean login(String username, String password){

        // 通过SecurityUtils 获取一个Subject
        Subject subject = SecurityUtils.getSubject();

        //  Token ==> 令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username , password);
        subject.login(token);
        return ResultBean.success("登录成功");
    }

    @GetMapping("logout")
    public String logout(){
        return "redirect:./index.html";
    }


//    @GetMapping("error")
//    public String error(){
//        throw new UnauthorizedException();
//    }

    @GetMapping("home")
    public String home(){
        return "home.html";
    }
}
