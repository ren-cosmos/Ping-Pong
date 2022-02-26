import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends Rectangle{
	
	Random random;
	int xVelocity, yVelocity; // defines the velocity of horizontal and vertical motion respectively
	int initialSpeed = 2;

	public Ball(int x, int y, int width, int height)
	{
		super(x, y, width, height);
		random = new Random();
		
		int randomXDirection = random.nextInt(2);
		if ( randomXDirection == 0)  // ball moves left randomXDir is 0. //
			randomXDirection--;        //  otherwise, it moves right //
		setXVelocity(randomXDirection * initialSpeed);
		
		int randomYDirection = random.nextInt(2);
		if (randomYDirection == 0)   // ball moves down randomYDir is 0. //
			randomYDirection--;        //  otherwise, it moves down  //
		setYVelocity(randomYDirection * initialSpeed);
	}
	
	public void setXVelocity(int x)
	{
		xVelocity = x;
	}
	
	public void setYVelocity(int y)
	{
		yVelocity = y;
	}
	
	public void move()
	{
		x += xVelocity;
		y += yVelocity;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(x, y, height, width);
	}

}