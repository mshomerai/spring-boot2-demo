package ml.java.boot2.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ml.java.boot2.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {

    Map<String,Object> selectMapById(Long id);

    Page<User> selectXmlPage(@Param("page") Page<User> page, @Param("age") Integer age);

}
