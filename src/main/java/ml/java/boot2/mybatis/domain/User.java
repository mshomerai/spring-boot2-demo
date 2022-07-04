package ml.java.boot2.mybatis.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ml.java.boot2.mybatis.constant.Sex;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("user") //默认类小写
public class User {

    @TableId(value = "id", type = IdType.ASSIGN_ID) //属性名为id时可以不注解，默认名id。
    private Long id;
    @TableField("name")
    private String name;
    private Integer age;
    private Sex sex;
    private String email;
    @Version
    private Integer version;
    //有效：0，无效：1，设置该字段后delete该表数据只会更新is_valid=1。select时只会选取is_valid=0。
    @TableLogic
    private Integer isValid;

}
