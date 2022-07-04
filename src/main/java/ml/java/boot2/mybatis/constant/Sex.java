package ml.java.boot2.mybatis.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum Sex {

    MALE(0, "male"),FEMALE(1, "female");

    @EnumValue
    private Integer sex;
    private String name;

    Sex(Integer sex,String name){
        this.sex = sex;
        this.name = name;
    }

}
