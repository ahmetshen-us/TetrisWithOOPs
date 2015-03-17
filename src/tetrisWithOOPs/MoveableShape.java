package tetrisWithOOPs;

import java.awt.*;

/**
 * A shape that can be moved around.
 */
public interface MoveableShape {

	/**
	 * Draws the shape.
	 * 
	 * @param g2
	 *            the graphics context
	 */
	void draw(Graphics2D g2);

	public boolean reachedFloor();


	/**
	 * Moves the shape by a given amount.
	 * 
	 * @param dx
	 *            the amount to translate in x-direction
	 * @param dy
	 *            the amount to translate in y-direction
	 */
	void translate(int dx, int dy);
	
	/**
	 * moves shape left or right
	 * 
	 * @param dx difference in x
	 * @param dy difference in y
	 */
	void translateRightORLeft(int dx, int dy);

	/**
	 * rotate method
	 */
	void rotateLeft();

	/**
	 * drops the piece as far as possible
	 */
	void drop();

	/**
	 * checks gameover
	 * @return true or false
	 */
	boolean gameOver();
	
	/**
	 * resets after a game over
	 */
	void resetGameOver();
}
