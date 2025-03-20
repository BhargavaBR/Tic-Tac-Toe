package org.example;

import org.example.Model.Board;
import org.example.Model.Move;
import org.example.Model.Player;

import java.util.*;

public class Game {
    private static final int totalPlayers = 2;
    private List<Player> players = new ArrayList<>();
    private Board board;

    public Game(){}

    public void getPlayersDetails(Scanner scanner) {

        scanner.nextLine();
        System.out.println("Enter Player1 Name: ");
        String name = scanner.nextLine();
        Player player1 = new Player();
        player1.setName(name);
        player1.setSymbol('X');

        System.out.println("Enter Player2 Name: ");
        name = scanner.nextLine();
        Player player2 = new Player();
        player2.setName(name);
        player2.setSymbol('0');

        players.addAll(List.of(player1, player2));

    }

    public void enterBoardDetails(Scanner scanner){
        System.out.println("Please Enter Board Dimension, Minimum Size 3 X 3");
        int dimension = scanner.nextInt();
        if(dimension < 3) dimension = 3;
        board = new Board(dimension);
        buildBoard(board);
    }

    private void buildBoard(Board board) {
        int dimension = board.getDimension();
        for(int row=0;row<dimension;row++){
            for(int col=0;col<dimension;col++){
                board.getBoard()[row][col] = '-';
            }
        }
    }

    public void beginGame(){
        int currentPlayerIndex = 0;
        while(true) {
            showBoard();
            Player player = players.get(currentPlayerIndex);
            System.out.println(player.getName()+ " please enter your move");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Row: ");
            int row = scanner.nextInt();
            System.out.println("Column: ");
            int col = scanner.nextInt();
            Move move = new Move(row, col);

            if(!checkValidMove(move)){
                System.out.println("Please enter valid move");
                continue;
            }
            makeMove(move,player);
            if(checkWinningMove(move, player)){
                System.out.println("Player "+player.getName()+ " wins!");
                break;
            }
            if(checkMatchDraw()){
                System.out.println("Game is Draw!!");
                break;
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % totalPlayers;
        }
    }

    private void showBoard() {
        int dimension = board.getDimension();
        for(int row=0;row<dimension;row++){
            for(int col=0;col<dimension;col++){
                System.out.print("| "+board.getBoard()[row][col]+" |");
            }
            System.out.println();
        }
    }

    private boolean checkWinningMove(Move move, Player player) {
        // top and bottom row check
        int dimension = board.getDimension();
        char[][] gameBoard = board.getBoard();
        char symbol = player.getSymbol();
        int row = move.getRow(), col = move.getCol();
        boolean rowWin = true, colWin = true;
        //row check
        for(int i=0;i<dimension;i++){
            if(gameBoard[row][i] != symbol){
                rowWin = false;
                break;
            }
        }
        for(int i=0;i<dimension;i++){
            if(gameBoard[i][col] != symbol){
                colWin = false;
                break;
            }
        }
        //diagonal
        boolean leftDiagonal = true, rightDiagonal = true;
        for (int i = 0; i < dimension; i++) {
            if (gameBoard[i][i] != symbol) leftDiagonal = false;
            if (gameBoard[i][dimension - i - 1] != symbol) rightDiagonal = false;
        }

        return leftDiagonal || rightDiagonal || rowWin || colWin;

    }


    private void makeMove(Move move, Player player) {
        board.getBoard()[move.getRow()][move.getCol()] = player.getSymbol();
    }

    private boolean checkMatchDraw() {
        int dimension = board.getDimension();
        for(int row=0;row<dimension;row++){
            for(int col=0;col<dimension;col++){
                if(board.getBoard()[row][col] == '-') return false;
            }
        }
        return true;
    }

    private boolean checkValidMove(Move move) {
        int boardDimension = board.getDimension();
        int row = move.getRow(), col = move.getCol();
        return (row>=0 && row<boardDimension && col>=0 && col<boardDimension && board.getBoard()[row][col] == '-');
    }

}
