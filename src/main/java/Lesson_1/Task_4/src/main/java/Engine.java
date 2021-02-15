package Lesson_1.Task_4.src.main.java;

public class Engine {

    private double volume;
    private int rpm;
    private String compressionRatio;

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public int getRpm() {
        return rpm;
    }

    public String getCompressionRatio() {
        return compressionRatio;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public void setCompressionRatio(String compressionRatio) {
        this.compressionRatio = compressionRatio;
    }
}



