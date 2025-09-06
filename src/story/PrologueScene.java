package story;

import teams.*;
import entities.*;
import battle.*;
import game.*;

public class PrologueScene {

    // ### PROLOGUE ###
    public static void prologue(Team player, String playerName){
        System.out.println("### PROLOGUE : WHERE AM I ? ###\n");
        sceneIntroDarkRoom();
        sceneSibilMeetsHero(playerName);
        sceneOracleTree();
        sceneDecisionToAdventure();
        sceneLibraryOfDestinies(player, playerName);
    }

    private static void sceneIntroDarkRoom() {
        Dialogue.displayDialogue("\nNarrator", "You wake up in a dark room and hear a voice");
        Dialogue.displayDialogue("???", "Hello stranger, you have just entered a new world");
        Dialogue.displayDialogue("You", "...");
        Dialogue.displayDialogue("???", "You must be wondering what you are doing here, right?");
        Dialogue.displayDialogue("You", "...");
        Dialogue.displayDialogue("???", "You will find all the answers by exploring this world");
        Dialogue.displayDialogue("???", "I hope you will find the answers to your questions");
        Dialogue.displayDialogue("???", "With that, goodbye");
        Dialogue.displayDialogue("Narrator", "At the end of this sentence, you feel yourself falling");
        Dialogue.displayDialogue("Narrator", "And an intense light blinds you");
    }
    
    private static void sceneSibilMeetsHero(String playerName) {
        Dialogue.displayDialogue("???", "Sir, are you okay?");
        Dialogue.displayDialogue("Narrator", "You open your eyes and see a little red-haired girl with a funny hat");
        Dialogue.displayDialogue("You", "Yes, I'm fine but...");
        Dialogue.displayDialogue("You", "Who are you and where am I?");
        Dialogue.displayDialogue("Sibil", "My name is Sibil, I'm a Mage, and you are on the 'Maintz' road");
        Dialogue.displayDialogue("Sibil", "Between the village of 'Clairevoyance' and the 'Spring Forest'");
        Dialogue.displayDialogue("Sibil", "But tell me rather, what's your name and what are you doing here?");
        Dialogue.displayDialogue("You", "My name is " + playerName);
        Dialogue.displayDialogue("You", "To be honest, I'm not sure how I ended up here");
        Dialogue.displayDialogue("You", "I had a strange dream, and when I woke up, I found myself here");
        Dialogue.displayDialogue("Sibil", "Oh, I see");
        Dialogue.displayDialogue("Sibil", "And do you know where you're from?");
        Dialogue.displayDialogue("You", "No, except for that strange dream and my first name, I've forgotten everything else");
    }

    private static void sceneOracleTree() {
        Dialogue.displayDialogue("Sibil", "Let's go to the Oracle Tree of Clairevoyance");
        Dialogue.displayDialogue("Sibil", "The Oracle Trees know everything and everyone");
        Dialogue.displayDialogue("Sibil", "It should be able to help you with your memories");
        Dialogue.displayDialogue("Narrator", "After several minutes, you arrive in front of the Oracle Tree");
        Dialogue.displayDialogue("Sibil", "'Oracle Tree', guardian of forgotten truths, I stand before you in search of enlightenment");
        Dialogue.displayDialogue("Oracle Tree", "Speak, my child, and I shall answer your request");
        Dialogue.displayDialogue("Sibil", "My friend has lost his memory. Can you help him?");
        Dialogue.displayDialogue("Oracle Tree", "Alas, I do not know this person. He belongs to no class despite his age");
        Dialogue.displayDialogue("Sibil", "You don't have any class?");
        Dialogue.displayDialogue("You", "...");
        Dialogue.displayDialogue("Oracle Tree", "I have the feeling this young man comes from another world");
        Dialogue.displayDialogue("Sibil", "From another world?");
        Dialogue.displayDialogue("Oracle Tree", "The only other one I know in that situation is the 'Demon King'");
        Dialogue.displayDialogue("Sibil", "The Demon King!");
    }

    private static void sceneDecisionToAdventure() {
        Dialogue.displayDialogue("Sibil", "Did you hear that?");
        Dialogue.displayDialogue("You", "Yes, but is it a good idea to go talk to the Demon King?");
        Dialogue.displayDialogue("Sibil", "Obviously, that means we're going on an adventure");
        Dialogue.displayDialogue("You", "We?");
        Dialogue.displayDialogue("Sibil", "You're not going to go there alone, are you?");
        Dialogue.displayDialogue("You", "That's my problem. I don’t want to involve you in danger");
        Dialogue.displayDialogue("Sibil", "Please, please, pleaaaaaaaaaaseeeee");
        Dialogue.displayDialogue("You", "Alright, fine");
        Dialogue.displayDialogue("Sibil", "Yes, thank you! I won’t disappoint you");
    }

    private static void sceneLibraryOfDestinies(Team player, String playerName) {
        Dialogue.addFighterToTeam(player, new Mage("Sibil"));
        Dialogue.displayDialogue("Sibil", "Before we leave, we need to assign you a class");
        Dialogue.displayDialogue("You", "Yes, otherwise I won't last long");
        Dialogue.displayDialogue("Narrator", "You go to the Library of Destinies");
        Dialogue.displayDialogue("Sibil", "Is anyone here?");
        Dialogue.displayDialogue("???", "Yes, I'm in the room to your right");
        Dialogue.displayDialogue("Solange", "Hello, I’m Solange. How can I help you?");
        Dialogue.displayDialogue("Sibil", "My friend has no class and needs one to go on an adventure");
        Dialogue.displayDialogue("Solange", "Of course. Which class would you like?");
        
        GameplayRules.classes();
        player.add(TeamFactory.chooseFighter(player, playerName));

        GameplayRules.fight(player, new Team("Horde",  new Dummies()),"\nSolange","Now let's move on to the test");

        Dialogue.displayDialogue("Narrator", "After the battle, Solange heals your team");
        player.fullHealTeam();

        Dialogue.displayDialogue("Sibil", "Wow, did you see that ?");
        Dialogue.displayDialogue("Sibil", "We crushed them !");
    }
}