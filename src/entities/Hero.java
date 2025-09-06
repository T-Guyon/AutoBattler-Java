package entities;

public abstract class Hero extends Fighter {

    // ### CONSTRUCTORS ###

    /**
     * Constructor with parameters
     * 
     * @param hp      The hero's health points
     * @param attack  The hero's attack stat
     * @param defense The hero's defense stat
     * @param speed   The hero's speed stat
     * @param type    The hero's class or role
     * @param name    The personal name of the hero
     */
    public Hero(int hp, int attack, int defense, int speed, String type, String name) {
        super(hp, attack, defense, speed, type, name);
    }

    /**
     * Constructor with default stats and type, but with a personal name
     * 
     * @param name The personal name of the hero
     */
    public Hero(String name) {
        this(100, 100, 100, 100, "Hero", name);
    }

    public Hero (Hero other){
        super(other);
    }

    /**
     * Default constructor
     */
    public Hero() {
        this("Default Name");
    }

    // ### GETTERS ###

    /**
     * Gets the full name of the hero
     * 
     * @return The full name
     */
    public String getFullName() {
        return getType() + " " + getName();
    }

}