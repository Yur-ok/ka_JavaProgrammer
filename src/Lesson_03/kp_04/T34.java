package Lesson_03.kp_04;

/**
 * Created by Юрий on 27.02.2016.
 */
public class T34 extends AbstractTank {

    public T34(ActionField af, BattleField bf) {
        super(af, bf);
        setColor("Green");
        setCrew(5);
        setSpeed(63);
    }

    @Override
    public void move() throws Exception {
        System.out.println("T34 is moving with " + getSpeed() + " km/h.");
    }

    @Override
    public String toString() {
        return "T34 has next parameters: \nColor = " + getColor() + "\nSpeed = " + getSpeed() + "\nCrew = " + getCrew()
                + "\n";
    }
}
