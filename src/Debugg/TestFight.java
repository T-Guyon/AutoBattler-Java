package Debugg;

import entities.*;
import teams.*;

public class TestFight {
    public static void testFighterFight(Fighter[] team1, Fighter[] team2){

        Team t1 = new Team("Heroes", team1);
        Team t2 = new Team("Monsters", team2);

        for(int i = 0; i < 10; i++){
            for (Fighter f : team1) {
                f.attack(t2);
            }
            for (Fighter f : team2) {
                f.attack(t1);
            }

            System.out.println("\n" + t1 + "\n" + t2);
        }
    }
    
    public static void testArcherFight(){
        System.out.println("\n### TEST: archer fight ###");

        Archer[] team1 = {new Archer("A1"),new Archer("A2")};
        Archer[] team2 = {new Archer("A3"),new Archer("A4")};

        testFighterFight(team1, team2);
    }

    public static void testBerserkerFight(){
        System.out.println("\n### TEST: berserker fight ###");
        Berserker[] team1 = {new Berserker("B1"),new Berserker("B2")};
        Berserker[] team2 = {new Berserker("B3"),new Berserker("B4")};

        testFighterFight(team1, team2);
    }

    public static void testMageFight(){
        System.out.println("\n### TEST: mage fight ###");

        Mage[] team1 = {new Mage("M1"),new Mage("M2")};
        Mage[] team2 = {new Mage("M3"),new Mage("M4")};

        testFighterFight(team1, team2);
    }

    public static void testPaladinFight(){
        System.out.println("\n### TEST: paladin fight ###");

        Paladin[] team1 = {new Paladin("P1"),new Paladin("P2")};
        Paladin[] team2 = {new Paladin("P3"),new Paladin("P4")};

        testFighterFight(team1, team2);
    }

    public static void testThiefFight(){
        System.out.println("\n### TEST: thief fight ###");

        Thief[] team1 = {new Thief("T1"),new Thief("T2")};
        Thief[] team2 = {new Thief("T3"),new Thief("T4")};

        testFighterFight(team1, team2);
    }

    public static void testWarriorFight (){
        System.out.println("\n### TEST: warrior fight ###");

        Warrior[] team1 = {new Warrior("W1"),new Warrior("W2")};
        Warrior[] team2 = {new Warrior("W3"),new Warrior("W4")};

        testFighterFight(team1, team2);
    }

    public static void testBabySlimelinFight(){
        System.out.println("\n### TEST: baby slime fight ###");

        BabySlime[] team1 = {new BabySlime("BS1"),new BabySlime("BS2")};
        BabySlime[] team2 = {new BabySlime("BS3"),new BabySlime("BS4")};

        testFighterFight(team1, team2);
    }

    public static void testBossGoblinFight(){
        System.out.println("\n### TEST: boss goblin fight ###");

        BossGoblin[] team1 = {new BossGoblin("BG1"),new BossGoblin("BG2")};
        BossGoblin[] team2 = {new BossGoblin("BG3"),new BossGoblin("BG4")};

        testFighterFight(team1, team2);
    }

    public static void testDummiesFight(){
        System.out.println("\n### TEST: dummies fight ###");

        Fighter[] team1 = {new Warrior("W1"),new Dummies("D1")};
        Fighter[] team2 = {new Warrior("W3"),new Dummies("D2")};

        testFighterFight(team1, team2);
    }

    public static void testGoblinFight(){
        System.out.println("\n### TEST: goblin fight ###");
        
        Goblin[] team1 = {new Goblin("G1"),new Goblin("G2")};
        Goblin[] team2 = {new Goblin("G3"),new Goblin("G4")};

        testFighterFight(team1, team2);
    }

    public static void testSlimeFight(){
        System.out.println("\n### TEST: slime fight ###");

        Slime[] team1 = {new Slime("S1"),new Slime("S2")};
        Slime[] team2 = {new Slime("S3"),new Slime("S4")};

        testFighterFight(team1, team2);
    }

    public static void testSpiderFight(){
        System.out.println("\n### TEST: spider fight ###");

        Spider[] team1 = {new Spider("SP1"),new Spider("SP2")};
        Spider[] team2 = {new Spider("SP3"),new Spider("SP4")};

        testFighterFight(team1, team2);
    }
}