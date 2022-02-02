package pingPongGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
// implementing Runnable interface allows the program to run on a thread
	
	static final int GAME_WIDTH = 1000; // this is a constant which will be shared by any instance of the GamePanel
	static final int GAME_HEIGHT = (int) (GAME_WIDTH*(5/9)); // constants are often declared as static variables. static keyword denote class variables
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25, PADDLE_HEIGHT = 100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1, paddle2; // controlled by the players
	Ball ball;
	Score score;
	
	public GamePanel()
	{
		
	}
	
	public void newBall()  // can be used whenever the game is reset
	{
		
	}
	
	public void newPaddle()  // can be used whenever the game is reset
	{
		
	}
	
	public void paint(Graphics g)
	{
		
	}
	
	public void draw(Graphics g)
	{
		
	}
	
	public void move()
	{
		
	}
	
	public void checkCollision()
	{
		
	}
	
	public void run()
	{
		
	}
	
	public class AL extends KeyAdapter  // AL stands for actionlistener
	{
		public void keyPressed(KeyEvent e)
		{
			
		}
		
		public void keyReleased(KeyEvent e)
		{
			
		}

	}
}