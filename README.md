# Tic-Tac-Toe

Two players take alternate turns.
Players can place either 'X' or 'O' on a 3x3 board.
Declare a winner if a player aligns three symbols horizontally, vertically, or diagonally.
Declare a draw if the board is full and no winner exists.


Models
1. Player
   - Player_name
   - Symbol
   - Method:
     - getPlayer
     - setPalyer
   
2. Board
   - Char[][] Board
     - Method:
       - displayBoard
       - checkWin
       - checkDraw
   - 
3. Game
    - List<Player>
    - Board
      - Method:
        - startGame()
        - resetGame()
        - announceWinner()