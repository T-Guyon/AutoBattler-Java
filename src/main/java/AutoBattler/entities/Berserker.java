package AutoBattler.entities;

import AutoBattler.teams.*;

/**
 * Represents a Berserker hero character
 * The Berserker attacks a random enemy and attacks twice when his health is 80
 * or less
 */
public class Berserker extends Hero {

    // ### CONSTRUCTORS ###

    /**
     * Constructs a Berserker with custom stats and type
     *
     * @param hp      The berserker's health points
     * @param attack  The berserker's attack value
     * @param defense The berserker's defense value
     * @param speed   The berserker's speed value
     * @param type    The type/class of the berserker
     * @param name    The personal name of the berserker
     */
    public Berserker(int hp, int attack, int defense, int speed, String type, String name) {
        super(hp, attack, defense, speed, type, name);
    }

    /**
     * Constructs a Berserker with default stats and a custom name
     *
     * @param name The personal name of the berserker
     */
    public Berserker(String name) {
        this(220, 55, 10, 50, "Berserker", name);
    }

    public Berserker(Berserker other){
        super(other);
    }

    /**
     * Constructs a Berserker with default stats and the name "Default Name"
     */
    public Berserker() {
        this("Berserker");
    }

    // ### METHODS ###

    /**
     * Attacks a random enemy and uses the special ability if health is 80 or less
     *
     * @param enemy The enemy team to attack
     */
    @Override
    public void attack(Team enemy) {
        Fighter target = enemy.randomFighter();
        if (this.getHp() <= 80) {
            target.takeDamage(this.getAttack(), this);
            System.out.print(" the berserker uses their special ability");
        }
        target.takeDamage(this.getAttack(), this);
    }

    @Override
    public Fighter clone() {
        return new Berserker(this);
    }

    /**
     * Returns the description of the Berserker's special ability
     *
     * @return A string describing the special ability
     */
    @Override
    public String specialAbility() {
        return "When the berserker has 80 HP or less, he attacks twice";
    }

    /**
     * Returns the lore description of the Berserker
     *
     * @return A string containing the Berserker's lore
     */
    @Override
    public String lore() {
        return "Born in the frozen lands of the North, the Berserker draws his strength from an ancient rage. When his strength wanes, his unleashed fury makes him nearly unstoppable, capable of striking twice with unmatched ferocity. A solitary and relentless warrior, he stops at nothing to protect what he holds dear, even at the cost of his own life";
    }

}
