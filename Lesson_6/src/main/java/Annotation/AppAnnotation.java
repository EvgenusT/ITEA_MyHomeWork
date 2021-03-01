package Annotation;

@Service
public class AppAnnotation {

    @Value("Evgen")
    public String name;

    public int age;

    @Value("Tantsura")
    String lastName;

    public AppAnnotation(int age) {
        this.age = age;
    }

    public AppAnnotation(String name) {
        this(name.hashCode());
        this.name = name;
    }

    public AppAnnotation() {
        this(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AppAnnotation{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getId() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.age = id;
    }

}
