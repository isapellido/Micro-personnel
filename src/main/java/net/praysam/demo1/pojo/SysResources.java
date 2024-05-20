package net.praysam.demo1.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SysResources implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer resourceid;
    private String name;
    private String url;
    private String permission;
    private Integer type;
    private Integer sort;
    private Integer available;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;

}
