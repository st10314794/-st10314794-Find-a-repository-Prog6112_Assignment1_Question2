/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog_assignmentq2v5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mik
 */
public class CategoryTest {

    public CategoryTest() {

    }


    @Test
    public void testFillWordIfGuessNull() {
        System.out.println("fillWord");
        Category instance = new CategoryImpl();

        String randomWord = "dog";
        String userGuess = null;

        //expected number of dashes = length of randomWord
        String expResult = "___";
        String result = instance.fillWord(randomWord, userGuess);
        assertEquals(expResult, result);
    }

    @Test
    public void testFillWordIfUserGuesses() {
        System.out.println("fillWord");
        Category instance = new CategoryImpl();

        String randomWord = "dog";
        String userGuess = "pig";

        char filledWordChars[] = {'_', '_', '_'};

        instance.setFilledWordChars(filledWordChars);

        String expResult = "__g";
        String result = instance.fillWord(randomWord, userGuess);
        assertEquals(expResult, result);
    }

   

    public class CategoryImpl extends Category {

        public String randomElement(Game.DifficultyLevel level) {
            return "";
        }
    }

}
