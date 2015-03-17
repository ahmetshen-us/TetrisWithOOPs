package tetrisWithOOPs;


import java.awt.Color;

import javax.swing.JPanel;
/**
 * contains specific information for drawing Square
 */
public class Square extends TetrisPieces {

	private static int shapePosition[][][] = {
			{ { 0, 1, 0, 1 }, { 0, 0, 1, 1 } },
			{ { 0, 1, 0, 1 }, { 0, 0, 1, 1 } },
			{ { 0, 1, 0, 1 }, { 0, 0, 1, 1 } },
			{ { 0, 1, 0, 1 }, { 0, 0, 1, 1 } } };

	public Square(int xPos, int yPos,  JPanel panel, int rand, GameBoard b,Color color) {

		super(xPos, yPos, panel, shapePosition[rand],b,color);

	}

	@Override
	public void rotateLeft() {
		// do not rotate this one(polymorphism you make more sense now :) )
	}

}