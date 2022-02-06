package pingPongGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle{
	
	int id; // store the player's id (1 or 2)
	int yVelocity; // defines the velocity of the  vertical movement of the paddle

	public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id)
	{
		super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		this.id = id;
	}
	
	public void keyPressed(KeyEvent e)
	{
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		
	}
	
	public void setYDirection(int y)
	{
		
	}
	
	public void move()
	{
		
	}
	
	public void draw(Graphics g)
	{
		if (id == 1)
			g.setColor(Color.BLUE);
		else
			g.setColor(Color.RED);
		g.fillRect(x, y, width, height); // x, y, width, height are the fields of Rectangele Class
	}
}
