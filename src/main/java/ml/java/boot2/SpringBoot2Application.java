package ml.java.boot2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication //相当于：@SpringBootConfiguration+@EnableAutoConfiguration+@ComponentScan
@SpringBootApplication(scanBasePackages = {"ml.java"}) //默认扫描SpringBoot2Application.java同级和下级路径中所有，上级路径的不扫描！可配置scanBasePackages进行变更默认
public class SpringBoot2Application {

    //boot项目启动主程序
    public static void main(String[] args) {
        // run：启动所生成的容器
        ConfigurableApplicationContext run = SpringApplication.run(SpringBoot2Application.class, args);
        /** 查看容器中所有加载的bean
        for(String beanDefinitionName : run.getBeanDefinitionNames()){
            System.out.println(beanDefinitionName);
        }
        */
        //run.getBean("tomcat", Pet.class).meow();
    }

}
