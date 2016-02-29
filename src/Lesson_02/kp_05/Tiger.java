package Lesson_02.kp_05;

/**
 * Created by Юрий on 27.02.2016.
 */
public class Tiger extends Tank {

    public Tiger() {
        setColor("Orange");
        setCrew(4);
        setSpeed(56);
    }

    @Override
    public void move() throws Exception {
        System.out.println("Tiger is moving with " + getSpeed() + " km/h");
    }

    @Override
    public String toString() {
        return "Tiger has next parameters: \nColor = " + getColor() + "\nSpeed = " + getSpeed() + "\nCrew = " + getCrew()
                + "\n";
    }
}
