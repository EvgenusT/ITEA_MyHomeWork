package ReflectionTask;

public class A {
    private String id = "123";
    private String name = "A";

    private A() {
    }

    private A(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
