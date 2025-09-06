package entities;

public class Dummies extends Monster{

    public Dummies(int hp, int attack, int defense, int speed, String type, String name) {
        super(hp, attack, defense, speed, type, name);
    }

    public Dummies(Dummies other){
        super(other);
    }

    public Dummies(String name){
        super(100,0,0,0,"Dummie", name);
    }

    public Dummies(){
        this("Name");
    }

    @Override
    public void takeDamage(int damage, Fighter f){
        super.takeDamage(damage, f);
    }

    @Override
    public Fighter clone(){
        return new Dummies(this);
    }

    @Override
    public String getName() {
        return "Dummie";
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