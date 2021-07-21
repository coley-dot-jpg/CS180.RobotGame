import static java.lang.Integer.parseInt;

/**
 * Project 5 - RobotOwner.java
 *
 * This maintains the correct amount of money for the robot and allows the user to modify the number of weapons or
 *  upgrade their robot and access values like the users money, their robot, their robots attack, and a string
 *  representing their robot to display all this information.k
 *
 * @author Emelie Coleman - colem109, sec. L17
 *
 * @version April 26, 2019
 *
 */

public class RobotOwner {
    private double money;
    private Robot myRobot;

    public RobotOwner() {
    }

    public String getRobot(String name) {
        switch (name) {
            case "Iron":
                if (this.money >= ConstantNumber.IRON_ROBOT_SALE_PRICE) {
                    this.money  -= ConstantNumber.IRON_ROBOT_SALE_PRICE;
                    this.myRobot = new IronRobot();
                    return ConstantNumber.GET_ROBOT;
                }
                break;
            case "Silver":
                if (this.money >= ConstantNumber.SILVER_ROBOT_SALE_PRICE) {
                    this.money  -= ConstantNumber.SILVER_ROBOT_SALE_PRICE;
                    this.myRobot = new SilverRobot();
                    return ConstantNumber.GET_ROBOT;
                }
                break;
            case "Gold":
                if (this.money >= ConstantNumber.GOLD_ROBOT_SALE_PRICE) {
                    this.money  -= ConstantNumber.GOLD_ROBOT_SALE_PRICE;
                    this.myRobot = new GoldRobot();
                    return ConstantNumber.GET_ROBOT;
                }
                break;
        }
        return ConstantNumber.GET_ROBOT_ERROR;
    }

    public String upgradeRobot(String name) {
        double sellingPrice = this.myRobot.getPrice();
        switch (name) {
            case "Silver":
                if (this.myRobot.getName().equals("Iron Robot")) {
                    SilverRobot newRobot = new SilverRobot(this.myRobot);
                    if (this.money + sellingPrice >= newRobot.getPrice()) {
                        this.myRobot = newRobot;
                        this.money += (sellingPrice - newRobot.getPrice());
                        return ConstantNumber.UPGRADE_ROBOT;
                    } else {
                        return ConstantNumber.NUMBER_ERROR;
                    }
                }
                break;
            case "Gold":
                if (this.myRobot.getName().equals("Silver Robot") || this.myRobot.getName().equals("Iron Robot")) {
                    GoldRobot newRobot = new GoldRobot(this.myRobot);
                    if (this.money + sellingPrice >= newRobot.getPrice()) {
                        this.myRobot = newRobot;
                        this.money += (sellingPrice - newRobot.getPrice());
                        return ConstantNumber.UPGRADE_ROBOT;
                    } else {
                        return ConstantNumber.NUMBER_ERROR;
                    }
                }
                break;
        }
        return ConstantNumber.UPGRADE_ERROR;
    }

    public String addWeapon(int num) {
        if (this.money >= ConstantNumber.WEAPON_SALE_PRICE * num  && num > 0) {
            this.money -= ConstantNumber.WEAPON_SALE_PRICE * num;
            this.myRobot.addWeapon(num);
            return ConstantNumber.BUY_WEAPONS;
        }
        return ConstantNumber.NUMBER_ERROR;
    }

    public String sellWeapon(int num) {
        if (num <= this.myRobot.getWeapon() && num > 0) {
            this.money += num * ConstantNumber.WEAPON_SALE_PRICE / 2;
            this.myRobot.addWeapon(0 - num);
            return ConstantNumber.SELL_WEAPONS;
        }
        return ConstantNumber.NUMBER_ERROR;
    }

    public String printRobot() {
        return String.format("Name: %s; Attack: %d; Weapons: %d; Price: %.1f", this.myRobot.getName(),
                this.myRobot.getAttack(), this.myRobot.getWeapon(), this.myRobot.getPrice());
    }

    public void receiveMoney(double receivedMoney) {
        this.money += receivedMoney;
    }

    public double getMoney() {
        return this.money;
    }

    public Robot getMyRobot() {
        return this.myRobot;
    }

    public int getAttack() {
        return this.myRobot.getAttack();
    }

    public String operateCommand(String command) {
        String output = "";
        String[] commands = command.split(";");
        try {
            for (int i = 0; i < commands.length; i++) {
                String[] oneCommand = commands[i].split(":");
                switch (oneCommand[0]) {
                    case "BuyWeapon":
                        output += addWeapon(parseInt(oneCommand[1]));
                        break;
                    case "SellWeapon":
                        output += sellWeapon(parseInt(oneCommand[1]));
                        break;
                    case "Upgrade":
                        output += upgradeRobot(oneCommand[1]);
                        break;
                    default:
                        output += ConstantNumber.COMMAND_ERROR;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return ConstantNumber.COMMAND_ERROR;
        }
        return output;
    }
}