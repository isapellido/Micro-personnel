package net.praysam.demo1.mapper;

import net.praysam.demo1.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface SysRoleMapper {

    SysRole get(Integer roleid);


    List<SysRole> alllist();
}
