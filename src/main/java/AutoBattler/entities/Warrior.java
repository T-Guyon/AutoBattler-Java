package AutoBattler.entities;

/**
 * Represents a Warrior hero character.
 * The Warrior is a stalwart combatant, fearless and relentless in battle.
 * With unmatched strength and resilience, the Warrior retaliates fiercely,
 * possessing a 60% chance to counterattack after taking damage.
 */
public class Warrior extends Hero {

    // ### CONSTRUCTORS ###

    /**
     * Constructs a Warrior with custom stats and type.
     *
     * @param hp      The warrior's health points
     * @param attack  The warrior's attack value
     * @param defense The warrior's defense value
     * @param speed   The warrior's speed value
     * @param type    The type/class of the warrior
     * @param name    The personal name of the warrior
     */
    public Warrior(int hp, int attack, int defense, int speed, String type, String name) {
        super(hp, attack, defense, speed, type, name);
    }

    /**
     * Constructs a Warrior with default stats and a custom name.
     *
     * @param name The personal name of the warrior
     */
    public Warrior(String name) {
        this(220, 30, 25, 20, "Warrior", name);
    }

    public Warrior(Warrior other){
        super(other);
    }

    /**
     * Constructs a Warrior with default stats and the name "Default Name".
     */
    public Warrior() {
        this("Warrior");
    }

    // ### METHODS ###

    /**
     * Method allowing the warrior to take damage and have a 60 percent chance to
     * counterattack.
     * If the warrior is still alive after taking damage, he has a chance to deal
     * damage back to the attacker.
     *
     * @param damage The damage taken
     * @param f      The fighter attacking the warrior
     */
    @Override
    public void takeDamage(int damage, Fighter f) {
        super.takeDamage(damage, f);
        if (this.getHp() > 0 && Math.random() < 0.6 && damage > 0) {
            System.out.print(" The " + this.getName() + " from " + this.getTeam().getTeamName() + " counterattack ");
            f.takeDamage(this.getAttack(), this);
        }
    }

    /**
     * Method allowing the warrior to take magical damage and have a 60 percent
     * chance to counterattack.
     * If the warrior is still alive after taking magical damage, he has a chance to
     * deal magical damage back to the attacker.
     *
     * @param damage The magical damage taken
     * @param f      The fighter attacking the warrior
     */
    public void takeMagicalDamage(int damage, Fighter f) {
        super.takeMagicalDamage(damage, f);
        if (this.getHp() > 0 && Math.random() < 0.6) {
            f.takeMagicalDamage(this.getAttack(), this);
            System.out.print(" \nThe " + this.getName() + " from " + this.getTeam().getTeamName() + " counterattack "
                    + f.getName() + " from " + f.getTeam().getTeamName() + " --> " + f);
        }
    }

    public Fighter clone(){
        return new Warrior(this);
    }

    /**
     * Returns the description of the Warrior's special ability.
     *
     * @return A string describing the special ability
     */
    @Override
    public String specialAbility() {
        return "60% chance to counterattack after taking damage, dealing damage back to the attacker.";
    }

    /**
     * Returns the lore description of the Warrior.
     *
     * @return A string containing the Warrior's lore
     */
    @Override
    public String lore() {
        return "The Warrior is a stalwart combatant, fearless and relentless in battle. " +
                "With unmatched strength and resilience, the Warrior retaliates fiercely against any foe who dares strike him, "
                +
                "turning defense into offense with swift counterattacks.";
    }
}
