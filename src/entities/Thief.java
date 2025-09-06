package entities;

/**
 * Represents a Thief hero character.
 * The Thief is agile and elusive, with a 50% chance to dodge incoming attacks.
 * Masters of evasion, they slip past defenses and avoid harm with uncanny
 * agility.
 */
public class Thief extends Hero {

    // ### CONSTRUCTORS ###

    /**
     * Constructs a Thief with custom stats and type.
     *
     * @param hp      The thief's health points
     * @param attack  The thief's attack value
     * @param defense The thief's defense value
     * @param speed   The thief's speed value
     * @param type    The type/class of the thief
     * @param name    The personal name of the thief
     */
    public Thief(int hp, int attack, int defense, int speed, String type, String name) {
        super(hp, attack, defense, speed, type, name);
    }

    /**
     * Constructs a Thief with default stats and a custom name.
     *
     * @param name The personal name of the thief
     */
    public Thief(String name) {
        this(145, 40, 20, 40, "Thief", name);
    }

    public Thief(Thief other){
        super(other);
    }

    /**
     * Constructs a Thief with default stats and the name "Default Name".
     */
    public Thief() {
        this("Thief");
    }

    // ### METHODS ###

    /**
     * Method allowing the thief to take damage with a 50 percent chance to dodge
     * the attack completely.
     * If the dodge is successful, no damage is taken and a message is printed.
     *
     * @param damage The amount of damage to be taken
     * @param f      The fighter attacking this thief
     */
    @Override
    public void takeDamage(int damage, Fighter f) {
        if (Math.random() < 0.5) {
            super.takeDamage(damage, f);
        } else {
            System.out.print(" \nThe " + f.getName() + " from " + f.getTeam().getTeamName() + " attacks "
                    + this.getName() + " from " + this.getTeam().getTeamName() + " --> The thief dodged the attack");
        }
    }

    public Fighter clone(){
        return new Thief(this);
    }

    /**
     * Returns the description of the Thief's special ability.
     *
     * @return A string describing the special ability
     */
    @Override
    public String specialAbility() {
        return "50% chance to dodge incoming attacks";
    }

    /**
     * Returns the lore description of the Thief.
     *
     * @return A string containing the Thief's lore
     */
    @Override
    public String lore() {
        return "Silent and swift, the Thief strikes from the shadows. Masters of evasion, they slip past defenses " +
                "and avoid harm with uncanny agility.";
    }
}
