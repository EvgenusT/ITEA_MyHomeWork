package Annotation;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ClassScanning<T> {



    public static void main(String[] args) throws Exception {

        new ClassScanning().getAllClassesByFilter("Annotation");
    }

    private static void getAllClassesByFilter(String packageName) throws Exception {

        Map<String, Object> map = new HashMap<>();

        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Service.class);

        for (Class<?> s : classes){
            map.put(s.getCanonicalName(), getNewObject(s));
        }
        System.out.println(map);

    }

    private static Object getNewObject(Class<?> classes) throws Exception {
        Constructor constructors = classes.getDeclaredConstructors()[0];
        constructors.setAccessible(true);
        Object myClass = constructors.newInstance();
        constructors.setAccessible(false);
        return myClass;
    }

}
