package AutoBattler.entities;

public class Rat extends Monster{


    public Rat(String name){
        super(40, 10, 5, 35, "Rat", name);
    }

    public Rat(){
        super("Name");
    }

    @Override
    //TODO
    public Fighter clone() {
        return null;
    }

    @Override
    //TODO
    public String specialAbility() {
        return "";
    }

    @Override
    //TODO
    public String lore() {
        return "";
    }
}