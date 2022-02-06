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
	static final int GAME_HEIGHT = (int) (GAME_WIDTH*(0.5555)); // constants are often declared as static variables. static keyword denote class variables
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
		newBall();
		newPaddle();
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true); // reads keypress and keystrokes
		this.setPreferredSize(SCREEN_SIZE);
		this.addKeyListener(new AL());
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBall()  // can be used whenever the game is reset
	{
		
	}
	
	public void newPaddle()  // can be used whenever the game is reset
	{
		paddle1 = new Paddle(0, GAME_HEIGHT/2 - PADDLE_HEIGHT/2, PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, GAME_HEIGHT/2 - PADDLE_HEIGHT/2, PADDLE_WIDTH, PADDLE_HEIGHT, 2);
	
	}
	
	public void paint(Graphics g)
	{
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	
	public void draw(Graphics g)
	{
		paddle1.draw(g);
		paddle2.draw(g);
	}
	
	public void move()
	{
		
	}
	
	public void checkCollision()
	{
		
	}
	
	public void run()
	{
		// Game Loop
		
		long lastTime = System.nanoTime(); // current time in ns
		double amountOfTicks = 60.0; // frames per second
		double ns = 1000000000 / amountOfTicks; 
		double delta = 0;
		
		while(true)
		{
			long now = System.nanoTime(); // current time in ns
			delta += (now - lastTime)/ns;
			lastTime = now;    
			if (delta >= 1)
			{
				move();
				checkCollision();
				repaint();
				delta--;
				//System.out.println("TEST");
			}
		}
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
