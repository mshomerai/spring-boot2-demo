package ml.java.boot2.mybatis.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ml.java.boot2.mybatis.domain.City;
import org.springframework.stereotype.Repository;

@Repository
@DS("slave")
public interface CityMapper extends BaseMapper<City> {
}
