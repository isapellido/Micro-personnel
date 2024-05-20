package net.praysam.demo1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Employee implements Serializable {
    public Employee(Integer id, String name, String deptname) {
        this.id = id;
        this.name = name;
        this.deptname = deptname;
    }

    /**
     * 员工编号
     */
    private Integer id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 婚姻状况
     */
    private String wedlock;

    /**
     * 民族
     */
    private Integer nationid;

    /**
     * 籍贯
     */
    private String nativeplace;

    /**
     * 政治面貌
     */
    private Integer politicid;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 所属部门
     */
    private Integer departmentid;
    private String deptname;

    /**
     * 职称ID
     */
    private Integer joblevelid;

    /**
     * 职位ID
     */
    private Integer posid;
    private String posname;

    /**
     * 聘用形式
     */
    private String engageform;

    /**
     * 最高学历
     */
    private Object tiptopdegree;

    /**
     * 所属专业
     */
    private String specialty;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 入职日期
     */
    private Date begindate;

    /**
     * 在职状态
     */
    private Object workstate;

    /**
     * 工号
     */
    private String workid;

    /**
     * 合同期限
     */
    private Double contractterm;

    /**
     * 转正日期
     */
    private Date conversiontime;

    /**
     * 离职日期
     */
    private Date notworkdate;

    /**
     * 合同起始日期
     */
    private Date begincontract;

    /**
     * 合同终止日期
     */
    private Date endcontract;

    /**
     * 工龄
     */
    private Integer workage;

}
