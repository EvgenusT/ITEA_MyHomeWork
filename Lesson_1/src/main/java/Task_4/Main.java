package Task_4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().go(formationJson());
    }

    private void go(String json) throws IOException {

        RandomAccessFile file = new RandomAccessFile("src/main/resources/nio_Task_4.json", "rw");
        file.seek(0);
        file.writeBytes(json);
        file.close();
    }

    private static String formationJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Car car = new Car();
        car.setBrand("Toyota");
        car.setModel("Camry");
        car.setColors(new String[]{"Red"});

        Speed maxSpeed = new Speed();
        maxSpeed.setUnit("km/h");
        maxSpeed.setValue(220);
        car.setMaxSpeed(maxSpeed);

        Engine engine = new Engine();
        engine.setVolume(2.5);
        engine.setRpm(6600);
        engine.setCompressionRatio("11.8:1");
        car.setEngine(engine);

        car.setSeatingCapacity(5);

        String resultCar = objectMapper.writeValueAsString(car);
        return resultCar;
    }
}
