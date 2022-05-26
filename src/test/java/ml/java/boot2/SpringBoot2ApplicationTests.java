package ml.java.boot2;

import ml.java.boot2.autoconfig.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBoot2ApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void autoConfig(){
        applicationContext.getBean("tomcat", Pet.class).meow(); //当注释掉@Bean("bobcat")时tomcat不会创建
    }

}
