package net.praysam.demo1.service;

import net.praysam.demo1.mapper.SysResourcesMapper;
import net.praysam.demo1.pojo.SysResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class SysResourcesService {

    @Autowired private SysResourcesMapper resourcesMapper;


    public LinkedHashMap<String , String> findAllResources() {
        LinkedHashMap<String , String> map = new LinkedHashMap();

        List<SysResources> list = resourcesMapper.findAll();

        for(SysResources resources: list) {

            String[] split = resources.getPermission().split(",");
            StringBuffer sb = new StringBuffer();
            for(String s: split){
                sb.append(s).append(",");
            }
            String permission = sb.substring(0, sb.length() - 1);
            map.put( resources.getUrl() , "perms["+ permission +"]"  );
        }
        return map;
    }
}
