package 反射二;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author lichuang
 * @create 2021-07-17 20:19
 */
@Target({TYPE,FIELD, METHOD,PARAMETER,CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

        String value() default "hello";

}
