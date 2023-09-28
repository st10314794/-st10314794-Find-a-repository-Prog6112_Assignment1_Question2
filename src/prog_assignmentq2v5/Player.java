/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_assignmentq2v5;

/**
 *
 * @author Mik
 */
public class Player {

    //Variables
    private String playerName;
    private String currentPlayer;
    private int score;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Player(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayer() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

}
