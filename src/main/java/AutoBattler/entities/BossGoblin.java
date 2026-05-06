package AutoBattler.entities;

public class BossGoblin extends Boss{

    //CONSTRUCTORS

    //Constructor with parameters
    public BossGoblin(int hp, int attack, int defense, int speed, String type, String name){
        super(hp, attack, defense, speed, type, name);
    }

    public BossGoblin(BossGoblin other){
        super(other);
    }

    public BossGoblin(String name){
        super(300, 50, 30, 20, "Goblin", name);
    }

    //Constructor without parameters
    public BossGoblin(){
        super("Name");
    }

    @Override
    public Fighter minion() {
        return new Goblin();
    }

    @Override
    public Fighter clone() {
        return new BossGoblin(this);
    }

    @Override
    public String getName() {
        return "King Zogmar";
    }

    @Override
    public String specialAbility() {
        return "";
    }

    @Override
    public String lore() {
        return "";
    }
}