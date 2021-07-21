/**
 * Project 5 - GoldRobot.java
 *
 * This class implements the Robot interface and can create an GoldRobot object from scratch or from another robot
 *  with a set sale price, name, attack, and weapons. The number of weapons can be modified which changes the attack
 *  and sale price.
 *
 * @author Emelie Coleman - colem109, sec. L17
 *
 * @version April 26, 2019
 *
 */

public class GoldRobot implements Robot {

    private String name;
    private int attack;
    private double price;
    private int weapons;

    public GoldRobot() {
        this.name = "Gold Robot";
        this.attack = ConstantNumber.GOLD_ROBOT_ATTACK;
        this.price = ConstantNumber.GOLD_ROBOT_SALE_PRICE / 2;
        this.weapons = 0;
    }

    public GoldRobot(Robot r) {
        this.name = "Gold Robot";
        this.weapons = r.getWeapon();
        this.price = ConstantNumber.GOLD_ROBOT_SALE_PRICE + (this.weapons * ConstantNumber.WEAPON_SALE_PRICE / 2);
        this.attack = ConstantNumber.GOLD_ROBOT_ATTACK + (this.weapons * ConstantNumber.WEAPON_ATTACK * 3);
    }

    public void addWeapon(int number) {
        this.weapons += number;
        this.attack += number * ConstantNumber.WEAPON_ATTACK * 3;
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
