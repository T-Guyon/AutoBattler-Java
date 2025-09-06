package game;

import java.util.Scanner;
import entities.*;

public class ManualMode {

    //
    public static void start(){        
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("### MANUAL MODE ###");
        System.out.println("Whiche character do you want information about ?");
        System.out.println("1. Archer");
        System.out.println("2. Berserker");
        System.out.println("3. Mage");
        System.out.println("4. Paladin");
        System.out.println("5. Thief");
        System.out.println("6. Warrior");
        System.out.println("7. Goblin");
        System.out.println("8. Slime");
        System.out.println("9. Baby Slime");
        System.out.println("10. Boss Goblin");
        System.out.println("11. Spider");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                TeamFactory.characterInfo(new Archer());
                break;

            case 2:
                TeamFactory.characterInfo(new Berserker());
                break;

            case 3:
                TeamFactory.characterInfo(new Mage());
                break;

            case 4:
                TeamFactory.characterInfo(new Paladin());
                break;
        
            case 5:
                TeamFactory.characterInfo(new Thief());
                break;

            case 6:
                TeamFactory.characterInfo(new Warrior());
                break;

            case 7:
                TeamFactory.characterInfo(new Goblin());
                break;

            case 8:
                TeamFactory.characterInfo(new Slime());
                break;

            case 9:
                TeamFactory.characterInfo(new BabySlime());
                break;

            case 10:
                TeamFactory.characterInfo(new BossGoblin());
                break;

            case 11:
                TeamFactory.characterInfo(new Spider());
                break;

            default:
                break;
        }
        sc.close();
    }
}