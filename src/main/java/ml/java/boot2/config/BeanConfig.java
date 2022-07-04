package ml.java.boot2.config;

import ml.java.boot2.config.bean.Pet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.*;

//@Import({Other.class}) //单独导入组件，id默认全路径类名！
@Import({ImportSel.class}) //使用ImportSelector批量导入
@ImportResource("classpath:beans.xml") //导入xml配置
@Configuration(proxyBeanMethods = false)
@Conditional(OsCondition.class) //根据Condition判断是否激活配置类
//@EnableConfigurationProperties(People.class) //对User进行自动绑定application.properties.user1，此时User不加@Component！
public class BeanConfig {

    @Bean("bobcat") //@Bean多用于无@Component注解的三方包？
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

    @Configuration
    class AutoInnerConfig{

        @Bean("innercat")
        public Pet innercat(){
            Pet pet = new Pet();
            pet.setType("innercat");
            return pet;
        }

    }

}
