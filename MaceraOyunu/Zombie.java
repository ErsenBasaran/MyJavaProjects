package MaceraOyunu;

public class Zombie extends Obstacle{


    public Zombie() {
        super("Zombi", 3, 10, 4, 3);
        // contructor oluşturup iki üst satırdaki parantez içini sildi. bir üst satırda parametreleri silip elle girdi
        // super.name ="Zombi"    // obstacle'da name'i private değil protected tanımlasaydık name'i böyle de alabilirdik
    }
}
