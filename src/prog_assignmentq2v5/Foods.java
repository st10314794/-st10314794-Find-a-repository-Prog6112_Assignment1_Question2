/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_assignmentq2v5;

import static prog_assignmentq2v5.Game.DifficultyLevel.EASY;
import static prog_assignmentq2v5.Game.DifficultyLevel.HARD;
import static prog_assignmentq2v5.Game.DifficultyLevel.MEDIUM;
import static prog_assignmentq2v5.Game.DifficultyLevel.WHAT_THE_HELL;

/**
 *
 * @author Mik
 */
public class Foods extends Category{

    
    
     //2D array to store animal words, each row is a level
    private final String foodList[][] = {
        {"apple", "banana", "orange", "lime", "lemon", "guava"}, //easy
        {"cabbage", "pineapple", "egypt", "spinach", "spaghetti", "popcorn"},//medium
        {"asparagus", "nectarine", "dragonfruit", "strawberry", "raspberry", "cauliflower"},//hard
        {"capsicum", "zucchini", "artichoke", "rutabaga", "tapioca", "kohlrabi"}//what the hell?
    };
    
    
    public Foods(Game game) {
        super(game);
    }

   @Override
    //chooses a random element from the array
    //level is passed through, depending on what level it chooses an element from a specific row
    public String randomElement(Game.DifficultyLevel level) {
        System.out.println("Entering randomElement method");

        int randomIndex = getRandom().nextInt((foodList[0].length) - 1);
        switch (level) {
            case EASY:
                setRandomElement(foodList[0][randomIndex]);
                break;
            case MEDIUM:
                setRandomElement(foodList[1][randomIndex]);
                break;
            case HARD:
                setRandomElement(foodList[2][randomIndex]);
                break;
            case WHAT_THE_HELL:
                setRandomElement(foodList[3][randomIndex]);
                break;

        }//endswitch
        return getRandomElement();
    }
    
    
}
