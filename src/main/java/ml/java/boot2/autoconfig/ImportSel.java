package ml.java.boot2.autoconfig;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ImportSel implements ImportSelector {
    /**
     * @param importingClassMetadata 所在配置类中所有注解对象
     * @return 全类名文字数组
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"ml.java.boot2.autoconfig.Other"};
    }

}
