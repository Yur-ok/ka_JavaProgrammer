package Lesson_02.kp_04;

/**
 * Created by Юрий on 28.02.2016.
 */
public class DarkZone {
    private int monthlyPayment; //ежемесячный взнос
    private int interest = 12;  //годовой процент
    private int dreamSum;       //желаемая сумма

    public static int darkZone(int monthlyPayment, int interest, int dreamSum) {
        int month = 0;
        int totalSum = 0;

        while (totalSum <= dreamSum) {
            int percent = (totalSum * (interest / 12) / 100);
            int res = totalSum + percent;
            totalSum = res + monthlyPayment;
            month++;
        }
        return month / 12;
    }

    public static void main(String[] args) {
        System.out.println(darkZone(100, 12, 1_000_000));

    }
}
