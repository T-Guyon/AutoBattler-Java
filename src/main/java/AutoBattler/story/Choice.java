package AutoBattler.story;

import java.util.Scanner;

import AutoBattler.battle.*;
import AutoBattler.entities.*;
import AutoBattler.teams.*;

public class Choice {

    private static final Scanner sc = new Scanner(System.in);


    public static void choice1(Team player){
        Dialogue.displayDialogue("Narrator", "You look and indeed spot, to the right, two Goblins and a Slime, and to the left, two Slimes");

        System.out.println("[What do you want to do ?]");
        System.out.println("1. Fight the horde on the right");
        System.out.println("2. Fight the horde on the left");

        int choice = sc.nextInt();

        if (choice == 1){
            Fight.FightLoop(player, new Team("Right Horde", new Bat(), new BabySlime()), "Narrator", "You approach the horde on the right");
        }
        else{
            Fight.FightLoop(player, new Team("Left Horde", new Rat(), new Bat(), new Bat()), "Narrator", "You approach the horde on the left");
        }
    }

    public static void choice2(Team player){
        System.out.println("[What do you want to do ?]");
        System.out.println("1. Rest in the village");
        System.out.println("2. Set out to explore the cave");

        int choice = sc.nextInt();

        //Todo a finir
        if (choice == 1) {
            Dialogue.displayDialogue("Narrator", "You head toward the village");

            player.fullHealTeam();

            Dialogue.displayDialogue("Narrator", "You arrive at the village and spend the night at the inn");
            Dialogue.displayDialogue("Narrator", "");
        }
        else{
            Dialogue.displayDialogue("Narrator", "You head toward the cave");
        }
    }
}
