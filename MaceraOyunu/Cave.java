package MaceraOyunu;

public class Cave extends BattleLoc{
    Cave(Player player) { // String name, Obstacle obstacle sildik
        super(player, "Mağara", new Zombie(),"Food"); // name ve obstacle'ı elle değiştirdik
    }
}
