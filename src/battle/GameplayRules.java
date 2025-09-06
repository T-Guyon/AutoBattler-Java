package battle;

import game.*;
import teams.Team;
import entities.*;

public class GameplayRules {

    public static void teamSize(){
        System.out.println("\n{A fighter has joined your team");
        System.out.println("A team can contain a maximum of 5 fighters");
        System.out.println("You will encounter various fighters throughout your adventure that you can add to or remove from your team}\n");
    }

    public static void classes(){
        System.out.println("\n{There are 6 possible hero classes to play, each with its own specialties");
        TeamFactory.characterInfo(new Archer());
        TeamFactory.characterInfo(new Berserker());
        TeamFactory.characterInfo(new Mage());
        TeamFactory.characterInfo(new Paladin());
        TeamFactory.characterInfo(new Thief());
        TeamFactory.characterInfo(new Warrior());
        System.out.println("Choose your class carefully because it will be impossible to change it later}\n");
    }

    public static void fight(Team player, Team enemy, String speaker, String text){
        System.out.println("\n{In this game, the battles are automatic");
        System.out.println("The character from either team with the highest speed starts");
        System.out.println("If conditions are met, the fighters use their special abilities");
        System.out.println("The first team that has no fighters left able to fight loses}\n");
        Fight.FightLoop(player, enemy, speaker, text);
    }
}