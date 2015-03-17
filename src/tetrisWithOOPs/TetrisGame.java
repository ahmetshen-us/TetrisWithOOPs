package tetrisWithOOPs;

import javax.swing.JFrame;

public class TetrisGame {
	public static void main(String[] args) {

		JFrame frame = new JFrame();//creates frame
		frame.setTitle("Tetris Game");
		GamePanel theGamePanel = new GamePanel();
		
		frame.add(theGamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);//stops resizing of frame
		frame.pack();
		frame.setVisible(true);

	}
}
