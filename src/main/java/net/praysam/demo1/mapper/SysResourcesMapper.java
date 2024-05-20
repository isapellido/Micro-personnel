package net.praysam.demo1.mapper;

import net.praysam.demo1.pojo.SysResources;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface SysResourcesMapper {

    List<SysResources> findAll();
}
