package AutoBattler.game;

import java.util.Scanner;
import AutoBattler.teams.*;
import AutoBattler.story.*;

public class StoryMode {

    //ATTRIBUTES
    private static final Scanner sc = new Scanner(System.in);

    //
    public static void start(){
        System.out.println("### STORY MODE ###");
        String playerName = askPlayerName();
        Team player = new Team("Hero");
        SceneManager.startStory(player, playerName);
    }

    //! a modifier
    private static String askPlayerName(){
        String name = "";
        while (name.equals("")) {
            System.out.println("\n[Enter your name]: ");
            name = sc.nextLine();

            if (name.equals("")) {
                System.out.println("Please enter a valid name");
            }
        }
        return name;
    }


}