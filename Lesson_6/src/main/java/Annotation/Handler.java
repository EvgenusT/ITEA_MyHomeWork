package Annotation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class Handler<T> {

       public static void main(String[] args) throws Exception {
        Handler<AppAnnotation> appAnnotationHandler = new Handler<>();
        AppAnnotation appAnnotation = new AppAnnotation();
        appAnnotationHandler.handle(appAnnotation);
        System.out.println(appAnnotation);
    }

    public void handle(T obj) {
        Class<?> clazz = obj.getClass();

        List<Field> declareField = Arrays.asList(clazz.getDeclaredFields());
        declareField.stream().filter(this::hasValueAnnotation).forEach(field -> initializeValue(field, obj));

    }

    private boolean hasValueAnnotation(Field field) {
        return Objects.nonNull(field.getAnnotation(Value.class));
    }

    private void initializeValue(Field field, T obj) {
        String value = field.getAnnotation(Value.class).value();
        field.setAccessible(true);
        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

