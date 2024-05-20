package net.praysam.demo1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data  //getter、setter、toString
@NoArgsConstructor //无参构造方法
@AllArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userid;
    private String username;
    private String password;
    private String empid;
    private String empname;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    /**
     *  一个用户可以有多个角色
     */
    private List<SysRole> roles;
}
