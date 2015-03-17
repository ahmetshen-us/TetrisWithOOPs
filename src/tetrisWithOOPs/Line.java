package tetrisWithOOPs;

import java.awt.Color;

import javax.swing.JPanel;

public class Line extends TetrisPieces {

	private static int shapePosition[][][] = {
			{ { 0, 1, 2, 3 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 0, 0 }, { 0, 1, 2, 3 } },
			{ { 0, 1, 2, 3 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 0, 0 }, { 0, 1, 2, 3 } } };

	public Line(int xPos, int yPos,  JPanel panel, int rand, GameBoard b,Color color) {

		super(xPos, yPos, panel, shapePosition[rand],b,color);
		

		

	}

}