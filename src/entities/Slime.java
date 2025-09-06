package entities;

public class Slime extends Monster{

    //CONSTRUCTORS

    //Constructor with parameters
    public Slime(int hp, int attack, int defense, int speed, String type, String name){
        super(hp,attack,defense,speed,type, name);
    }

    public Slime(Slime other){
        super(other);
    }

    public Slime(String name){
        super(80,25,15,15,"Slime", name);
    }

    //Constructor without parameters
    public Slime(){
        this("Name");
    }

    @Override
    public void takeDamage(int damage, Fighter f){
        super.takeDamage(damage, f);
        if (this.getHp() <= 0) {
            if (this.getTeam().size() < 5) {
                System.out.print(" Le slime se divise");
                this.getTeam().add(new BabySlime());
                this.getTeam().add(new BabySlime());   
            }
        }
    }

    @Override
    public void takeMagicalDamage(int damage, Fighter f){
        super.takeMagicalDamage(damage, f);
        if (this.getHp() <= 0) {
            if (this.getTeam().size() < 5) {
                System.out.println("Le slime se divise");
                this.getTeam().add(new BabySlime());
                this.getTeam().add(new BabySlime());
            }
        }
    }

    public Fighter clone(){
        return new Slime(this);
    }

    @Override
    public String getName() {
        return "Slime";
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