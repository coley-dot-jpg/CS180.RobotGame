/**
 * Project 5 - SilverRobot.java
 *
 * This class implements the Robot interface and can create an SilverRobot object from scratch or from another robot
 *  with a set sale price, name, attack, and weapons. The number of weapons can be modified which changes the attack
 *  and sale price.
 *
 * @author Emelie Coleman - colem109, sec. L17
 *
 * @version April 26, 2019
 *
 */

public class SilverRobot implements Robot {

    private String name;
    private int attack;
    private double price;
    private int weapons;

    public SilverRobot() {
        this.name = "Silver Robot";
        this.attack = ConstantNumber.SILVER_ROBOT_ATTACK;
        this.price = ConstantNumber.SILVER_ROBOT_SALE_PRICE / 2;
        this.weapons = 0;
    }
    public SilverRobot(Robot r) {
        this.name = "Silver Robot";
        this.weapons = r.getWeapon();
        this.price = ConstantNumber.SILVER_ROBOT_SALE_PRICE + (this.weapons * ConstantNumber.WEAPON_SALE_PRICE / 2);
        this.attack = ConstantNumber.SILVER_ROBOT_ATTACK + (this.weapons * ConstantNumber.WEAPON_ATTACK * 2);
    }
    public void addWeapon(int number) {
        this.weapons += number;
        this.attack += number * ConstantNumber.WEAPON_ATTACK * 2;
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
