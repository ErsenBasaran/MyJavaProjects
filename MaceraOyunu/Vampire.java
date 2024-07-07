package MaceraOyunu;

public class Vampire extends Obstacle{


    public Vampire() {
        super("Vampir", 4, 14, 7, 3);
// contructor oluşturup iki üst satırdaki parantez içini sildi. bir üst satırda parametreleri silip elle girdi
        // super.name ="Vampir"    // obstacle'da name'i private değil protected tanımlasaydık name'i böyle de alabilirdik
    }
}
