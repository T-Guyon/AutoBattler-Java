package AutoBattler.entities;

import AutoBattler.teams.*;

public class Bat extends Monster{

    public Bat(){
        super("Bat");
    }

    public Bat(String name){
        super(35, 12, 5, 40, "Bat", name);
    }

    public Bat (Bat other){
        super(other);
    }

    @Override
    public Fighter clone() {
        return new Bat(this);
    }

    @Override
    public String specialAbility() {
        return "";
    }

    @Override
    public String lore() {
        return "";
    }

    @Override
    public void attack(Team enemy){
        super.attack(enemy);
        if (getHp() < getBaseHp() && getHp() > 0) {
            super.regenerateHp((int) (getAttack() * 0.20));
        }
    }
}
