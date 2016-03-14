package Lesson_02.kp_06;

/**
 * Created by Юрий on 08.03.2016.
 */
public class Birds {

    private String type;
    private int amount;
    private double price;
    private int discount;

    public Birds() {

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}