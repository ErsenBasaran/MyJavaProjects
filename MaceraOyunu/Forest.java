package MaceraOyunu;

public class Forest extends BattleLoc{

    Forest(Player player) { // String name, Obstacle obstacle sildik
        super(player, "Orman", new Vampire(),"Firewood"); // name ve obstacle'ı elle değiştirdik
    }
}
