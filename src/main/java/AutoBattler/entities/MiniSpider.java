package AutoBattler.entities;

public class MiniSpider extends Monster{

    public MiniSpider(String name){
        super(50, 15, 5, 30, "Spider", name);
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
