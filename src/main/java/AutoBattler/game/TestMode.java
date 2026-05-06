package AutoBattler.game;

import AutoBattler.teams.*;
import AutoBattler.battle.*;

public class TestMode {

    public static void start(){
        System.out.println("### TEST MODE ###");
        //Choose the teams
        System.out.println("The first player forms their team");
        Team t1 = TeamFactory.chooseTeam("Team 1");
        System.out.println("\nHere is player one's team :\n" + t1 + "\n");
        System.out.println("The second player forms their team");
        Team t2 = TeamFactory.chooseTeam("Team 2");
        System.out.println("\nHere is player two's team :\n" + t2 + "\n");

        //Start of the battle between the two teams
        Fight.fight(t1, t2);
    }
}