/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog_assignmentq2v5;

/**
 *
 * @author Mik
 */
//Programming Assignment: Word Guess Game!!
/*
        User has 5 chances to guess a word from a specific category
        After 5 chances, they lose, the word is revealed
        if they win, a win message pops up
        after game has ended, user is asked if they want to play again
 */
public class PROG_AssignmentQ2V5 {

    public static void main(String[] args) {
        Game game = new Game();
        //Introduce the program
        game.intro();

        //Start the game
        game.startGame();

    }//endmain

   
}
