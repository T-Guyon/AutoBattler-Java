package AutoBattler.game;

import AutoBattler.teams.*;
import AutoBattler.battle.*;

public class PvpMode {

    //
    public static void start(){
        System.out.println("\n### PVP MODE ###\n");
        //Team selection
        System.out.println("Player 1 choose their team");
        Team t1 = TeamFactory.choice("Team 1");
        System.out.println("\nPlayer 2 choose their team");
        Team t2 = TeamFactory.choice(" Team 2");

        //Starting the battle between the two teams
        Fight.fight(t1, t2);

    }


}