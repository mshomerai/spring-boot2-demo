package ml.java.boot2.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
//@ConditionalOnXXX //也可以在配置上使用来控制整个配置类起效
public class AutoConfig {

    @Bean("bobcat")
    public Pet bobcat(){
        Pet pet = new Pet();
        pet.setType("bobcat");
        return pet;
    }

    @Bean("tomcat")
    @ConditionalOnBean(name = "bobcat")
    public Pet tomcat(){
        Pet pet = new Pet();
        pet.setType("tomcat");
        return pet;
    }

}
