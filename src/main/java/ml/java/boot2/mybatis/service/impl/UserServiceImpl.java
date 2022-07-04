package ml.java.boot2.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ml.java.boot2.mybatis.domain.User;
import ml.java.boot2.mybatis.mapper.UserMapper;
import ml.java.boot2.mybatis.service.UserService;
import org.springframework.stereotype.Service;

@DS("master")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
