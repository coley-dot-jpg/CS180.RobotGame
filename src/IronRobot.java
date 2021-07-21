/**
 * Project 5 - IronRobot.java
 *
 * This class implements the Robot interface and creates an IronRobot object with a set sale price, name, attack, and
 *  weapons. The number of weapons can be modified which changes the attack and sale price.
 *
 * @author Emelie Coleman - colem109, sec. L17
 *
 * @version April 26, 2019
 *
 */

public class IronRobot implements Robot {

    private String name;
    private int attack;
    private double price;
    private int weapons;

    public IronRobot() {
        this.name = "Iron Robot";
        this.attack = ConstantNumber.IRON_ROBOT_ATTACK;
        this.price = ConstantNumber.IRON_ROBOT_SALE_PRICE / 2;
        this.weapons = 0;
    }

    public void addWeapon(int number) {
        this.weapons += number;
        this.attack += number * ConstantNumber.WEAPON_ATTACK;
        this.price += number * (ConstantNumber.WEAPON_SALE_PRICE / 2);
    }

    public String getName() {
        return this.name;
    }

    public int getAttack() {
        return this.attack;
    }

    public double getPrice() {
        return this.price;
    }

    public int getWeapon() {
        return this.weapons;
    }
}
