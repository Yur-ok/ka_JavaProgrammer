package Lesson_01.kp_05.frame_05;

/**
 * Created by Юрий on 18.02.2016.
 */
public class Car {

    private Colors colors;

    private String manufactureName;
    private String modelName;
    private int doorNum;
    private int seatNum;
    private String colorDayLigth;
    private String colorStopLigth;
    private int maxSpeed;
    private double acceleration;

    public Car() {
        manufactureName = null;
        modelName = null;
        doorNum = 0;
        seatNum = 0;
        colorDayLigth = null;
        colorStopLigth = null;
        maxSpeed = 0;
        acceleration = 0;
    }

    public Car(String manufactureName, String modelName, int maxSpeed, double acceleration, Colors colors) {
        this.manufactureName = manufactureName;
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.colors = colors;
    }

    public Colors getColors() {
        System.out.println("Required cars color.\nCurrent color is " + colors + "\n");
        return colors;
    }

    public void setColors(Colors colors) {
        System.out.println("Set color for car.\nNow color is " + colors + "\n");
        this.colors = colors;
    }

    public String getManufactureName() {
        System.out.println("Ask about brand.\nBrand is: " + manufactureName);
        return manufactureName;
    }

    public String getModelName() {
        System.out.println("Ask about model.\nModel is: " + modelName);
        return modelName;
    }

    public int getDoorNum() {
        System.out.println("The number of door is: " + doorNum);
        return doorNum;
    }

    public int getSeatNum() {
        System.out.println("Amount of seats is: " + seatNum);
        return seatNum;
    }

    public String getColorDayLigth() {
        System.out.println("Current color of day light is " + colorDayLigth);
        return colorDayLigth;
    }

    public void setColorDayLigth(Colors colors) {
        this.colorDayLigth = String.valueOf(colors);
        System.out.println("Change color of Day Lights on the " + colorDayLigth + "\n");
    }

    public void setColorStopLigth(Colors colors) {
        this.colorStopLigth = String.valueOf(colors);
        System.out.println("Change color of Stop Lights on the " + colorStopLigth + "\n");
    }

    public int getMaxSpeed() {
        System.out.println("Required max speed.");
        return maxSpeed;
    }

    public double getAcceleration() {
        System.out.println("Made chip tuning for change acceleration!\nNew acceleration is: " + acceleration);
        return acceleration;
    }

    public void startEngine() {
        System.out.println("Engine is turn ON-n-n-n!");
    }

    public void stopEngine() {
        System.out.println("Engine turn OFF!");
    }

    public void turnLightOn() {
        System.out.println("Light is turn ON!");
    }

    public void drive() {
        System.out.println("Car is driven by PROFI!\nRelax.");
    }

    public void stop() {
        System.out.println("Car is stopped.");
    }

    public void ai() {
        System.out.println("Artificial Intelligence is ON.\nPray!!! :)");
    }

    public void carInfo() {
        System.out.println(
                "Brand name is: " + manufactureName +
                        "\nModel: " + getModelName() +
                        "\nColor is: " + getColors() +
                        "\nMax speed: " + getMaxSpeed() + " km/h" +
                        "\nAcceleration: " + getAcceleration() + " sec till 100km/h"
        );
    }
}
