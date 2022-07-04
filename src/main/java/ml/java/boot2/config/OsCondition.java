package ml.java.boot2.config;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //系统类型，IDEA中在测试选项中VM options读取-Dos.name=linux
        return context.getEnvironment().getProperty("os.name").contains("linux");
    }
}
