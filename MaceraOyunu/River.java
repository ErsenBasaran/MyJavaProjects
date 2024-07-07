package MaceraOyunu;

public class River extends BattleLoc{
    River(Player player) { // String name, Obstacle obstacle sildik
        super(player, "River", new Bear(),"Water"); // name ve obstacle'ı elle değiştirdik
    }
}
