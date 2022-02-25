import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

// Paddles are rectangular in shape. So, they have all the features of a rectangle
// but have an additional fields i.e 'id' and y-velocity which stores the player 
// number (1 or 2) and this is the reason to make paddle class as a child of 
// Rectangle class.
public class Paddle extends Rectangle{
	
	int id; // store the player's id (1 or 2)
	int yVelocity; // defines the velocity of the  vertical movement of the paddle
	int speed = 10;

	public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id)
	{
		super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);// calls the constructor of Rectangle Class
		this.id = id;
	}
	
	public void keyPressed(KeyEvent e)
	{
		switch(id)
		{
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W) // if w is pressed
			{
				setYVelocity(-speed);    // paddle moves //
				move();                  //      UP      //
			}
			if (e.getKeyCode() == KeyEvent.VK_S) // if s is pressed
			{
				setYVelocity(speed);     // paddle moves //
				move();                  //     DOWN     //
			}
			break;
		case 2:
			if (e.getKeyCode() == KeyEvent.VK_DOWN) // if DOWN is pressed
			{
				setYVelocity(speed);     // paddle moves //
				move();                  //    DOWN      // 
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) // if UP is pressed
			{
				setYVelocity(-speed);   // paddle moves // 
				move();                 //      UP      //
			}
			break;
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		switch(id)
		{
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W) // if w is released
			{
				setYVelocity(0); // vertical motion //
				move();          //      stops      //
			}
			if (e.getKeyCode() == KeyEvent.VK_S) // if s is released
			{
				setYVelocity(0); // vertical motion //
				move();          //      stops      //
			}
			break;
		case 2:
			if (e.getKeyCode() == KeyEvent.VK_DOWN) // if  DOWN is released
			{
				setYVelocity(0); // vertical motion //
				move();          //      stops      //
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) // if UP is released
			{
				setYVelocity(0); // vertical motion //
				move();          //      stops      //
			}
			break;
		}
	}
	
	public void setYVelocity(int y)  // sets yVelocity
	{
		yVelocity = y;
	}
	
	public void move() // moves the paddles vertically
	{
		y += yVelocity;
	}
	
	// draw method draws the paddles (blue or red)
	public void draw(Graphics g)
	{
		if (id == 1)
			g.setColor(Color.BLUE);
		else
			g.setColor(Color.RED);
		g.fillRect(x, y, width, height); // x, y, width, height are the fields of Rectangele Class
	}
}