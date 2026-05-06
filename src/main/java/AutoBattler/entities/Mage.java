package AutoBattler.entities;

import AutoBattler.teams.*;

/**
 * Represents a Mage hero character.
 * The Mage uses powerful spells that bypass the enemy's defense.
 * Specializing in magical damage, he compensates for his lack of physical resistance
 * with devastating ranged attacks that ignore armor.
 */
public class Mage extends Hero {

    // ### CONSTRUCTORS ###

    /**
     * Constructs a Mage with custom stats and type.
     *
     * @param hp      The mage's health points
     * @param attack  The mage's attack value
     * @param defense The mage's defense value
     * @param speed   The mage's speed value
     * @param type    The type/class of the mage
     * @param name    The personal name of the mage
     */
    public Mage(int hp, int attack, int defense, int speed, String type, String name) {
        super(hp, attack, defense, speed, type, name);
    }

    /**
     * Constructs a Mage with default stats and a custom name.
     *
     * @param name The personal name of the mage
     */
    public Mage(String name) {
        this(160, 70, 0, 30, "Mage", name);
    }

    public Mage(Mage other){
        super(other);
    }

    /**
     * Constructs a Mage with default stats and the name "Mage".
     */
    public Mage() {
        this("Mage");
    }

    // ### METHODS ###

    /**
     * Attacks a random enemy fighter, dealing magical damage that ignores their defense.
     *
     * @param enemy The enemy team to attack
     */
    @Override
    public void attack(Team enemy) {
        enemy.randomFighter().takeMagicalDamage(this.getAttack(), this);
    }

    public Fighter clone(){
        return new Mage(this);
    }

    /**
     * Returns the description of the Mage's special ability.
     *
     * @return A string describing the special ability
     */
    @Override
    public String specialAbility() {
        return "Deals magic damage that ignores enemy defense";
    }

    /**
     * Returns the lore description of the Mage.
     *
     * @return A string containing the Mage's lore
     */
    @Override
    public String lore() {
        return "Trained in the forgotten halls of arcane knowledge, the Mage bends the elements to his will. "
                + "Fragile in body but mighty in mind, he strikes from afar with spells that ignore steel and shield alike. "
                + "Each incantation he utters carries centuries of wisdom and destruction, making him a force to be feared by even the bravest warriors.";
    }
}