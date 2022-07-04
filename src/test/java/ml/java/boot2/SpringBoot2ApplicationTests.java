package ml.java.boot2;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import ml.java.boot2.config.bean.Pet;
import ml.java.boot2.mybatis.constant.Sex;
import ml.java.boot2.mybatis.domain.City;
import ml.java.boot2.mybatis.domain.User;
import ml.java.boot2.mybatis.mapper.CityMapper;
import ml.java.boot2.mybatis.mapper.UserMapper;
import ml.java.boot2.mybatis.service.CityService;
import ml.java.boot2.mybatis.service.impl.CityServiceImpl;
import ml.java.boot2.mybatis.service.impl.UserServiceImpl;
import ml.java.library.domains.Greeter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.*;

@SpringBootTest
class SpringBoot2ApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Greeter greeter;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CityMapper cityMapper;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CityServiceImpl cityService;


    @Test
    void autoConfig(){
//        System.out.println("contain Aloha? " + applicationContext.containsBean("aloha"));
//        applicationContext.getBean("ml.java.boot2.config.bean.Other", Other.class).moan(); //id=全路径类名
//        applicationContext.getBean("user", User.class).say("hello");
        applicationContext.getBean("innercat", Pet.class).meow(); //当注释掉@Bean("bobcat")时tomcat不会创建
    }

    @Test
    void starterConfig(){
        System.out.println(greeter.greet());
    }

    @Test
    void mybatisMapper(){
        Map<String,Object> queryMap = new HashMap<>();
//        System.out.println(userMapper.selectMapById(2L));
//        queryMap.put("name","MIKE");
//        queryMap.put("age",21);
//        userMapper.selectByMap(queryMap).forEach(System.out::println);
//        userMapper.selectList(null).forEach(System.out::println); //查询所有
//        System.out.println(userMapper.selectById(2L));
//        userMapper.selectBatchIds(Arrays.asList(1L, 3L)).forEach(System.out::println);
//        userMapper.updateById(new User(4L, "PETOR", 30, "email4+")); //根据id去修改，未赋值字段不变动。
//        queryMap.put("name", "JONE");
//        queryMap.put("age", 20);
//        userMapper.deleteByMap(queryMap); //where name='JONE' and age=20
//        userMapper.deleteById(2);
//        userMapper.deleteBatchIds(Arrays.asList(2L,3L));
//        userMapper.insert(new User((long)4, "PETER", 20, "mail4")); //不赋值id时默认使用雪花值代替
    }

    @Test
    void mybatisService(){
        System.out.println(cityService.count());
//        System.out.println(userService.count());
//        List<User> userList = new ArrayList<>();
//        User user = new User();
//        user.setAge(10);
//        user.setName("LSP");
//        userList.add(user);
//        userService.saveBatch(userList);

    }

    @Test
    void mybatisQueryWrapper(){
        //QueryWrapper：用于select,delete,update
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        /**
         * 条件链接：and（默认）,or
         * 查询：like,eq
         * 区间：between,le,gt
         * 空值：isNotNull,isNull
         * 升降序：orderByAsc,orderByDesc
         * ()：.or(i->i.)
         * (name LIKE ? AND age BETWEEN ? AND ? OR ( (email IS NULL OR name = ?) ) AND id IN (select id from user where id < 20))
         */
        queryWrapper.select("name","age"); //选择字段，配合selectMaps返回Map
        String name = "M";
        boolean isDesc = true;
        if(StringUtils.isNotBlank(name)){
            queryWrapper.like("name", name);
        }
        queryWrapper.between("age",10, 30)
                .or(i->i.isNull("email")
                        .or()
                        .eq("name","PETOR"))
                .inSql("id","select id from user where id < 20");
        queryWrapper.orderByDesc(isDesc,"id");
        userMapper.selectMaps(queryWrapper).forEach(System.out::println);
//        userMapper.selectList(queryWrapper).forEach(System.out::println);
//        userMapper.delete(queryWrapper);
//        User user = new User();
//        user.setAge(30);
//        userMapper.update(user,queryWrapper);
    }

    @Test
    void mybatisUpdateWrapper(){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.set("age",30)
                .set("email","emailC")
                .eq("name","MIKE");
        userMapper.update(null, userUpdateWrapper);
//        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//        lambdaUpdateWrapper.set(User::getAge, 5)
//                .eq(User::getEmail, "mail2");
//        userMapper.update(null, lambdaUpdateWrapper);

    }

    @Test
    void mybatisLambdaWrapper(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = "MIKE";
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(name), User::getName, name);
        Page<User> page = new Page<>(1, 2);
//        userMapper.selectPage(page, lambdaQueryWrapper);
        userMapper.selectXmlPage(page, 1);
        System.out.println(page.getRecords());
//        userMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    void mybatisLockUpdate(){
//        User user = userMapper.selectById(3L);
//        user.setEmail(user.getEmail() + "Lock");
//        userMapper.updateById(user);
        City city = cityMapper.selectById(1L);
        city.setRegion("CN-West");
        cityMapper.updateById(city);
    }

    @Test
    void mybatisEnum(){
        User user = new User();
        user.setName("MHW");
        user.setAge(30);
        user.setSex(Sex.MALE);
        userService.save(user);
//        System.out.println(Sex.FEMALE.ordinal());
//        System.out.println(Sex.MALE.getSex());
//        Sex sexValue = Sex.valueOf("MALE");
//        System.out.println(Sex.MALE.equals(sexValue));
//
//        switch (sexValue){
//            case MALE:
//                System.out.println("this's male");
//        }
    }


    @Test
    void mybatisGen(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/sakila?serverTimezone=GMT%2B8&characterEncoding=utf-8&userSSL=false", "root", "mysql")
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("ml.java") // 设置父包名
                            .moduleName("boot2") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user"); // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }


}
