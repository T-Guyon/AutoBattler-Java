package AutoBattler.entities;

import AutoBattler.teams.*;

/**
 * Represents a Paladin hero character.
 * The Paladin is a resilient warrior blessed with divine protection.
 * With each strike, he also heals himself, making him exceptionally durable in
 * battle.
 */
public class Paladin extends Hero {

    // ### CONSTRUCTORS ###

    /**
     * Constructs a Paladin with custom stats and type.
     *
     * @param hp      The paladin's health points
     * @param attack  The paladin's attack value
     * @param defense The paladin's defense value
     * @param speed   The paladin's speed value
     * @param type    The type/class of the paladin
     * @param name    The personal name of the paladin
     */
    public Paladin(int hp, int attack, int defense, int speed, String type, String name) {
        super(hp, attack, defense, speed, type, name);
    }

    /**
     * Constructs a Paladin with default stats and a custom name.
     *
     * @param name The personal name of the paladin
     */
    public Paladin(String name) {
        this(200, 45, 25, 10, "Paladin", name);
    }

    public Paladin(Paladin other){
        super(other);
    }

    /**
     * Constructs a Paladin with default stats and the name "Default Name".
     */
    public Paladin() {
        this("Paladin");
    }

    // ### METHODS ###

    /**
     * Attacks a random enemy fighter and activates the Paladin's special ability:
     * heals for 10 HP, up to a maximum of 200 HP.
     *
     * @param enemy The enemy team to attack
     */
    @Override
    public void attack(Team enemy) {
        super.regenerateHp(10);
        super.attack(enemy);
    }

    public Fighter clone(){
        return new Paladin(this);
    }

    /**
     * Returns the description of the Paladin's special ability.
     *
     * @return A string describing the special ability
     */
    @Override
    public String specialAbility() {
        return "Heals 10 HP each time he attacks (up to a maximum of 200 HP)";
    }

    /**
     * Returns the lore description of the Paladin.
     *
     * @return A string containing the Paladin's lore
     */
    @Override
    public String lore() {
        return "Clad in shining armor and guided by unwavering faith, the Paladin stands as a beacon of hope on the battlefield. "
                + "Blessed with divine power, he heals his wounds with each righteous blow. "
                + "Unyielding in defense and noble in purpose, he fights not for glory, but to protect those who cannot protect themselves.";
    }
}
