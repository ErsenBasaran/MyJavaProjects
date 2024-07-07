package MaceraOyunu;
// Location'da getter-setter oluşturduktan sonra bu classı açtık.
public abstract class NormalLoc extends Location { // böyle yazınca altını krmızı çiziyor. super çağrısı yapmalıyız


    NormalLoc(Player player, String name) { // String name yoktu superde. biz ekledik. Location'dan gelen bir parametre
        super(player); // yukarıda altı kırmızı yere basıp super çağrısı oluşturduk
        this.name= name; // this.name=name'i biz ekledik, kendi gelmedi.
                    // sadece player var çünkü location classında sadece ona constructor oluşturduk
    }
    public boolean getLocation(){ // abstract olmadığı için elle yazdık, önermedi
        return true; // true döndürsün istedik çünkü burası ev veya mağaza. ölüm yok.
    }

}
