package mysql;

import lombok.Data;

/**
 * @author plus me
 * @date 2018/7/2
 */
@Data
public class UserAndRole {

    Integer  id;

    Integer userId;

    Integer roleId;

    Integer  code;//是否可以分配
}
