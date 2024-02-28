import javax.tools.Tool;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private final Scanner input = new Scanner(System.in);
    private Inventory inventory;


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {


        GameChar[] charList = {new Samurai(), new Archer(), new Knight(), new Test()};

        System.out.println("######################################################################");
        for (GameChar gameChar : charList) {
            System.out.println(gameChar.getId() + "\t Karakter: " + gameChar.getName() + " \t Hasar: " + gameChar.getDamage() + " \t Sağlık: " + gameChar.getHealth() + " \t Para: " + gameChar.getMoney());
        }
        System.out.println("######################################################################");
        System.out.print("Lütfen bir karakter seçiniz: ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            case 4:
                initPlayer(new Test());
            default:
                System.out.println("Yanlış değer girdiniz. Lütfen 1 ile " + charList.length + " arasında bir değer giriniz.");
        }
        System.out.println("Karakter Özeti");
        printInfo();
    }


    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }


    public void printInfo() {
        System.out.println("Sağlık: " + this.getHealth() +
                "\tZırhınız: " + this.getInventory().getArmor().getName() +
                "\tSilahınız: " + this.getInventory().getWeapon().getName() +
                "\tBlock: " + this.getInventory().getArmor().getBlock() +
                "\tHasar: " + this.getDamage() + "\tPara: " + this.getMoney());
    }


    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
