package tetrisWithOOPs;

import java.awt.Graphics2D;

/**
 * Class that serves as a proxy for the piece class
 *
 */

public class PieceProxy implements MoveableShape {

	private MoveableShape shape; // a reference of the current shape
	
	/**
	 * constructs the proxy
	 * @param shape takes a shape in to serve as proxy for
	 */
	public PieceProxy(MoveableShape shape) {
		this.shape = shape;
	}
	
	
	/**
	 * draws the piece
	 */
	@Override
	public void draw(Graphics2D g2) {
		shape.draw(g2);

	}

	/**
	 * checks if floor is reached
	 */
	@Override
	public boolean reachedFloor() {

		return shape.reachedFloor();
	}

	/**
	 * translates the piece
	 */
	@Override
	public void translate(int dx, int dy) {
		shape.translate(dx, dy);

	}

	/**
	 * callse the rotate method
	 */
	@Override
	public void rotateLeft() {
		shape.rotateLeft();

	}

	/**
	 * calls the pieces drop method
	 */
	@Override
	public void drop() {
		shape.drop();

	}

	/**
	 * sets the proxy to a piece
	 * @param shape
	 */
	public void setPiece(MoveableShape shape) {
		this.shape = shape;
	}
	
	
	/**
	 * calls the translate right or left method
	 */
	@Override
	public void translateRightORLeft(int dx, int dy) {

		shape.translateRightORLeft(dx, dy);
	}

	/**
	 * calls the gameOver() method
	 */
	@Override
	public boolean gameOver() {

		return shape.gameOver();
	}
	
	
	/**
	 * calls the reset game over method
	 */
	@Override
	public void resetGameOver() {
		shape.resetGameOver();
		
	}

}
