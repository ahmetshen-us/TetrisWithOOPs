package tetrisWithOOPs;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * contains specific information for drawing RightAnglePiece
 */
public class RightAnglePiece extends TetrisPieces {

	private static int shapePosition[][][] = {
			{ {0,0,1,2}, {0,1,0,0} },
			{ {0,0,0,1}, {0,1,2,2}},
			{ {2,0,1,2}, {0,1,1,1} },
			{ {0,1,1,1}, {0,0,1,2}} };

	public RightAnglePiece(int xPos, int yPos,  JPanel panel, int rand, GameBoard b,Color color) {

		super(xPos, yPos, panel, shapePosition[rand],b,color);
	}

}