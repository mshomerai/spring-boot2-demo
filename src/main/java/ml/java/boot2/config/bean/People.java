package ml.java.boot2.config.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user1") //自动绑定application.properties.user1
public class People {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void say(String word){
        System.out.println(name + " say: " + word);
    }

}
