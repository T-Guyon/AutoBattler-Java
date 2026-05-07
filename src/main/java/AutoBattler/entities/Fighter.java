package AutoBattler.entities;

import AutoBattler.teams.*;


public abstract class Fighter {

    // ### ATTRIBUTES ###

    // Base attributes
    private int baseHp;
    private int baseAttack;
    private int baseDefense;
    private int baseSpeed;

    // Current attributes
    private int hp;
    private int attack;
    private int defense;
    private int speed;

    private int id;
    private static int idCounter;
    private String type;
    private String name;
    private Team team;

    // ### CONSTRUCTORS ###

    /**
     * Constructor with parameters
     *
     * @param hp      The fighter's maximum and initial health points
     * @param attack  The fighter's base attack value
     * @param defense The fighter's base defense value
     * @param speed   The fighter's base speed value
     * @param type    The fighter's type
     * @param name    The fighter's name
     */
    public Fighter(int hp, int attack, int defense, int speed, String type, String name) {
        this.baseHp = hp;
        this.baseAttack = attack;
        this.baseDefense = defense;
        this.baseSpeed = speed;
        this.type = type;
        this.name = name;
        this.id = ++idCounter;

        this.hp = this.baseHp;
        this.attack = baseAttack;
        this.defense = baseDefense;
        this.speed = baseSpeed;
    }

    public Fighter(Fighter other){
        this.updateBaseHp(other.getBaseHp());
        this.updateBaseAttack(other.getBaseAttack());
        this.updateBaseDefense(other.getBaseDefense());
        this.updateBaseSpeed(other.getBaseSpeed());
        this.updateType(other.getType());
        this.updateName(other.getName());
        this.id = idCounter++;

        this.updateHp(other.getHp());
        this.updateAttack(other.getAttack());
        this.updateDefense(other.getDefense());
        this.updateSpeed(other.getSpeed());
    }

    // ### METHODS ###

    /**
     * Assigns this fighter to a team
     *
     * @param team The team the fighter joins
     */
    public void joinTeam(Team team) {
        this.team = team;
    }

    /**
     * Performs a physical attack on a random enemy from the opposing team
     *
     * @param enemy The enemy team
     */
    public void attack(Team enemy) {
        enemy.randomFighter().takeDamage(this.attack, this);
    }

    /**
     * Handles incoming physical damage, reduced by defense
     *
     * @param damage The raw attack value from the attacker
     * @param f      The attacker
     */
    public void takeDamage(int damage, Fighter f) {
        int attackPower = (int) (damage * (100.0 / (100 + this.defense)));
        if (attackPower > 0) {
            this.hp -= attackPower;
        }
        if (this.hp < 0) {
            this.hp = 0;
        }
        battleDisplay(f, this);
    }

    /**
     * Handles incoming magical damage
     *
     * @param damage The magical damage to apply
     * @param f      The attacker
     */
    public void takeMagicalDamage(int damage, Fighter f) {
        if (damage > 0) {
            this.hp -= damage;
        }
        if (this.hp < 0) {
            this.hp = 0;
        }
        battleDisplay(f, this);
    }

    /**
     * Restores HP by a fixed amount
     *
     * @param amount The amount to heal
     */
    public void regenerateHp(int amount) {
        if(this.hp > 0) {
            this.updateHp(this.hp + amount);
        }
    }

    /**
     * Displays an attack in the console
     *
     * @param attacker The fighter who attacks
     * @param attacked The fighter who gets hit
     */
    public void battleDisplay(Fighter attacker, Fighter attacked) {
        System.out.print("\nThe " + attacker.getName() + " from " + attacker.getTeam().getTeamName() + " attacks "
                + attacked.getName() + " from " + attacked.getTeam().getTeamName() + " --> " + attacked);
    }

    /**
     * Fully restores current HP to the base HP
     */
    public void fullHeal() {
        this.hp = this.baseHp;
    }

    /**
     * Resets current attack to its base value
     */
    public void resetAttack() {
        this.attack = this.baseAttack;
    }

    /**
     * Resets current defense to its base value
     */
    public void resetDefense() {
        this.defense = this.baseDefense;
    }

    /**
     * Resets current speed to its base value
     */
    public void resetSpeed() {
        this.speed = this.baseSpeed;
    }

    /**
     * Resets all current stats except HP to base values
     */
    public void revertStatChanges() {
        this.resetAttack();
        this.resetDefense();
        this.resetSpeed();
    }

    /**
     * Fully heals and resets all modified stats
     */
    public void resetStats() {
        this.fullHeal();
        this.revertStatChanges();
    }

    // ### ABSTRACT METHODS ###

    public abstract Fighter clone();

    public abstract String getFullName();

    /**
     * Returns a description of the fighter's special ability
     */
    public abstract String specialAbility();

    /**
     * Returns the fighter's lore
     */
    public abstract String lore();

    // ### GETTERS ###

    /**
     * @return The current health points of the fighter
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * @return The current attack value
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * @return The current defense value
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * @return The current speed value
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * @return The base (initial) maximum health points
     */
    public int getBaseHp() {
        return this.baseHp;
    }

    /**
     * @return The base (initial) attack value
     */
    public int getBaseAttack() {
        return this.baseAttack;
    }

    /**
     * @return The base (initial) defense value
     */
    public int getBaseDefense() {
        return this.baseDefense;
    }

    /**
     * @return The base (initial) speed value
     */
    public int getBaseSpeed() {
        return this.baseSpeed;
    }

    /**
     * @return The type/class of the fighter (e.g. "Paladin", "Goblin", etc.)
     */
    public String getType() {
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    /**
     * @return The team this fighter belongs to
     */
    public Team getTeam() {
        return this.team;
    }

    /**
     * @return The unique ID of this fighter
     */
    public int getId() {
        return this.id;
    }

    // ### UPDATERS ###

    /**
     * Updates the base HP and caps current HP if necessary
     *
     * @param newBaseHp The new base maximum HP
     */
    public void updateBaseHp(int newBaseHp) {
        this.baseHp = newBaseHp;
        if (this.hp > newBaseHp)
            this.hp = newBaseHp;
    }

    /**
     * Updates the base attack and caps current attack if necessary
     *
     * @param newBaseAttack The new base attack value
     */
    public void updateBaseAttack(int newBaseAttack) {
        this.baseAttack = newBaseAttack;
        if (this.attack > newBaseAttack)
            this.attack = newBaseAttack;
    }

    /**
     * Updates the base defense and caps current defense if necessary
     *
     * @param newBaseDefense The new base defense value
     */
    public void updateBaseDefense(int newBaseDefense) {
        this.baseDefense = newBaseDefense;
        if (this.defense > newBaseDefense)
            this.defense = newBaseDefense;
    }

    /**
     * Updates the base speed and caps current speed if necessary
     *
     * @param newBaseSpeed The new base speed value
     */
    public void updateBaseSpeed(int newBaseSpeed) {
        this.baseSpeed = newBaseSpeed;
        if (this.speed > newBaseSpeed)
            this.speed = newBaseSpeed;
    }

    /**
     * Sets the current HP
     *
     * @param newHp The new current HP
     */
    public void updateHp(int newHp) {
        if(newHp <= this.baseHp){
            this.hp = newHp;
            return;
        }
        this.hp = this.baseHp;
    }

    /**
     * Sets the current attack
     *
     * @param newAttack The new current attack value
     */
    public void updateAttack(int newAttack) {
        if(newAttack <= this.baseAttack){
            this.attack = newAttack;
            return;
        }
        this.attack = this.baseAttack;
    }

    /**
     * Sets the current defense
     *
     * @param newDefense The new current defense value
     */
    public void updateDefense(int newDefense) {
        if(newDefense <= this.baseDefense){
            this.defense = newDefense;
            return;
        }
        this.defense = this.baseDefense;
    }

    /**
     * Sets the current speed
     *
     * @param newSpeed The new current speed value
     */
    public void updateSpeed(int newSpeed) {
        if(newSpeed <= this.baseSpeed){
            this.speed = newSpeed;
            return;
        }
        this.speed = this.baseSpeed;
    }

    /**
     * Sets the fighter's type
     *
     * @param newType The new type
     */
    public void updateType(String newType) {
        this.type = newType;
    }

    public void updateName(String newName){
        this.name = newName;
    }

    public void updateId(int newId){
        this.id = newId;
    }

    // ### DISPLAY ###

    /**
     * toString method
     *
     * @return The fighter's initial and current health points
     */
    @Override
    public String toString() {
        return this.getName() + "[" + this.getHp() + "/" + this.getBaseHp() + " HP]";
    }
}