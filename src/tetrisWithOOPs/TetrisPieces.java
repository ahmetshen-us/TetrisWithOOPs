package tetrisWithOOPs;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

public class TetrisPieces implements MoveableShape {

	private int xPos;
	private int yPos;
	private int width = 20;
	private JPanel panel;
	private int shapeX[];
	private int shapeY[];
	boolean reachedFloor;
	private Point block;
	final private GameBoard board;
	private Color randColor;
	private boolean gameOver;

	public TetrisPieces(int xPos, int yPos, JPanel panel, int[][] rotated,
			GameBoard board, Color color) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.panel = panel;
		this.shapeX = rotated[0];
		this.shapeY = rotated[1];
		this.board = board;
		this.randColor = color;
		this.reachedFloor = false;
		this.gameOver = false;
	}

	/**
	 * draws a piece 
	 * @param the graphics element
	 */
	public void draw(Graphics2D g2) {
		g2.setColor(randColor);
		for (int i = 0; i < 4; i++) {
			g2.fill3DRect((xPos + shapeX[i]) * width, (yPos + shapeY[i])
					* width, width, width, true);

		}

	}

	/**
	 * moves a piece 
	 * @param x distance
	 * @param y distance
	 */
	public void translate(int dx, int dy) {

		if (!reachedFloor && moveable(dx, dy)) {
			xPos += dx;
			yPos += dy;
		}

	}

	/**
	 * translates right and left
	 * @param x position
	 * @param y position
	 */
	@Override
	public void translateRightORLeft(int dx, int dy) {
		if (!reachedFloor && canMoveRightAndLeft(dx, dy)) {
			xPos += dx;
			yPos += dy;
		}

	}

	/**
	 * rotate method for a piece
	 */
	@Override
	public void rotateLeft() {
		Point center = new Point(shapeX[2], shapeY[2]);

		if (!reachedFloor) {
			for (int i = 0; i < shapeX.length; i++) {
				block = new Point(shapeX[i], shapeY[i]);
				shapeX[i] = center.x - center.y + block.y;
				shapeY[i] = center.x + center.y - block.x;

			}

		}

	}

	/**
	 * returns whether floor is reached
	 */
	public boolean reachedFloor() {
		return reachedFloor;
	}

	/**
	 * drops a piece until it cannot travel any further down
	 */
	public void drop() {

		while (moveable(0, 1)) {
			translate(0, 1);
		}

	}

	/**
	 * checks whether a piece is legally movable
	 * @param x distance to be traveled
	 * @param y distance to be traveled
	 */
	private boolean moveable(int xdir, int ydir) {

		for (int i = 0; i < 4; i++) {
			int xCell = xPos + shapeX[i] + xdir;
			int yCell = yPos + shapeY[i] + ydir;

			if (xCell * width < 0 || xCell * width >= panel.getWidth()
					|| yCell * width < 0 || yCell * width >= panel.getHeight()) {
				if (yCell * width >= panel.getHeight()) {

					updateTable();
					reachedFloor = true;

				}

				return false;
			}

			else if (!(board.getArrVal((xCell), (yCell)) == null)) {
				if (yCell - 1 <= 0) {

					gameOver = true;

				}
				updateTable();
				reachedFloor = true;
				return false;

			}

		}
		return true;

	}

	/**
	 * checks if it is legal to move left and right
	 * @param xdir
	 * @param ydir
	 * @return
	 */
	private boolean canMoveRightAndLeft(int xdir, int ydir) {
		for (int i = 0; i < 4; i++) {
			int xCell = xPos + shapeX[i] + xdir;
			int yCell = yPos + shapeY[i] + ydir;

			if (xCell * width < 0 || xCell * width >= panel.getWidth()
					|| yCell * width <= 0) {
				return false;

			} else if (!(board.getArrVal((xCell), (yCell)) == null)) {

				return false;

			}

		}
		return true;
	}
	
	/**
	 * updates the table
	 */
	private void updateTable() {

		for (int i = 0; i < 4; i++) {
			int xCell = xPos + shapeX[i];
			int yCell = yPos + shapeY[i];

			board.updateBoard(xCell, yCell, randColor);
		}

	}

	/**
	 * returns value of gameover
	 */
	@Override
	public boolean gameOver() {

		return gameOver;
	}
	
	/**
	 * sets the gameover variable to false
	 */
	public void resetGameOver(){
		gameOver=false;
	}

}
