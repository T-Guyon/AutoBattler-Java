package AutoBattler.ui;

import java.util.Scanner;
import AutoBattler.game.*;

/**
 * Utility class Menu used to perform certain actions depending
 * On the selected mode before starting a battle
 */
public class Menu {

    //METHODS

    //
    public static void display(){
        //Display of menu
        Scanner sc = new Scanner(System.in);
        System.out.println("### MAIN MENU ###");
        System.out.println("1. Story Mode");
        System.out.println("2. PVP Mode");
        System.out.println("3. Test Mode");
        System.out.println("4. Manual");
        System.out.println("5. Exit");

        //
        int input = sc.nextInt();
        switch (input) {
            case 1:
                StoryMode.start();
                break;

            case 2:
                PvpMode.start();
                break;

            case 3:
                TestMode.start();
                break;

            case 4:
                ManualMode.start();
                break;

            case 5:
                System.out.println("Goodbye !");
                TeamFactory.closeScanner();
                sc.close();
                return;

            default:
                System.out.println("Invalid option");
        }
        TeamFactory.closeScanner();
        sc.close();
    }
}
