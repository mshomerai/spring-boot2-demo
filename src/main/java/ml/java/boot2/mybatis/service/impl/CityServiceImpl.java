package ml.java.boot2.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ml.java.boot2.mybatis.domain.City;
import ml.java.boot2.mybatis.mapper.CityMapper;
import ml.java.boot2.mybatis.service.CityService;
import org.springframework.stereotype.Service;

@DS("slave")
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {
}
