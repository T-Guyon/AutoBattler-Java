package entities;

import teams.*;

public class Spider extends Monster{

    //ATTRIBUTE
    private boolean web;
    private int turn;

    //CONSTRUCTORS

    //Constructors with parameters
    public Spider(int hp, int attack, int defense, int speed, String type, String name){
        super(hp, attack, defense, speed, type, name);
        this.web = false;
        this.turn = 0;
    }

    public Spider(Spider other){
        super(other);
    }

    public Spider(String name){
        super(170, 55, 20, 85, "Spider", name);
    }

    //Constructors without parameters
    public Spider(){
        this("Name");
    }

    @Override
    //!A modifier
    public void attack(Team enemy){
        Fighter target = enemy.randomFighter();
        if(!this.web){
            target.updateSpeed(getSpeed()/2);
            this.web = true;
        }
        if(this.web && this.turn == 5){
            this.web = false;
            this.turn = 0;
            target.updateSpeed(target.getBaseSpeed());
        }
        target.takeDamage(this.getAttack(), this);;
    }

    @Override
    public void takeDamage(int damage, Fighter f){
        super.takeDamage(damage, f);
        if(this.getHp() <= 0){
            this.web = false;
        }
        
    }

    public Fighter clone(){
        return new Spider(this);
    }

    @Override
    public String getName() {
        return "Spider";
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