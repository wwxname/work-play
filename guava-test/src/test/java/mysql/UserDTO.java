package mysql;

import lombok.Data;

/**
 * @author plus me
 * @date 2018/7/2
 */
@Data
public class UserDTO {
    String hasRoleIds;//拥有的角色
    String manageRoleids;//管理的角色
}
