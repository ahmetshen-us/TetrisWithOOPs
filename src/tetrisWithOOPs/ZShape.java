package tetrisWithOOPs;

import java.awt.Color;

import javax.swing.JPanel;
/**
 * contains specific information for drawing ZShape
 */
public class ZShape extends TetrisPieces {

	private static int shapePosition[][][] = {
			{ { 1, 1, 0, 0 }, { 0, 1, 1, 2 } },
			{ { 0, 1, 1, 2 }, { 0, 0, 1, 1 } },
			{ { 1, 1, 0, 0 }, { 0, 1, 1, 2 } },
			{ { 0, 1, 1, 2 }, { 0, 0, 1, 1 } } };

	public ZShape(int xPos, int yPos,  JPanel panel, int rand, GameBoard b,Color color) {

		super(xPos, yPos, panel, shapePosition[rand],b,color);

	}

}