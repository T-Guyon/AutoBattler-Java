package AutoBattler.entities;

public class BabySlime extends Monster{

    //CONSTRUCTORS

    //Constructor with parameters
    public BabySlime(int hp, int attack, int defense, int speed, String type,String name){
        super(hp,attack,defense,speed,type,name);
    }

    public BabySlime(BabySlime other){
        super(other);
    }

    public BabySlime(String name){
        super(50,30,25,20,"Slime", name);
    }

    //Constructor without parameters
    public BabySlime(){
        super( "Name");
    }

    @Override
    public Fighter clone() {
        return new BabySlime(this);
    }

    @Override
    public String getName() {
        return "Baby Slime";
    }

    @Override
    public String specialAbility() {
        return "None";
    }

    @Override
    public String lore() {
        return "";
    }

}