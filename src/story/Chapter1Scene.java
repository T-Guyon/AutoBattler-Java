package story;

import teams.*;
import entities.*;
import battle.*;

public class Chapter1Scene {

    public static void chapter1(Team player, String playerName){
        System.out.println("### CHAPTER 1 : DAVE ###\n");
        sceneSolangeWarning();
        sceneSpringForest(player);
        scene3(player);
        scene4();
    }

    private static void sceneSolangeWarning(){
        Dialogue.displayDialogue("Solange", "You've already gotten the hang of your new class");
        Dialogue.displayDialogue("Solange", "You can now go wherever you want");
        Dialogue.displayDialogue("Solange", "But by the way...");
        Dialogue.displayDialogue("Solange", "Do you have a goal, or do you just want to go on an adventure ?");

        Dialogue.displayDialogue("Sibil", "We're going to see the Demon King to ask him some questions");

        Dialogue.displayDialogue("Solange", "WHAAAAAAT ???!!!");
        Dialogue.displayDialogue("Solange", "Are tou kidding me ?!");
        Dialogue.displayDialogue("Solange", "Do you have a death wish or what ?");

        Dialogue.displayDialogue("Sibil", "I know it sounds insane, but my friend has lost his memory");
        Dialogue.displayDialogue("Sibil", "and the 'Oracle Tree' said he was the only one who had the answers to his questions");

        Dialogue.displayDialogue("Solange", "Oh, i see");
        Dialogue.displayDialogue("Solange", "The problem is that the two of you will never make it on your own");
        Dialogue.displayDialogue("Solange", "I have an idea ");
        Dialogue.displayDialogue("Solange", "Go to the Will-o'-the-Wisps' Hut. It's just outside the Cave of Lies");
        Dialogue.displayDialogue("Solange", "There you'll find Dave, the only Berserker who managed to reach the Lava Pond");
        Dialogue.displayDialogue("Solange", "He should be willing to join the adventure, especially if there's fighting involved");

        Dialogue.displayDialogue("Sibil", "Thank you, that will really help us move forward");

        Dialogue.displayDialogue("Narrator", "After that sentence, your team set off toward the Will-o'-the-Wisps' cabin");
    }

    //todo Scene dans la foret de printemps
    private static void sceneSpringForest(Team player){
        Dialogue.displayDialogue("Sibil", "Look, we've arrived at the 'Spring Forest'");
        Dialogue.displayDialogue("Sibil", "The 'Cave of Lies' is just behind it");
        Dialogue.displayDialogue("Sibil", "We'll have to be careful");
        Dialogue.displayDialogue("Sibil", "There are probably monsters lurking around");


        Fight.FightLoop(player, new Team("Horde",  new Goblin(), new BabySlime()), "Narrator", "And speaking of that, a horde of monsters suddenly ambushes you");

        Dialogue.displayDialogue("Sibil", "Wow, that was close !");
        Dialogue.displayDialogue("Sibil", "Where did they come from ?");
        Dialogue.displayDialogue("Sibil", "I didn't see them coming");
        Dialogue.displayDialogue("Sibil", "Hey, look at the edge of the forest");
        Dialogue.displayDialogue("Sibil", "Ther are two monster hordes");

        Choice.choice1(player);
    }

    //todo Scene dans la grotte au mensonges avec possibilité d'aller dans un village trouver un paladin en echange d'une quete
    private static void scene3(Team player){
        Dialogue.displayDialogue("Narrator", "After defeating the horde, you exit the forest");
    
    Dialogue.displayDialogue("Sibil", "The last fight was tough, I think we should rest");
    Dialogue.displayDialogue("Sibil", "There's a village nearby 'Caramine', I believe");
    Dialogue.displayDialogue("Sibil", "Do you think we should go there, or keep going until we reach the cave ?");

    Choice.choice2(player);
    
    Dialogue.displayDialogue("Narrator", "Arriving in front of the cave, you see a large trail of blood");

    Dialogue.displayDialogue("Sibil", "Wow, what is that ?");
    Dialogue.displayDialogue("Sibil", "Where does it come from ?");
    Dialogue.displayDialogue("Sibil", "Do you think a monster could have done that ?");

    Dialogue.displayDialogue("You", "Yes, I think so, and judging by the smell, it's not the first one");
    Dialogue.displayDialogue("You", "Are you sure you want to go there ?");
    Dialogue.displayDialogue("You", "I don't want to put you in danger because of my problems");

    Dialogue.displayDialogue("Sibil", "Yes, I'm sure, we have to go");
    Dialogue.displayDialogue("Sibil", "Don't worry about me, it’s my decision to come to help you");

    Dialogue.displayDialogue("Narrator", "Following this sentence, you venture deeper into the cave in search of the one responsible for this pool of blood");
    Dialogue.displayDialogue("Narrator", "As you move forward, you notice a huge goblin with its mouth full of blood and a bone in its hand");
    Dialogue.displayDialogue("Narrator", "You then understand where this pool of blood came from");
    Dialogue.displayDialogue("Narrator", "This enormous goblin seems to be blocking the exit");

    Fight.FightLoop(player, new Team("Boss", new BossGoblin()), "Narrator", "the only way for you to proceed is to fight");

    Dialogue.displayDialogue("Sibil", "This monster was HUGE!");
    Dialogue.displayDialogue("Sibil", "I've never seen one that big before");
    Dialogue.displayDialogue("Sibil", "t must be because we're getting closer to the Demon King");
    }

    //todo Scene de recrutement de dave
    private static void scene4(){

    }
}