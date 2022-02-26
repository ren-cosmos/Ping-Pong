import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable
{
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
		//random = new Random();
		ball = new Ball(GAME_WIDTH/2-BALL_DIAMETER/2, GAME_HEIGHT/2-BALL_DIAMETER/2, BALL_DIAMETER, BALL_DIAMETER);
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
		ball.draw(g);
	}
	
	public void move()
	{
		paddle1.move();
		paddle2.move();
		ball.move();
	}
	
	public void checkCollision() // stops the paddles from beyond of window edges
	{
		
		if(paddle1.y < 0) // if paddle tries to go beyond the top edge
			paddle1.y = 0; // bring it back to the top edge.
		
		if(paddle1.y > GAME_HEIGHT-PADDLE_HEIGHT) // if paddle2 tries to go beyond the bottom edge
			paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT; // bring it back to the bottom edge
		
		if(paddle2.y < 0)
			paddle2.y = 0;
		
		if(paddle2.y > GAME_HEIGHT-PADDLE_HEIGHT)
			paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;
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
				move(); // by calling this method within the game loop results in smooth motion of paddles and ball
				checkCollision(); // restricts the paddles and balls within window edges
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
			//when a key is pressed, we run keyPressed() methods on 
			//paddle1 and paddle2.
			//when keyPressed runs on Paddle1, case 1 of the switch statement
			//is executed. Here, if w or s is pressed only then paddle1 moves
			// up or down. otherwise it does not move.
			
			//Same is the scenario when keyPressed() runs on Paddle2.
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e)
		{
			//when a key is released, we run keyReleased() methods on 
			//paddle1 and paddle2.
			//when keyReleased runs on Paddle1, case 1 of the switch statement
			//is executed. Here, if w or s was pressed, only then paddle1 stops
			//moving on releasing the key w or s. otherwise, it was initially
			//not moving and still remains constant.
			
			//Same is the scenario when keyReleased() runs on Paddle2.
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}

	}
}