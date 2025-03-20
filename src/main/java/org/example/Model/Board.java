package org.example.Model;

public class Board {
    private int dimension;
    private char[][] board;

    public Board(int dimension) {
        this.dimension = dimension;
        board = new char[dimension][dimension];
    }

    public int getDimension() {
        return dimension;
    }
    public char[][] getBoard() {
        return board;
    }

}
