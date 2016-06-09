package Lesson_03.kp_05.Menu;

/**
 * Created by Юрий on 07.05.2016.
 */
public class Menu extends Ingridients {

//    public String[][] menu = {{"Black coffee", "Coffee with milk", "Coffee Americano", "Capuchino", "Makachino", "Black Tea",
//    "Green Tea", "Tea with behemoth"}};

    public int BlackCoffee = getWater() + getCoffe();
    public int CoffeeWithMilk = getWater() + getCoffe() + getMilk();
    public int BlackTea = getWater() + getSugar() + getBlackTea();
    public int GreenTea = getWater() + getGreenTea() + getSugar();
    public int TeaWithBerghamot = getWater() + getBerghamot() + getSugar();

}
