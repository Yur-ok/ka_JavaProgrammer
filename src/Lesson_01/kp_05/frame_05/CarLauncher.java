package Lesson_01.kp_05.frame_05;

/**
 * Created by Юрий on 18.02.2016.
 */
public class CarLauncher {
    public static void main(String[] args) {
        Car x5 = new Car();
        x5.setColors(Colors.DARKBLUE);
        x5.startEngine();
        x5.setColorDayLigth(Colors.GREENYELLOW);
        x5.turnLightOn();
        x5.drive();
        x5.ai();
        x5.stop();
        x5.stopEngine();
        x5.carInfo();

        Car fx = new Car("Infinity", "FX", 234, 3.2, Colors.INDIGO);
        fx.carInfo();
    }
}
