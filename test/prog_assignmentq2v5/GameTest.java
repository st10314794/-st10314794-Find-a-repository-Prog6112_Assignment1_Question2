/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog_assignmentq2v5;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mik
 */
public class GameTest {

    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testAddPlayers() {
        System.out.println("addPlayers");
        String playerName = "mik";
        Game game = new Game();
        game.addPlayers(playerName);
        String player = game.getPlayers().get(0).getPlayer();
        assertEquals("mik", player);
    }

    @Test
    public void testChooseCategory() {
        System.out.println("chooseCategory");
        Game game = new Game();
        String in = "1";
        InputStream input = new ByteArrayInputStream(in.getBytes());
        System.setIn(input);

        String expected = "ANIMALS";
        String actual = game.chooseCategory().toString();

        assertEquals(expected, actual);

    }

    @Test
    public void testChooseLevel() {
        System.out.println("chooseLevel");
        Game game = new Game();
        String in = "1";
        InputStream input = new ByteArrayInputStream(in.getBytes());
        System.setIn(input);

        String expected = "EASY";
        String actual = game.chooseLevel().toString();
        assertEquals(expected, actual);

    }

    @Test
    public void testInsertionSort() {
        System.out.println("insertionSort");
        Game game = new Game();

        game.getPlayers().add(new Player("John", 25));
        game.getPlayers().add(new Player("Alice", 30));
        game.getPlayers().add(new Player("Bob", 22));
        game.insertionSort();

        ArrayList<Player> testPlayers = new ArrayList<>();
        testPlayers.add(new Player("Alice", 30));
        testPlayers.add(new Player("John", 25));
        testPlayers.add(new Player("Bob", 22));

        assertEquals(testPlayers.get(0).getPlayer(), game.getPlayers().get(0).getPlayer());
        assertEquals(testPlayers.get(1).getPlayer(), game.getPlayers().get(1).getPlayer());
        assertEquals(testPlayers.get(2).getPlayer(), game.getPlayers().get(2).getPlayer());

    }

    @Test
    public void testCalculateScoreIfLevelEasy() {
        System.out.println("calculateScore");
        Game game = new Game();

        game.catName = new Animals();
        game.catName.setNumGuesses(2);
        game.addPlayers("mik");
        game.setDiffLevel(Game.DifficultyLevel.EASY);

        game.calculateScore();

        int playerScore = game.getPlayers().get(0).getScore();
        assertEquals(20, playerScore);
    }

    @Test
    public void testCalculateScoreIfLevelMedium() {
        System.out.println("calculateScore");
        Game game = new Game();

        game.catName = new Animals();
        game.catName.setNumGuesses(2);
        game.addPlayers("mik");
        game.setDiffLevel(Game.DifficultyLevel.MEDIUM);

        game.calculateScore();

        int playerScore = game.getPlayers().get(0).getScore();
        assertEquals(30, playerScore);
    }

    @Test
    public void testCalculateScoreIfLevelHard() {
        System.out.println("calculateScore");
        Game game = new Game();

        game.catName = new Animals();
        game.catName.setNumGuesses(2);
        game.addPlayers("mik");
        game.setDiffLevel(Game.DifficultyLevel.HARD);

        game.calculateScore();

        int playerScore = game.getPlayers().get(0).getScore();
        assertEquals(60, playerScore);
    }

}
