package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {

    String value()default "Name default";
}

/*
Создать аннотацию @Value(“some value”), которую можно применить только для
полей класса. Поля с такой аннотацией должны быть проинициализированы
значением.

3. Создать аннотацию @Service.

a. Ее можно использовать только над классами.
b. Если класс имеет аннотацию @Service, то все классы наследники тоже
должны быть неявно помечены этой аннотацией
 */