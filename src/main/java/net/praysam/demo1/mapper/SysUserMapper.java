package net.praysam.demo1.mapper;

import net.praysam.demo1.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper //对应映射文件(mapper.xml)中的namespace指向mapper的java接口类
@Repository //dao层bean
public interface SysUserMapper {
    //根据用户的账号和密码查询用户信息+角色信息
    SysUser get(SysUser user);

    SysUser findByName(String username);
    String findPwdByName(String username);
    int register(String username, String password);

}
