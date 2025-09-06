package entities;

import java.util.List;
import teams.*;

/**
 * Represents a Goblin monster.
 * Goblins are small but cunning creatures that become stronger when fighting
 * alongside their kin.
 * Their pack mentality grants increased attack power for each Goblin ally
 * present in their team.
 */
public class Goblin extends Monster {

    // ### CONSTRUCTORS ###

    /**
     * Constructs a Goblin with specified stats and type.
     *
     * @param hp      The Goblin's health points.
     * @param attack  The Goblin's attack value.
     * @param defense The Goblin's defense value.
     * @param speed   The Goblin's speed value.
     * @param type    The type/class of the Goblin.
     */
    public Goblin(int hp, int attack, int defense, int speed, String type, String name) {
        super(hp, attack, defense, speed, type, name);
    }

    public Goblin(Goblin other){
        super(other);
    }

    public Goblin(String name){
        super(100, 35, 15, 20, "Goblin",name);
    }

    /**
     * Constructs a Goblin with default stats and the type "Goblin".
     */
    public Goblin() {
        super("Name");
    }

    // ### METHODS ###

    /**
     * Attacks a random fighter on the enemy team.
     * The damage dealt increases by 10% for each other Goblin in the same team
     * (pack mentality).
     *
     * @param enemy The enemy team to attack.
     */
    @Override
    public void attack(Team enemy) {
        int nbGoblins = 0;

        List<Fighter> teamMembers = this.getTeam().getTeam();
        for (Fighter member : teamMembers) {
            if (member.getType().equals(this.getType()) && member != this) {
                nbGoblins++;
            }
        }
        enemy.randomFighter().takeDamage((int) (this.getAttack() * (1 + nbGoblins * 0.1)), this);
        System.out.print(" (Pack Mentality +" + (nbGoblins * 10) + "%)");
    }

    /**
     * Returns the description of the Goblin's special ability.
     *
     * @return A string describing the special ability.
     */
    @Override
    public String specialAbility() {
        return "Increases attack damage by 10% for each Goblin ally in the team.";
    }

    @Override
    public Fighter clone(){
        return new Goblin(this);
    }

    /**
     * Returns the Goblin's name.
     *
     * @return The string "Goblin".
     */
    @Override
    public String getName() {
        return "Goblin";
    }

    /**
     * Returns the lore describing the Goblin.
     *
     * @return A string containing the Goblin's background and traits.
     */
    @Override
    public String lore() {
        return "Small but cunning creatures, Goblins thrive in groups. Their strength grows as their numbers increase, "
                +
                "making them dangerous when fighting together.";
    }
}
