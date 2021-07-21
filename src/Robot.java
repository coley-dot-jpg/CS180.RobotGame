/**
 * Project 5 - Robot.java
 *
 * This class is an interface which defines the methods to be used in IronRobot, SilverRobot, and GoldRobot which are
 *  all classes of type Robot
 *
 * @author Emelie Coleman - colem109, sec. L17
 *
 * @version April 26, 2019
 *
 */

public interface Robot {

    public void addWeapon(int number);
    public String getName();
    public int getAttack();
    public double getPrice();
    public int getWeapon();
}
