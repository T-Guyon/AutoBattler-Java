package battle;

import java.util.*;
import teams.*;
import entities.*;
import story.*;

public class Fight {
    
    //METHODS

    /**
    * Method to start a fight between two teams
    * @param e1 The first team
    * @param e2 The second team
    */
    public static void fight(Team t1, Team t2){

        //Display of the teams' status before the fight
        System.out.println("\nStart of the fight :\n");
        System.out.println("team 1 :" + t1);
        System.out.println("team 2 : " + t2 + "\n");

        //Launching the fight

        /**
        * While both teams are not empty
        * We put the two teams into the same ArrayList
        * To sort them by decreasing speed
        */
        while (!t1.isEmpty() && !t2.isEmpty()) {
            
            //Combining the fighters from both teams
            List<Fighter> allFighters = new ArrayList<>();
            allFighters.addAll(t1. getTeam());
            allFighters.addAll(t2. getTeam());

            //Sorting the fighters by descending speed
            Collections.sort(allFighters, new ComparatorSpeed());

            //Attacks a fighter from the opposing team and removes dead characters
            for(Fighter f : allFighters){
                if(f.getHp() > 0){
                    if (t1.contains(f) && !t2.isEmpty()) {
                        f.attack(t2);
                        t2.removeDead();
                    }
                    else{
                        if (t2.contains(f) && !t1.isEmpty()) {
                            f.attack(t1);
                            t1.removeDead();
                        }
                    }
                }
            }

            // Displaying the status of the teams
            System.out.println("\n\nStatus of the teams:\n");
            System.out.println(t1);
            System.out.println(t2 + "\n");
        }

        // Final result of the fight
        if (t1.isEmpty() && t2.isEmpty()) {
            System.out.println("Draw!");
        }
        else{
            if (t1.isEmpty()) {
                System.out.println("\nTeam 2 has won!\n");
            } 
            else {
                System.out.println("\nTeam 1 has won!\n");
            }
        }
    }

    public static Team FightLoop(Team player, Team enemy, String speaker, String text){
        Team result = null;
        do{
            Team copy = player.clone();
            Team enemycopy = enemy.clone();
            Dialogue.displayDialogue(speaker, text);
            fight(enemycopy, copy);

            if (copy.isEmpty()) {
                System.out.println("YOU LOOSE");
            }
            else{
                System.out.println("YOU WIN");
                result = copy;
            }

        }while(result == null);
        return result;
    }
}

