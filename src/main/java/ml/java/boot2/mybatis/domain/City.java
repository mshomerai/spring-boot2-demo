package ml.java.boot2.mybatis.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("city")
public class City {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String region;

}
