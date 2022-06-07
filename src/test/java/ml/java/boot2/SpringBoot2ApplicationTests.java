package ml.java.boot2;

import ch.qos.logback.core.property.FileExistsPropertyDefiner;
import ml.java.boot2.autoconfig.Other;
import ml.java.boot2.autoconfig.Pet;
import ml.java.boot2.autoconfig.User;
import ml.java.library.domains.Greeter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ConditionContext;

@SpringBootTest
class SpringBoot2ApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Greeter greeter;

    @Test
    void autoConfig(){
        System.out.println("contain Aloha? " + applicationContext.containsBean("aloha"));
        applicationContext.getBean("ml.java.boot2.autoconfig.Other", Other.class).moan(); //id=全路径类名
        applicationContext.getBean("user", User.class).say("hello");
        applicationContext.getBean("tomcat", Pet.class).meow(); //当注释掉@Bean("bobcat")时tomcat不会创建
    }

    @Test
    void starter(){
        System.out.println(greeter.greet());
    }

}
