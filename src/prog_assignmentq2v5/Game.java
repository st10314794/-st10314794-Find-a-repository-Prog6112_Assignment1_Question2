/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_assignmentq2v5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mik
 */
public class Game {

    Scanner sc = new Scanner(System.in);

   

//enum for difficulty level
    enum DifficultyLevel {
        EASY, MEDIUM, HARD, WHAT_THE_HELL;
    }
//enum for categories

    enum Categories {
        ANIMALS, COUNTRIES, FOODS;
    }

//ArrayList
    private ArrayList<Player> players = new ArrayList<>();

  

    Category catName = null;

    //variables
    private boolean gameOver;
    private String currentPlayer;
    private DifficultyLevel diffLevel;
    
     public ArrayList<Player> getPlayers() {
        return players;
    }
       public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public DifficultyLevel getDiffLevel() {
        return diffLevel;
    }

    public void setDiffLevel(DifficultyLevel diffLevel) {
        this.diffLevel = diffLevel;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    /*
     * Starts the game by selecting a category and difficulty level.
     * It creates an instance of the chosen category, sets the number of guesses,
     * selects a random word, and allows the user to enter guesses.
     */
    public void intro() {
        System.out.println("--------------------------------------------"
                + "\nWelcome to Guess The Word!!"
                + "\n--------------------------------------------");

        System.out.println("To start please enter your name:");
        String player = sc.nextLine();
//calls method to add players
        addPlayers(player);

    }//endintro

    public void startGame() {
        //Calls methods to choose category and level
        Categories category = chooseCategory();
        DifficultyLevel level = chooseLevel();
        setDiffLevel(level);
        switch (category) {
            case ANIMALS:
                catName = new Animals(this);
                break;
            case COUNTRIES:
                catName = new Countries(this);
                break;
            case FOODS:
                catName = new Foods(this);
                break;

        }//endswitch

        catName.setNumberOfGuesses(level);
        catName.randomElement(level);
        catName.enterGuess();
    }

    //creates an instance of the player class
    //then adds it to the arraylist
    public void addPlayers(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
        setCurrentPlayer(playerName);
    }//end

    /*
      -Allows the user to choose a category for the game.
      -The user is prompted to select from available categories, and the selected category is
      returned.
     */
    public Categories chooseCategory() {
        Scanner scannerInput = new Scanner(System.in);
        boolean validChoice = true;
        Categories cat = null;

        System.out.println("Please select one of the following:"
                + "\n(1) For Animals"
                + "\n(2) For Countries"
                + "\n(3) For Foods");
        String catChoice = scannerInput.nextLine();

        do {
            switch (catChoice) {
                case "1":
                    System.out.println("You have selected Animals");
                    cat = Categories.ANIMALS;
                    validChoice = true;
                    break;
                case "2":
                    System.out.println("You have selected Countries");
                    cat = Categories.COUNTRIES;
                    validChoice = true;
                    break;
                case "3":
                    System.out.println("You have selected Foods");
                    cat = Categories.FOODS;
                    validChoice = true;
                    break;
                default:
                    validChoice = false;
                    System.out.println("Invalid Selection.");

                    System.out.println("Please re-enter a category:"
                            + "\n(1) For Animals"
                            + "\n(2) For Countries"
                            + "\n(3) For Foods");
                    catChoice = sc.nextLine();
            }//endswitch

        } while (!validChoice);

        return cat;
    }//endchoosecat

    public DifficultyLevel chooseLevel() {
        Scanner scannerInput = new Scanner(System.in);
        DifficultyLevel lvl;

        System.out.println("Please choose a level:"
                + "\n(1) For Easy"
                + "\n(2) For Medium"
                + "\n(3) For Hard");

        String diffLvl = scannerInput.nextLine();

        switch (diffLvl) {
            case "1":
                System.out.println("You have selected Easy difficulty");
                lvl = DifficultyLevel.EASY;
                break;
            case "2":
                System.out.println("You have selected Medium difficulty");
                lvl = DifficultyLevel.MEDIUM;
                break;
            case "3":
                System.out.println("You have selected Hard difficulty");
                lvl = DifficultyLevel.HARD;
                break;
            default:
                System.out.println("You have selected \"What The Hell??\" difficulty");
                lvl = DifficultyLevel.WHAT_THE_HELL;

        }

        return lvl;
    }//endchooselevel

    public void gameWon() {
        System.out.println("Congratulations, you have won.");

        calculateScore();
        insertionSort();
        displayScores();
        playAgain();
    }

    public void gameLost() {
        System.out.println("You have run out of guesses. The word was: " + catName.getRandomElement());//error
        playAgain();
    }

    public void displayScores() {
        System.out.println("Player Scores:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("1) Name: " + players.get(i).getPlayer()
                    + " Score: " + players.get(i).getScore());
        }
    }

    //Calculates score by using the difficulty level and numGuesses left
    public void calculateScore() {
        String name = getCurrentPlayer();
        int score = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPlayer().equals(name)) {
                switch (getDiffLevel()) {
                    case EASY:
                        score = catName.getNumGuesses() * 10;
                        break;
                    case MEDIUM:
                        score = catName.getNumGuesses() * 15;
                        break;
                    case HARD:
                        score = catName.getNumGuesses() * 30;
                        break;
                    case WHAT_THE_HELL:
                        score = catName.getNumGuesses() * 40;
                        break;
                }//endswitch
                players.get(i).setScore(score);
            }//endif
        }//endfor
    }//endcalcscore

    public void insertionSort() {
        for (int i = 1; i < players.size(); i++) {
            Player tempValue = players.get(i);

            int j = i - 1;
            while (j >= 0 && players.get(j).getScore() < tempValue.getScore()) {
                players.set(j + 1, players.get(j));
                j--;
            }//endwhile
            players.set(j + 1, tempValue);
        }//endfor

    }

    public void restartGame() {
        setGameOver(false);
        startGame();
    }

    /*
     - Asks the user if they want to play the game again or exit. If the user
     -chooses to play again, the game is restarted; otherwise, it exits.
     */
    public void playAgain() {
        System.out.println("Do you want to play again? Yes(Y) or No(N)");
        String playAgain = sc.nextLine();
        if (playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("yes")) {
            System.out.println("Are you still " + getCurrentPlayer() + "?");
            String isCurrentPlayer = sc.nextLine();
            if (!isCurrentPlayer.equalsIgnoreCase("yes") && !isCurrentPlayer.equalsIgnoreCase("y")) {
                System.out.println("Please enter your name:");
                String newPlayer = sc.nextLine();
                addPlayers(newPlayer);
            }
            restartGame();
        } else {
            System.out.println("Thank you for playing.");
            System.exit(0);
        }
    }//end playAgain
}
