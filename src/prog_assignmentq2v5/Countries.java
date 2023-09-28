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
public class Countries extends Category{

     //2D array to store animal words, each row is a level
    private final String countryList[][] = {
        {"spain", "india", "france", "china", "japan", "USA"}, //easy
        {"nigeria", "angola", "egypt", "tanzania", "norway", "sweden"},//medium
        {"ivory coast", "singapore", "phillipines", "bangladesh", "switzerland", "malaysia"},//hard
        {"kazakhstan", "bosnia and herzegovina", "papua new guinea", "liechtenstein", "equatorial guinea", "vanuatu"}//what the hell?
    };

    public Countries(Game game) {
        super(game);
    }
    
    
      @Override
    //chooses a random element from the array
    //level is passed through, depending on what level it chooses an element from a specific row
    public String randomElement(Game.DifficultyLevel level) {
        System.out.println("Entering randomElement method");

        int randomIndex = getRandom().nextInt((countryList[0].length) - 1);
        switch (level) {
            case EASY:
                setRandomElement(countryList[0][randomIndex]);
                break;
            case MEDIUM:
                setRandomElement(countryList[1][randomIndex]);
                break;
            case HARD:
                setRandomElement(countryList[2][randomIndex]);
                break;
            case WHAT_THE_HELL:
                setRandomElement(countryList[3][randomIndex]);
                break;

        }//endswitch
        return getRandomElement();
    }
    
}
