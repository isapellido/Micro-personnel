package net.praysam.demo1;

import net.praysam.demo1.mapper.SysRoleMapper;
import net.praysam.demo1.mapper.SysUserMapper;
import net.praysam.demo1.pojo.SysResources;
import net.praysam.demo1.pojo.SysRole;
import net.praysam.demo1.pojo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSysRole {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Test
    public void testFindRoleByUser(){
                SysRole roleResources = sysRoleMapper.get(1);//通过角色id查资源
                List<SysResources> resources = roleResources.getResources();
                for (int j = 0; j < resources.size(); j++) {
                    System.out.println("角色可访问资源："+
                            resources.get(j).getPermission()+
                            "/"+resources.get(j).getName());
                }
    }
}
