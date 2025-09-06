package teams;

import java.util.*;
import entities.*;
import battle.*;

public class Team {

    // ### ATTRIBUTES ###

    private List<Fighter> team;
    private String teamName;

    // ### CONSTRUCTORS ###

    public Team(List<Fighter> team, String teamName){
        this.team = team;
        this.teamName = teamName;
    }

    /**
     * Constructor with a team name
     * 
     * @param teamName The name of the team
     */
    public Team(String teamName) {
        this.team = new ArrayList<Fighter>();
        this.teamName = teamName;
    }

    /**
     * Constructor with a team name and an initial list of fighters
     * 
     * @param teamName The name of the team
     * @param f        The initial fighters to add to the team
     */
    public Team(String teamName, Fighter... f) {
        this(teamName);
        for (int i = 0; i < f.length; i++) {
            this.team.add(f[i]);
            f[i].joinTeam(this);
        }
    }

    /**
     * Default constructor
     */
    public Team() {
        this("Default Team");
    }

    // ### METHODS ###

    /**
     * Adds a fighter to the team and assigns them to this team
     * 
     * @param f The fighter to add
     */
    public void add(Fighter f) {
        team.add(f);
        f.joinTeam(this);
    }

    /**
     * Removes a fighter from the team
     * 
     * @param f The fighter to remove
     */
    public void remove(Fighter f) {
        team.remove(f);
    }

    /**
     * Removes all fighters from the team that have 0 or less HP
     */
    public void removeDead() {
        Iterator<Fighter> iter = team.iterator();
        while (iter.hasNext()) {
            Fighter f = iter.next();
            if (f.getHp() <= 0) {
                System.out.print(f.getName() + " from " + f.getTeam().getTeamName() + " is dead");
                iter.remove();
            }
        }
    }

    /**
     * Checks whether the team is empty
     * 
     * @return True if the team is empty, false otherwise
     */
    public boolean isEmpty() {
        return team.isEmpty();
    }

    /**
     * Checks whether a fighter is in the team
     * 
     * @param f The fighter to look for
     * @return True if the fighter is in the team, false otherwise
     */
    public boolean contains(Fighter f) {
        return team.contains(f);
    }

    /**
     * Heals every fighter in the team to their base HP
     */
    public void fullHealTeam() {
        for (Fighter f : team) {
            f.fullHeal();
        }
    }

    /**
     * Heals every fighter in the team to their base HP
     */
    public void resetAllTeamStats() {
        for (Fighter f : team) {
            f.resetStats();
        }
    }

    /**
     * Resets only the stats (attack, defense, speed) of every fighter to base
     * values
     */
    public void resetTeamStats() {
        for (Fighter f : team) {
            f.revertStatChanges();
        }
    }

    /**
     * Selects a random fighter from the team
     * 
     * @return A randomly chosen fighter
     */
    public Fighter randomFighter() {
        return team.get((int) (Math.random() * team.size()));
    }

    /**
     * Selects the fighter in the team with the lowest current HP
     * 
     * @return The fighter with the lowest HP
     */
    public Fighter lowestHpFighter() {
        return Collections.min(team, new ComparatorHp());
    }

    /**
     * Gets the number of fighters currently in the team
     * 
     * @return The size of the team
     */
    public int size() {
        return team.size();
    }

    public Team clone(){
        List<Fighter> cloneTeam = new ArrayList<>();
        Team clonedTeam = new Team(this.teamName);
        for(Fighter f : team){
            Fighter clonedFighter = f.clone();
            clonedFighter.joinTeam(clonedTeam);
            cloneTeam.add(clonedFighter);
        }
        clonedTeam.team = cloneTeam;
        return clonedTeam;
    }

    /**
     * Returns a copy of the team list
     * 
     * @return A new list containing the fighters
     */
    public List<Fighter> getTeam() {
        return new ArrayList<>(team);
    }

    public String getTeamName() {
        return this.teamName;
    }

    /**
     * Gets the fighter at the given index
     * 
     * @param index The index in the list
     * @return The fighter at that index
     */
    public Fighter get(int index) {
        return team.get(index);
    }

    /**
     * Returns a string representation of the team
     * 
     * @return A string showing the team's name and its fighters
     */
    @Override
    public String toString() {
        return teamName + " : " + team;
    }
}
