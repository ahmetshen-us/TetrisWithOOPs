package tetrisWithOOPs;

import java.awt.Color;
import java.awt.Graphics2D;

public class GameBoard {

	final private int BOARD_HEIGHT = 25, BOARD_WIDTH = 13;;
	final private Color[][] FILLED = new Color[BOARD_WIDTH][BOARD_HEIGHT];
	private int pieceWidth = 20;
	private int point = 0;
	private int count;

	public GameBoard() {

	}
	
	/**
	 * updates color of an input position on gameboard
	 * 
	 * @param xPos x coordinate of updated position
	 * @param yPos y coordinate of updated position
	 * @param c color of updated position
	 */
	public void updateBoard(int xPos, int yPos, Color c) {

		FILLED[xPos][yPos] = c;

	}
	
	/**
	 * returns color value of a given coordinate
	 * 
	 * @param x x coordinate of specified position in gameboard
	 * @param y y coordinate of specified position in gameboard
	 * @return color of specified position in filled
	 */
	public Color getArrVal(int x, int y) {

		return FILLED[x][y];
	}

	
	/**
	 * draws the gameboard
	 * 
	 * @param g the 2d graphics element
	 */
	public void draw(Graphics2D g) {

		for (int x = 0; x < FILLED.length; x++) {
			for (int y = 0; y < FILLED[0].length; y++) {
				if (!(FILLED[x][y] == null)) {
					g.setColor(FILLED[x][y]);
					g.fill3DRect(x * pieceWidth, y * pieceWidth, pieceWidth,
							pieceWidth, true);
				}
			}
		}
	}
	
	/**
	 * checks if a row in filled has been completed
	 */
	public void isRowComplete() {
		count = 0;
		int[] complete = new int[BOARD_HEIGHT];
		for (int y = 0; y < BOARD_HEIGHT; y++) {
			int filledCell = 0;
			for (int x = 0; x < BOARD_WIDTH; x++) {
				if (!(FILLED[x][y] == null))
					filledCell++;
				if (filledCell == BOARD_WIDTH) {
					complete[y] = 1;
					point += 5;
				}
			}
		}

		clearCompleteRow(complete);
		shiftDown(complete);

	}
	
	/**
	 * clears completed row
	 * @param completed row in filled that has been completely filled
	 */
	private void clearCompleteRow(int[] completed) {

		for (int i = 0; i < completed.length; i++) {
			if (completed[i] == 1) {
				count++;
				// if tetris increase point by 20
				if (count == 4) {
					point += 20;
				}

				for (int x = 0; x < BOARD_WIDTH; x++) {

					if (!(FILLED[x][i] == null)) {
						FILLED[x][i] = null;

					}
				}
			}
		}

	}

	/**
	 * shifts pieces above a completed row down
	 * @param completed completed row
	 */
	private void shiftDown(int[] completed) {
		for (int row = 0; row < completed.length; row++) {
			if (completed[row] == 1) {
				for (int y = row; y >= 1; y--) {
					for (int x = 0; x < BOARD_WIDTH; x++) {
						FILLED[x][y] = FILLED[x][y - 1];
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPoint() {
		return point;
	}
	
	/**
	 * resets the board
	 */
	public void reset() {
		point = 0;
		for (int i = 0; i < FILLED.length; i++) {
			for (int j = 0; j < FILLED[i].length; j++) {

				FILLED[i][j] = null;

			}

		}

	}

}
