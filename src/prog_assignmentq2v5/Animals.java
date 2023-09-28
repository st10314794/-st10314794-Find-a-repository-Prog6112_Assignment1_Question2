/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_assignmentq2v5;

import java.util.Random;
import prog_assignmentq2v5.Game.DifficultyLevel;

/**
 *
 * @author Mik
 */
public class Animals extends Category {

    //2D array to store animal words, each row is a level
    private final String animalList[][] = {
        {"dog", "cat", "rat", "bat", "pig", "fish"}, //easy
        {"turtle", "monkey", "giraffe", "zebra", "penguin", "seal"},//medium
        {"aardvark", "armadillo", "rhinoceros", "platypus", "pangolin", "meerkat"},//hard
        {"axolotl", "cassowary", "quoka", "okapi", "quetzal", "humuhumunukunukuāpuaʻa"}//what the hell?
    };

    public Animals(Game game) {
        super(game);
    }

    public Animals() {
        random = new Random();
    }

    @Override
    //chooses a random element from the array
    //level is passed through, depending on what level it chooses an element from a specific row
    public String randomElement(DifficultyLevel level) {

        int randomIndex = getRandom().nextInt((animalList[0].length) - 1);

        switch (level) {
            case EASY:
                setRandomElement(animalList[0][randomIndex]);
                break;
            case MEDIUM:
                setRandomElement(animalList[1][randomIndex]);
                break;
            case HARD:
                setRandomElement(animalList[2][randomIndex]);
                break;
            case WHAT_THE_HELL:
                setRandomElement(animalList[3][randomIndex]);
                break;

        }//endswitch
        return getRandomElement();
    }

}//endclass
