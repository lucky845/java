package 注解;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author lichuang
 * @create 2021-07-05 15:34
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {

    String value()default"hello";

}
