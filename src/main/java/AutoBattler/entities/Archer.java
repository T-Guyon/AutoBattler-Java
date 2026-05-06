package AutoBattler.entities;

import AutoBattler.teams.*;

/**
 * Represents an Archer hero character
 * The Archer attacks the enemy with the lowest health points
 */
public class Archer extends Hero {

    // ### CONSTRUCTORS ###

    /**
     * Constructs an Archer with custom stats and type
     *
     * @param hp      The archer's health points
     * @param attack  The archer's attack value
     * @param defense The archer's defense value
     * @param speed   The archer's speed value
     * @param type    The type/class of the archer
     * @param name    The personal name of the archer
     */
    public Archer(int hp, int attack, int defense, int speed, String type, String name) {
        super(hp, attack, defense, speed, type, name);
    }

    /**
     * Constructs an Archer with default stats and a custom name
     *
     * @param name The personal name of the archer
     */
    public Archer(String name) {
        this(170, 55, 5, 60, "Archer", name);
    }

    public Archer(Archer other){
        super(other);
    }

    /**
     * Constructs an Archer with default stats and the name "Default Name"
     */
    public Archer() {
        this("Archer");
    }

    // ### METHODS ###

    /**
     * Attacks the enemy fighter with the lowest health points
     *
     * @param enemy The enemy team to attack
     */
    @Override
    public void attack(Team enemy) {
        enemy.lowestHpFighter().takeDamage(this.getAttack(), this);
    }

    @Override
    public Fighter clone() {
        return new Archer(this);
    }

    /**
     * Returns the description of the Archer's special ability
     *
     * @return A string describing the special ability
     */
    @Override
    public String specialAbility() {
        return "The archer attacks the enemy with the lowest health points";
    }

    /**
     * Returns the lore description of the Archer
     *
     * @return A string containing the Archer's lore
     */
    @Override
    public String lore() {
        return "Descended from a lost lineage of elves, the Archer moves silently through the forests, a master of precision and patience. His arrows find their marks before enemies even sense his presence. Though swift and deadly, he fights with honor and a deep connection to the natural world around him";
    }
}
