package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe");
        Game game = new Game();
        game.enterBoardDetails();
        game.getPlayersDetails();
        game.beginGame();
    }
}