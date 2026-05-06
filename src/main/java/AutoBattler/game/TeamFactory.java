package AutoBattler.game;

import java.util.Scanner;
import AutoBattler.entities.*;
import AutoBattler.teams.*;

public class TeamFactory {

    //ATTRIBUTES
    private static final Scanner sc = new Scanner(System.in);

    public static Fighter chooseFighter(Team player,String name){
        int input;
        System.out.println("Choose your class");
        System.out.println("1. Archer");
        System.out.println("2. Berserker");
        System.out.println("3. Mage");
        System.out.println("4. Paladin");
        System.out.println("5. Thief");
        System.out.println("6. Warrior");
        input = sc.nextInt();

        switch (input) {
            case 1:
                return new Archer(name);
            case 2:
                return new Berserker(name);
            case 3:
                return new Mage(name);
            case 4:
                return new Paladin(name);
            case 5:
                return new Thief(name);
            case 6:
                return new Warrior(name);
            default:
                return new Archer(name);
        }

    }

    //
    public static Team chooseTeam(String teamName){
        Hero [] hero = new Hero[] {new Archer(), new Berserker(), new Mage(), new Paladin(), new Thief(), new Warrior()};
        Monster [] monster = new Monster[] {new Goblin(), new Slime(), new BabySlime(), new BossGoblin(), new Spider()};
        Team team = new Team(teamName);
        int choice;

        do{
            System.out.println("Do you want");
            System.out.println("1. Heroes");
            System.out.println("2. Monsters");
            choice = sc.nextInt();
        }while(choice != 1 && choice != 2);


        switch (choice) {
            case 1:
                for(int i = 0; i < hero.length; i++){
                    System.out.println("How many " + hero[i].getName() + " do you want ?");
                    choice = sc.nextInt();
                    for(int j = 0; j < choice ;j++){
                        team.add(hero[i]);
                    }
                }
                break;

            case 2:
                for(int i = 0; i < monster.length; i++){
                    System.out.println("How many " + monster[i].getName() + " do you want ?");
                    choice = sc.nextInt();
                    for(int j = 0; j < choice ;j++){
                        team.add(monster[i]);
                    }
                }
                break;
        }
        return team;
    }

    /**
     * Method that allows choosing a character among three randomly
     * drawn to add to the team
     * @return A team of five fighter
     */
    public static Team choice(String teamName){

        //Data declaration
        Team t = new Team(teamName);
        int choice;
        Fighter suggestion [] = new Fighter[3];
        Fighter newFighter;

        //Choice of a character among 3 randomly drawn
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < suggestion.length; j++ ){
                do{
                    newFighter = randomFighter(6);
                }while((suggestion[0] != null && suggestion[0].getName().equals(newFighter.getName())) || (suggestion[1] != null && suggestion[1].getName().equals(newFighter.getName())) || (suggestion[2] != null && suggestion[2].getName().equals(newFighter.getName())));
                suggestion[j] = newFighter;
            }
            System.out.println("\nWich fighter do you choose :\n");
            System.out.println("1 : " + suggestion[0]);
            System.out.println("2 : " + suggestion[1]);
            System.out.println("3 : " + suggestion[2]);
            choice = sc.nextInt();

            //Value check
            while (choice < 1 || choice > 3) {
                System.out.print("Error, you must choose 1,2 or 3");
                choice = sc.nextInt();
            }

            //Adding the chosen character to the team
            switch (choice) {
                case 1:
                    t.add(suggestion[0]);
                    break;
                case 2:
                    t.add(suggestion[1]);
                    break;
                case 3:
                    t.add(suggestion[2]);
                    break;
            }
        }
        return t;
    }

    /**
     * Method to randomly draw a fighter
     * @param max The upper bound of the randomly drawn number
     * @return A random fighter
     */
    private static Fighter randomFighter(int max){

        //Declaration of a random number
        int random = ((int) (Math.random()*((max)+1)));

        //Choix du personnage a retourner
        switch (random) {
            case 0:
                return new Paladin();
            case 1:
                return new Berserker();
            case 2:
                return new Mage();
            case 3:
                return new Archer();
            case 4:
                return new Thief();
            default:
                return new Warrior();
        }
    }

    public static void characterInfo(Fighter f){
        System.out.println("\nName : " + f.getName());
        System.out.println("Hp : " + f.getBaseHp());
        System.out.println("Attack : " + f.getAttack());
        System.out.println("Defense : " + f.getDefense());
        System.out.println("Speed : " + f.getSpeed());
        System.out.println("Backstory : " + f.lore());
    }

    //Method to close the scanner
    public static void closeScanner(){
        sc.close();
    }
}