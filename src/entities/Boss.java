package entities;

public abstract class Boss extends Monster{

    //ATTRIBUTES
    private boolean enraged;
    private boolean summoned;

    //CONSTRUCTORS

    //Constructor with parameters
    public Boss(int hp, int attack, int defense, int speed, String type, String name){
        super(hp, attack, defense, speed, type, name);
        enraged = false;
        summoned = false;
    }

    public Boss(Boss other){
        super(other);
    }

    public Boss(String name){
        super(300,50,50,70,"Boss",name);
    }

    //Constructor without parameters
    public Boss(){
        this("Name");
    }

    @Override
    public void takeDamage(int damage, Fighter f){
        super.takeDamage(damage, f);
        if (!this.enraged && this.getHp() <= this.getBaseHp() / 2) {
            enraged = true;
            System.out.print("The Boss  becomes ENRAGED !");
            updateAttack(this.getAttack() * 2);
        }
        if (!this.summoned && this.getHp() <= this.getBaseHp() * 0.3 && getTeam().size() < 4) {
            summoned = true;
            System.out.print(getName() + " summons their minions");
            getTeam().add(minion());
            getTeam().add(minion());
        }
    }

    public abstract Fighter minion();
    
}