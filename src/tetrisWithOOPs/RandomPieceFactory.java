package tetrisWithOOPs;

import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

public class RandomPieceFactory {

	private Random rand;
	private int xPos = 6;
	private int yPos = 0;
	public RandomPieceFactory(){
		
	}//empty constructor
	
	/**
	 * generates the random piece
	 * 
	 * @param thePanel takes in the display panel
	 * @param b	takes in the gameboard
	 * @return a randomly generated piece
	 */
	public MoveableShape getRandomShape(JPanel thePanel, GameBoard b) {
		
		TetrisPieces piece = null;
		rand = new Random(System.currentTimeMillis());

		int num =(int) (Math.random() * 7 + 1);
		switch (num) {
		case 1:
			piece = new RightAnglePiece(xPos, yPos, thePanel, rand.nextInt(3),
					b, Color.RED);
			break;
		case 2:
			piece = new ReverseZ(xPos, yPos, thePanel, rand.nextInt(3), b,
					Color.WHITE);
			break;
		case 3:
			piece = new ZShape(xPos, yPos, thePanel, rand.nextInt(3), b,
					Color.YELLOW);
			break;
		case 4:
			piece = new ReverseL(xPos, yPos, thePanel, rand.nextInt(3), b,
					Color.PINK);
			break;
		case 5:
			piece = new TShape(xPos, yPos, thePanel, rand.nextInt(3), b,
					Color.BLUE);
			break;
		case 6:
			piece = new Square(xPos, yPos, thePanel, rand.nextInt(3), b,
					Color.MAGENTA);
			break;
		case 7:
			piece = new Line(xPos, yPos, thePanel, rand.nextInt(3), b,
					Color.GREEN);
			break;
		}

		return piece;
	}

}
