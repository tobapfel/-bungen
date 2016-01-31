package programming.set8.tictac;

import acm.graphics.GArc;
import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class Toe extends GraphicsProgram {
	/**
	 * Checks if it is a valid move to place a marker on the field with the given
	 * coordinates. It is valid if the coordinates are on the playing field, and
	 * if the corresponding field has not been taken by any player yet.
	 * 
	 * @param board
	 *            3x3 array representing the board. A field is considered empty
	 *            if the corresponding array field is 0.
	 * @param x
	 *            the 1-based x coordinate.
	 * @param y
	 *            the 1-based y coordinate.
	 * @return {@code true} if the move is valid.
	 */
	public static boolean isValidMove(byte[][] board, int x, int y) {
	    if (x >= 1 && x <= 3 && y >= 1 && y <= 3 && (board [y-1][x-1] == 0)) return true;
	    
	    else return false;
	    
	}

	/**
	 * Checks if anyone has won yet.
	 * 
	 * @param board
	 *            3x3 array representing the board. Each field is either 0, 1, or
	 *            2 as no player, player 1, or player 2 has placed his marker on
	 *            the field.
	 * @return {@code 0} if no player has won yet, or {@code 1} or {@code 2} if
	 *         either of the players has won.
	 */
	public static int whoWins(byte[][] board) {
		for (int i = 0; i < 3 ; i++){ //checking rows
			if ((board [i][0] == board [i][1]) && (board [i][2] == board [i][0]) && (board[i][0] != 0)) return board[i][0];
		}
		for (int j = 0; j < 3; j++){ //checking column
			if ((board [0][j] == board [1][j]) && (board [2][j] == board [0][j]) && (board[0][j] != 0)) return board[0][j];
		}
		if ((board [0][0] == board [1][1]) && (board [2][2] == board [0][0])&& (board[0][0] != 0)) return board[0][0];
		if ((board [0][2] == board [1][1]) && (board [2][0] == board [0][2])&& (board[0][2] != 0)) return board[0][2];
		return 0;
	}
	    
	    private static final int CELL_SIZE = 30;
	    private static final int BOARD_LEFT = 30;
	    private static final int BOARD_RIGHT = BOARD_LEFT + CELL_SIZE * 3;
	    private static final int BOARD_TOP = 30;
	    private static final int BOARD_BOTTOM = BOARD_TOP + CELL_SIZE * 3;
	    
	    @Override
	    public void run() {
	    	byte[][] board = new byte[3][3];
	        // Draw the Tic Tac Toe board
	        add(new GLine(
	                BOARD_LEFT,
	                BOARD_TOP + CELL_SIZE,
	                BOARD_RIGHT,
	                BOARD_TOP + CELL_SIZE));
	        add(new GLine(
	                BOARD_LEFT,
	                BOARD_BOTTOM - CELL_SIZE,
	                BOARD_RIGHT,
	                BOARD_BOTTOM - CELL_SIZE));
	        add(new GLine(
	                BOARD_LEFT + CELL_SIZE,
	                BOARD_TOP,
	                BOARD_LEFT + CELL_SIZE,
	                BOARD_BOTTOM));
	        add(new GLine(
	                BOARD_RIGHT - CELL_SIZE,
	                BOARD_TOP,
	                BOARD_RIGHT - CELL_SIZE,
	                BOARD_BOTTOM));
	        
	        // Ask the players for a total of nine moves
	        for (int move = 0; move < 9; move++) {
	            println("Player " + (move % 2 == 0 ? "1" : "2") + "!");
	            
	            // Read coordinates
	            int x = 0;
	            int y = 0;
	            
	           do {
	                y = readInt("Enter a y coordinate (1 to 3): ");
	                x = readInt("Enter an x coordinate (1 to 3): ");
	                if (!isValidMove(board, x, y)) {
	                    println("Invalid coordinates, try that again, will you?");
	                }  
	            }while (!isValidMove(board, x, y));
	            board [y-1][x-1] = move % 2 == 0 ? (byte)1 : (byte)2;
	            
	            // Turn the cell numbers into proper coordinates
	            x = BOARD_LEFT + (x - 1) * CELL_SIZE;
	            y = BOARD_TOP + (y - 1) * CELL_SIZE;
	            
	            // Draw the player's symbol
	            if (move % 2 == 0) {
	                add(new GLine(x, y, x + CELL_SIZE, y + CELL_SIZE));
	                add(new GLine(x, y + CELL_SIZE, x + CELL_SIZE, y));
	            } else {
	                add(new GArc(x, y, CELL_SIZE, CELL_SIZE, 0, 360));
	            }
	            if(whoWins(board) != 0) break;
	            
	        }
	        println ("Player "+ whoWins(board) +" wins" );
	    }
	    
	}

