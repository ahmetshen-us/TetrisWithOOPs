package tetrisWithOOPs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int DELAY = 600; // Milliseconds between timer ticks
	private Timer timer; // the timer
	private PieceProxy proxy;// the piece proxy
	private JPanel thePanel;// the panel
	private GameBoard theBoard = new GameBoard(); //the gameboard
	private boolean movesLegal; //boolean that keeps track of whens moving is legal
	private Clip clip; //music clip
	private int level = 1; // dificulty level
	private RandomPieceFactory randomPiece = new RandomPieceFactory(); //the piecefactory

	public GamePanel() {
		super();
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setPreferredSize(new java.awt.Dimension(260, 500));

		this.setBackground(Color.BLACK);

		movesLegal = true;
		thePanel = this;
		proxy = new PieceProxy(randomPiece.getRandomShape(thePanel, theBoard));

		timer = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				proxy.translate(0, 1);
				checkTheState();
				repaint();
				updateLevel();

			}
		});

		playSound();

		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {

				int id = e.getKeyCode();

				if (movesLegal && id == KeyEvent.VK_SPACE) {

					proxy.rotateLeft();
				}

				else if (movesLegal && id == KeyEvent.VK_DOWN) {

					proxy.drop();

					repaint();

				} else if (movesLegal && id == KeyEvent.VK_UP) {
					proxy.translate(0, -1);

				} else if (id == KeyEvent.VK_P) {

					if (timer.isRunning()) {
						timer.stop();
						clip.stop();
						movesLegal = false;

					} else {
						movesLegal = true;
						clip.start();
						timer.start();
					}

					repaint();

				}

				else if (movesLegal && id == KeyEvent.VK_LEFT) {
					proxy.translateRightORLeft(-1, 0);
				}

				else if (movesLegal && id == KeyEvent.VK_RIGHT) {
					proxy.translateRightORLeft(1, 0);
				} else if (movesLegal && id == KeyEvent.VK_ENTER) {
					if (!proxy.gameOver()) {
						timer.start();
						clip.start();
					}
				} else if (movesLegal && id == KeyEvent.VK_R) {
					proxy.resetGameOver();
					movesLegal = true;
					timer.start();
					clip.start();
					theBoard.reset();
					proxy.setPiece(randomPiece.getRandomShape(thePanel,
							theBoard));
					level = 1;

				}

				repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});

	}

	private void checkTheState() {
		if (!proxy.gameOver()) {
			if (proxy.reachedFloor()) {

				proxy.setPiece(randomPiece.getRandomShape(thePanel, theBoard));
				theBoard.isRowComplete();
			}
		} else if (proxy.gameOver()) {
			timer.stop();
			clip.stop();
			movesLegal = true; // JUST to restart when the game is over
		}

	}

	private void playSound() {

		try {
			// Open an audio input stream.
			URL url = this.getClass().getResource("tetrisSound.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			System.out.println("Problem playing file ");
			System.out.println(e);
		}
	}

	private void updateLevel() {
		if (theBoard.getPoint() >= 10 && level == 1) {
			timer.setDelay(500);
			timer.start();
			level = 2;
		} else if (theBoard.getPoint() >= 20 && level == 2) {
			timer.setDelay(400);
			timer.start();
			level = 3;
		} else if (theBoard.getPoint() >= 30 && level == 3) {
			timer.setDelay(300);
			timer.start();
			level = 4;
		} else if (theBoard.getPoint() >= 40 && level == 4) {
			timer.setDelay(100);
			timer.start();
			level = 5;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g;

		if (!timer.isRunning()) {
			clip.stop();
			g.setColor(Color.BLUE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g.drawString("Instructions:", 0, 20);
			g.drawString("Press Enter to start the game", 0, 40);
			g.drawString("and GOOD LUCK!", 0, 60);
			g.drawString("Right Key: Move Right", 0, 80);
			g.drawString("Left Key: Move Left", 0, 100);
			g.drawString("Space Key: Rotate", 0, 120);
			g.drawString("Down Key: Drop", 0, 140);
			g.drawString("P Key: Pause", 0, 160);
			g.drawString("R Key: Restart Any Time", 0, 200);
		} else if (timer.isRunning()) {
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
			g.drawString("Points: " + theBoard.getPoint(), 0, 20);
			g.drawString("Level: " + level, 180, 20);
			g.setColor(Color.BLACK);

			theBoard.draw(brush);
			proxy.draw(brush);
		}

	}
}
