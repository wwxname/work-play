package mysql;

import lombok.Data;

/**
 * @author plus me
 * @date 2018/7/2
 */
@Data
public class Organization {
    String type;//org,dept,root
    Integer id;
    String parentId;//root  为null  为最顶级

    Integer state;//1存在0删除

    String name;//root,彩衣

    String remark;//hello


}
