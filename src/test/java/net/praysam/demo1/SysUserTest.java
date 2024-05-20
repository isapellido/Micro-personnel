package net.praysam.demo1;

import net.praysam.demo1.mapper.SysUserMapper;
import net.praysam.demo1.pojo.SysRole;
import net.praysam.demo1.pojo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserTest {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Test
    public void TestGet(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("peter");
        sysUser.setPassword("123");
        SysUser authenSysUser = sysUserMapper.get(sysUser);//调用dao层的get方法
        System.out.println("authenSysUser="+authenSysUser);//打印认证用户信息
        if (authenSysUser != null) {
            System.out.println("======认证成功");
            List<SysRole> roles = authenSysUser.getRoles();//认证用户的角色(集合类型)
            for (int i = 0; i < roles.size(); i++) {//遍历集合
                System.out.println("认证用户" + authenSysUser.getUsername() +
                        "的第" + (i + 1) + "个角色=" + roles.get(i).getRolename());
            }
        }
    }
}
