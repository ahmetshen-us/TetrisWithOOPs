package tetrisWithOOPs;

/**
 * contains specific information for drawing ReverseL
 */

import java.awt.Color;

import javax.swing.JPanel;

public class ReverseL extends TetrisPieces {

	
	private static int shapePosition[][][] = {
			{ {0,1,2,2}, {0,0,0,1} },
			{ {0,1,0,0}, {0,0,1,2} },
			{ {0,0,1,2}, {0,1,1,1} },
			{ {1,1,0,1}, {0,1,2,2} } };

	public ReverseL(int xPos, int yPos,  JPanel panel, int rand, GameBoard b,Color color) {

		super(xPos, yPos, panel, shapePosition[rand],b,color);
	}

}