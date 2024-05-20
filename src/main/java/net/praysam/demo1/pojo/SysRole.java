package net.praysam.demo1.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SysRole  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roleid;
    private String rolename;
    private String description;
    private Integer available;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;

    /**
     *  一个角色可以访问多个资源
     */
    private List<SysResources> resources;

}
