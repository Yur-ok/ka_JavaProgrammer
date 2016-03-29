package Lesson_02.kp_06.shopBirds;

import java.util.Arrays;

/**
 * Created by Юрий on 06.03.2016.
 */
public class Shop {
    private static int longestIdx = 0;

    public static void main(String[] args) {

        Birds[] birds = {new Eagle(), new Falcon(), new Owl()};
        String[][] clients = {{"1", "2", "3"}, {"Oleg", "Julia", "Ivan"}, {"Owl", "Falcon", "Eagle"},
                {"20.9", "43.5", "15"}, {"3", "1", "2"}};

        Transaction t = new Transaction();

        System.out.println("Bird's price is ...");
        t.price(birds);
        System.out.println();

        System.out.println("Amount in stock:");
        t.inStock(birds);
        System.out.println();

        System.out.println("Sales in last seven days:");
        System.out.println(Arrays.toString(t.getBuysInLastSevenDays()));
        System.out.println();

        System.out.println("Transaction for today");
        t.todayTransact(clients);

        System.out.println("Get catalog");
        Birds b = new Birds();
        b.printCatalog();
    }

    private static void getIdxLength(String[][] strings, int s) {
        for (int j = 0; j < strings[s].length; j++) {
            if (longestIdx < strings[s][j].length()) {
                longestIdx = strings[s][j].length();
            }
        }
    }

    private static void addSpace(String[][] s, int a, int b) {
        int numOfSpace = 0;
        if (s[a][b].length() < longestIdx) {
            numOfSpace = longestIdx - s[a][b].length();
        }
        while (numOfSpace != 0) {
            System.out.print(" ");
            numOfSpace--;
        }
    }
}
