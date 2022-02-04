package pingPongGame;

import java.awt.Color;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	GamePanel panel;
	
	public GameFrame()
	{
		panel = new GamePanel();
		this.setTitle("Ping Pong Game");
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		this.add(panel);
		this.pack();
	}
}
