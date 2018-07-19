package mysql;

import lombok.Data;

import java.util.Date;

/**
 * @author plus me
 * @date 2018/7/2
 */
@Data
public class User {
    Integer code;//启用状态

    Integer id;
    String name;
    String password;

    String realName;
    Integer sex;//1男0女
    String mobile;
    String email;

    Date createTime;
    Date updateTime;
    String createAuthor;
    String updateAuthor;

    Integer locked;

    Integer companyId;//关联organization那张表
    String attachedDeptIds;//隶属于哪些部门
    String manageDeptIds;//管理哪些部门


    String  remark;//备注

}
