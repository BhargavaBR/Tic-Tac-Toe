package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe");
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        game.enterBoardDetails(scanner);
        game.getPlayersDetails(scanner);
        game.beginGame();
        scanner.close();
    }
}