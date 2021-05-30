import java.util.*;

public class TicTacToe {

	/**
	 * @param args the command line arguments
	 */
	public static int row, colm;
	public static char board[][] = new char [3][4];
	public static Scanner console = new Scanner(System.in);
	public static char turn = 'X';

	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++){
				board[i][j] = '_';
			}
		}

		board();
		play();
		winner(row,colm);
	}

	public static void board() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				if(j == 0) {
					System.out.print("|");
				} else {
					System.out.print(board[i][j]+"|");
				}

			}
			System.out.println();
		}
	}

	public static void play() {
		boolean playing = true;
		while(playing) {
			row = console.nextInt();
			colm = console.nextInt();
			board[row][colm] = turn;
			if(winner(row,colm)) {
				playing = false;
				System.out.print("you win");
			}
			board();
			if(turn == 'X') {
				System.out.println("Player 2 your O");
				turn = 'O';
			} else
				turn='X';
		}
	}

	public static boolean winner(int move1, int move2) {
		if(board[0][move2] == board[1][move2] && board[0][move2] == board[2][move2])
			return true;
		if(board[move1][0] == board[move1][1] && board[move1][0] == board[move1][2])
			return true;
		if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_')
			return true;
		if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_')
			return true;
		return false;
	}