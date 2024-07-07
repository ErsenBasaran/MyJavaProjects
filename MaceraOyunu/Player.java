package MaceraOyunu;

import java.util.Scanner;

public class Player {
    private int damage, healthy, money,reHealthy;
    private String name,cName;
    private Inventory inv;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory(); // bu satırı Inventory classını açınca yazdık
    }

    public void selectCha(){  // sonra return olmayacağı için void
        switch(chaMenu()){
            // samuray seçildi
            case 1:
                initPlayer("Samuray", 5,21,55);
                break;
            case 2:
                initPlayer("Okçu", 7,18,20);
                break;
            case 3:
                initPlayer("Şovalye", 5,21,15);
                break;
            default:
                setcName("Samuray");
                setDamage(5);
                setHealthy(21);
                setMoney(15);
                break;
        }
        System.out.println("Karakteriniz : " + getcName()+ "\t Hasar : " + getDamage()+ "\t Sağlık : "+ getHealthy() + "\t Para : " + getMoney());
    }

    public int chaMenu(){
        System.out.println("Lutfen bir karakter seciniz:");
        System.out.println("1- Samuray \t Hasar :5 \t Sağlık : 21 \t Para : 15");
        System.out.println("2- Okçu \t Hasar :7 \t Sağlık : 18 \t Para : 20");
        System.out.println("3- Şövalye \t Hasar :8 \t Sağlık : 24 \t Para : 5");
        System.out.println("Karakter Seçiminiz: ");
        int chaID = scan.nextInt();

        while(chaID<1 || chaID>3){
            System.out.println("Lutfen gecerlşi bir karakter seciniz:");
            chaID = scan.nextInt();
        }

        return chaID;
    }


    public int getTotalDamage(){ // ToolStore'da silah alınca toplam hasarı ilk + alınan diye uzun yazmıştık. onu kısaltmak için.
        return this.getDamage() + this.getInv().getDamage();
    }

    public void initPlayer(String cName,int damage, int hlthy, int money){
        setcName(cName);
        setDamage(damage);
        setHealthy(hlthy);
        setMoney(money);
        setReHealthy(hlthy);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
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

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getReHealthy() {
        return reHealthy;
    }

    public void setReHealthy(int reHealthy) {
        this.reHealthy = reHealthy;
    }
}
