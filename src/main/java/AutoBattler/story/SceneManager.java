package AutoBattler.story;

import AutoBattler.teams.*;

public class SceneManager {

    public static void startStory(Team player, String playerName){
        PrologueScene.prologue(player, playerName);
        Chapter1Scene.chapter1(player, playerName);
    }


}