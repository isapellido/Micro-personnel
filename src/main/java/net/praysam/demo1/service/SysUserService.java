package net.praysam.demo1.service;

import net.praysam.demo1.mapper.SysUserMapper;
import net.praysam.demo1.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;//dao

    public String login(SysUser sysUser) {
        /**
         * 步骤1.根据输入用户名查询是否有此条记录，用findByName()。若无，则返回"登录失败，无此用户！"
         * 步骤2.若有次用户，则将输入密码比对用findPwdByName()查询的密码，若不相同，则返回"登录失败，密码错误！"
         * 步骤3.若密码比对成功，则返回"欢迎[username]登录！"
         */
        String logUsername = sysUser.getUsername();//用户输入的账号
        String logPassword = sysUser.getPassword();//用户输入的密码
        SysUser userExist = sysUserMapper.findByName(logUsername);
        if (userExist != null) {
            String queryPassword = sysUserMapper.findPwdByName(logUsername);
            if (queryPassword.equals(logPassword)) {
                System.out.println("--------------1");
                return "欢迎" + logUsername + "登录！";
            } else {
                System.out.println("--------------2");
                return "登录失败，密码错误！";
            }
        } else {
            System.out.println("--------------3");
            return "登录失败，无此用户！";
        }
    }

    public int register(SysUser sysUser) {
        return sysUserMapper.register(sysUser.getUsername(), sysUser.getPassword());
    }

    public SysUser findUserByNameAndPwd(String username , String password){
        SysUser user = new SysUser();
        user.setUsername(username);
        user.setPassword(password);
        return sysUserMapper.get( user );
    }
}
