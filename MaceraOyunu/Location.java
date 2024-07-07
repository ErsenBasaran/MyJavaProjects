package MaceraOyunu;

import java.util.Scanner;

public abstract class Location {

    protected Player player;
    protected String name;
Scanner scan = new Scanner(System.in); // bunu buraya ekledik, alt classlarda Scanner yazmaya gerek kalmayacak
    Location(Player player){  // constructor oluşturduk
        this.player=player;


    }

public abstract boolean getLocation(); // bodysiz çünkü abstract. yani soyut.
    // her yerde lokasyona bağlı olarak bir method çalışacak
    // boolean çünkü lokasyona göre oyuncu ölebilir/ yaşayabilir

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

