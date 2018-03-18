package ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//类
@Retention(RetentionPolicy.RUNTIME)//运行时有效
public @interface Entity {
//相当于spring里的@service注释
}

