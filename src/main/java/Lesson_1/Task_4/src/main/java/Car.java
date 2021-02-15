import Lesson_1.Task_4.src.main.java.Engine;
import Lesson_1.Task_4.src.main.java.SeatingCapacity;
import Lesson_1.Task_4.src.main.java.Speed;

public class Car {

    private String brand;
    private String model;
    private String[] colors;

    private Speed maxSpeed;
    private Engine engine;

    int seatingCapacity = SeatingCapacity.seatingCapacity;

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public Speed getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Speed maxSpeed) {
        this.maxSpeed = maxSpeed;
    }



    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
