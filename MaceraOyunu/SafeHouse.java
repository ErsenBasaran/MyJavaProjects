package MaceraOyunu;

public class SafeHouse extends NormalLoc{

    SafeHouse(Player player) {
        super(player, "Güvenli Ev"); // name'yi silip bunu elle yazdık
    }

    public boolean getLocation(){ // üst class olan NormalLoc'taki getLocation'a override
        player.setHealthy(player.getReHealthy());
        System.out.println("Canınız fullendi");
        System.out.println("Şu an Güvenli Ev adlı yerdesiniz...");
        return true;


    }

}
