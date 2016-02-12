package Lesson_01.kp_02.frame_13;

/**
 * Created by Юрий on 12.02.2016.
 */
public class PrintTankInfo {

    public static void printTankInfo(Tank[] t) {
        for (int i = 0, j = 1; i <= t.length - 1; i++, j++) {
            System.out.print("Tank - " + j + " >>> ");
            System.out.print("Current Info: [color = " + t[i].color + " : crew = " + t[i].crew + " : max_speed = " +
                    t[i].maxSpeed + "]\n");
        }
    }

    public static void fillTanksArr(Tank[] t) {
        for (int i = 0; i <= t.length - 1; i++) {
            t[i] = new Tank("green", 4, 160);
        }
    }

    public static void main(String[] args) {
        Tank[] tanks = new Tank[5];
        fillTanksArr(tanks);
        printTankInfo(tanks);

    }
}
