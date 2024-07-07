package MaceraOyunu;

public class Bear extends Obstacle{

    public Bear() {
        super("Ayı", 7,20,12,2);
        // contructor oluşturup iki üst satırdaki parantez içini sildi. bir üst satırda parametreleri silip elle girdi
        // super.name ="Ayı"    // obstacle'da name'i private değil protected tanımlasaydık name'i böyle de alabilirdik
    }
}
