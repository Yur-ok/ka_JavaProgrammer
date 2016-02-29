package Lesson_02.kp_05;

/**
 * Created by Юрий on 27.02.2016.
 */
public class BT7 extends Tank {
    public BT7() {
        setColor("Yellow");
        setCrew(3);
        setSpeed(70);
    }

    @Override
    public void move() throws Exception {
        System.out.println("BT7 is moving with " + getSpeed() + " km/h.");
    }

    @Override
    public String toString() {
        return "BT7 has next parameters: \nColor = " + getColor() + "\nSpeed = " + getSpeed() + "\nCrew = " + getCrew()
                + "\n";
    }
}
