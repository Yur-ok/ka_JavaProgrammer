package Lesson_02.kp_06;

/**
 * Created by Юрий on 08.03.2016.
 */
public class Transaction {

    private Birds birds;
    private Customers customers;


    public void price(Birds[] birds) {
        for (Birds b : birds) {
            System.out.println(b.getType() + " - " + "$" + b.getPrice());
        }
    }

    public void inStock(Birds[] birds) {
        for (Birds b : birds) {
            System.out.println(b.getType() + " - " + b.getAmount() + " pcs.");
        }
    }

    public void todayTransactions(String[][] c) {

        System.out.println();
    }

    protected static void todayTransact(String[][] clients) {

        System.out.println("№" + " " + "Покупатель" + " " + "Птица" + " " + "Цена" + " " + "Кол-во");
        for (int i = 0; i < clients.length; i++) {
            if (i < clients[i].length) {
                System.out.print(clients[0][i] + " ");
                System.out.print(clients[1][i] + " ");
                System.out.print(clients[2][i] + " ");
                System.out.print(clients[3][i] + " ");
                System.out.println(clients[4][i]);
            }
        }
        summary(clients);
        System.out.println("===============================");
    }

    private static void summary(String[][] clients) {
        int qty = 0;
        double qtyPrice = 0;
        int qtySum = 0;
        for (int i = 0; i < clients[i].length; i++) {
            qty += Integer.parseInt(clients[0][i]);
            qtyPrice += Double.parseDouble(clients[3][i]);
            qtySum += Integer.parseInt(clients[4][i]);
        }
        System.out.println("Итого:" + qty + " продано," + " $" + qtyPrice + " заработано, " + "общее кол-во " + qtySum);
    }

    public int[] getBuysInLastSevenDays() {
        return buysInLastSevenDays;
    }

    private int[] buysInLastSevenDays = {3, 4, 6, 3, 1, 2, 9};

}
