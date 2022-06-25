package src.GeneralProgram;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Smartphone{
	String os() default "Symbian";
	int version() default 1;
}

public class CustomAnnotation {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		NokiaASeries obj = new NokiaASeries("Fire", 5);
		Class c = obj.getClass();
		Annotation an = c.getAnnotation(Smartphone.class);
		Smartphone s = (Smartphone) an;
		System.out.println(s.os());
	}
}
