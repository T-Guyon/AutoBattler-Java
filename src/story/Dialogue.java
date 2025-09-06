package story;

import java.util.Scanner;
import teams.*;
import entities.*;

public class Dialogue {

    //ATTRIBUTES
private static final Scanner sc = new Scanner(System.in);

    public static void displayDialogue(String speaker, String text){
        System.out.println(speaker + " : " + text);
        pause();
    }

    public static void pause(){
        System.out.println("\n[Press Enter to continue]");
        sc.nextLine();
    }

    public static void addFighterToTeam(Team player, Fighter f){
        player.add(f);
        System.out.println(f.getFullName() + " joins the team\n");
        Dialogue.pause();
    }
}