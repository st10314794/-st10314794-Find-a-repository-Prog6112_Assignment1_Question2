/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_assignmentq2v5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import prog_assignmentq2v5.Game.DifficultyLevel;

/**
 *
 * @author Mik
 */
public abstract class Category {

    Scanner sc = new Scanner(System.in);
    Game game;

    //Arrays
    private char randomWordChars[];//The random guess word converted to array of chars
    private char filledWordChars[];

//variables
    protected Random random;
    private String randomElement;
    private String userGuess;
    private int numGuesses;

    public Category(Game game) {
        random = new Random();
        this.game = game;
    }
    
    public Category() {
        random = new Random();
    }

    //getters & setters
    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public String getRandomElement() {
        return randomElement;
    }

    public void setRandomElement(String randomElement) {
        this.randomElement = randomElement;
    }

    public String getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public void setNumGuesses(int numGuesses) {
        this.numGuesses = numGuesses;
    }
    
    //gets and sets for arrays
       public char[] getRandomWordChars() {
        return randomWordChars;
    }

    public void setRandomWordChars(char[] randomWordChars) {
        this.randomWordChars = randomWordChars;
    }

    public char[] getFilledWordChars() {
        return filledWordChars;
    }

    public void setFilledWordChars(char[] filledWordChars) {
        this.filledWordChars = filledWordChars;
    }

    //Methods
    //sets number of guesses based on difficulty level
    public void setNumberOfGuesses(DifficultyLevel level) {
        switch (level) {
            case EASY:
                setNumGuesses(3);
                break;
            case MEDIUM:
                setNumGuesses(5);
                break;
            case HARD:
                setNumGuesses(8);
                break;
            case WHAT_THE_HELL:
                setNumGuesses(10);
                break;
        }//endswitch
    }

    //pick a random element
    public abstract String randomElement(DifficultyLevel level);

    //enter user guess
    public void enterGuess() {
        System.out.println("Entering enterGuess method");
        String currentFillWord = fillWord(getRandomElement(), getUserGuess());
        while (game.getGameOver() == false) {
            // Ask the user for a guess
            System.out.println("Guess The Word!!");
            System.out.println("--------------------------------------------");
            System.out.println("Word: " + currentFillWord);
            System.out.println("Guesses Left: " + getNumGuesses() + "   Word Length: " + getRandomElement().length());
            System.out.println("Enter your guess:");
            boolean guessValid = false;
            String guess = null;
            while (guessValid == false) {
                guess = sc.nextLine();
                if (guess == null || guess.trim().isEmpty()) {
                    System.out.println("Invalid input. Please enter a non-empty guess.");
                } else if (guess.length() < getRandomElement().length()) {
                    System.out.println("Please enter a word that is not less than " + getRandomElement().length() + ""
                            + " letters.");
                } else {
                    guessValid = true;
                }//endif
            }//endwhile

            setUserGuess(guess);
            currentFillWord = fillWord(getRandomElement(), getUserGuess());
            boolean isGuessCorrect = checkGuess();
            //if statement:
            // if guess is correct it will call gameWon method
            //if guess is not correct and user still has guesses -> calls decreaseGuesses method
            //if numGuess reaches 0 game is lost
            if (isGuessCorrect) {
                game.gameWon();
            } else if (isGuessCorrect == false && game.getGameOver() != true) {
                decreaseGuesses();
                if (getNumGuesses() == 0) {
                    game.setGameOver(true);
                    game.gameLost();
                }//endinnerif
            } //endouterif

        }//endwhileloop
    }//endenterguess

    //checks guess if:
    //gameOver is false - signifying game is not over
    //if guess is correct returns true
    //if guess is wrong returns false
    public boolean checkGuess() {
        boolean correctGuess = false;
        if (game.getGameOver() == false) {
            // If the user hasn't run out of guesses, check if the guess is correct
            if (getRandomElement().equalsIgnoreCase(getUserGuess())) {
                correctGuess = true;
            }//endinnerif
        }//endouterif
        return correctGuess;
    }

    public void decreaseGuesses() {
        if (getNumGuesses() > 0) {
            int guesses = getNumGuesses();
            guesses--;
            setNumGuesses(guesses);
        }

    }//end

    //fills in word with dashes if user hasn't entered a guess yet
    //if user has entered a guess it checks every character and replaces it
    //if necessary
    public String fillWord(String randomWord, String userGuess) {
        if (userGuess == null) {//if user hasn't guessed yet
            //if userGuess is null, this executed
            filledWordChars = new char[randomWord.length()];
            //fills char array with dashes
            Arrays.fill(filledWordChars, '_');
            //using string class constructor to convert array of chars into string
            return new String(filledWordChars);
        }
        randomWordChars = randomWord.toCharArray();
        

        for (int i = 0; i < randomWord.length(); i++) {
            //if userguess is not null, this executes
            if (randomWordChars[i] == userGuess.charAt(i) || filledWordChars[i] != '_') {
                filledWordChars[i] = randomWordChars[i];
            } else {
                filledWordChars[i] = '_';
            }//endif

        }//endfor     

        return new String(filledWordChars);
    }

 

}//endclass
