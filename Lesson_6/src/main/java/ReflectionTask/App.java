package ReflectionTask;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class App {

    public static void main(String[] args) throws Exception {
        Constructor<A> constructors = (Constructor<A>) A.class.getDeclaredConstructors()[0];
        constructors.setAccessible(true);
        A myClass = constructors.newInstance();
        constructors.setAccessible(false);

        System.out.println("Создан обьект класса A без изменений: " + myClass);

        Field id = myClass.getClass().getDeclaredField("id");
        id.setAccessible(true);
        String idValueBefore = (String) id.get(myClass);
        System.out.println("id без изменений: " + idValueBefore);
        id.set(myClass, "321");
        String idValueAfter = (String) id.get(myClass);
        System.out.println("id после изменений: " + idValueAfter);
        id.setAccessible(false);

        Field name = myClass.getClass().getDeclaredField("name");
        name.setAccessible(true);
        String nameValueBefore = (String) name.get(myClass);
        System.out.println("name без изменений: " + nameValueBefore);
        name.set(myClass, "ITEA");
        String nameValueAfter = (String) name.get(myClass);
        System.out.println("name после изменений: " + nameValueAfter);
        name.setAccessible(false);

        System.out.println("Обьект класса A после изменений: " + myClass);
    }
}