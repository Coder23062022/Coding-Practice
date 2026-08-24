package Krish.src.Exception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonElement {
    String key(); // A required attribute

    String value() default "n/a"; // An optional attribute with a default value
}