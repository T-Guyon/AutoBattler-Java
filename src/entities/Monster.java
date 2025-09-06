package entities;

public abstract class Monster extends Fighter{    
    
     // ### CONSTRUCTORS ###

    /**
     * Constructor with all parameters
     * 
     * @param hp      The monster's health points
     * @param attack  The monster's attack stat
     * @param defense The monster's defense stat
     * @param speed   The monster's speed stat
     * @param type    The monster's type (e.g., Slime, Dragon)
     */
    public Monster(int hp, int attack, int defense, int speed, String type, String name){
        super(hp, attack, defense, speed, type, name);
    }

    /**
     * Constructor with default stats and a specific type
     * 
     * @param type The monster's type
     */
    public Monster(String type){
        this(100,100,100,100, type,"Name");
    }

    public Monster(Monster other){
        super(other);
    }

    /**
     * Default constructor
     */
    public Monster(){
        this("Monster");
    }

    // ### METHODS ###

    public String getFullName() {
        return getName();
    }
}