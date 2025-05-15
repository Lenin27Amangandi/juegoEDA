import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {

	int id;
	int yVelocity;
	int speed=10; 	// setting initial speed of ball
	
	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);		//sets the paddle coordinates and 
		this.id = id;								//information for which player's paddle
	}
	
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:									//paddle movement for player1 which uses 'w' and 's' keys 
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(-speed);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(speed);
				move();
			}
			break;
		case 2:									//paddle movement for player2 which uses arrow keys 
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(-speed);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(speed);
				move();
			}
			break;
		}
	}
	public void keyReleased(KeyEvent e) {  //for stopping the movement of paddles 
		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(0);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(0);
				move();
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(0);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(0);
				move();
			}
			break;
		}
	}
	public void setYDirection(int yDirection) { 	// sets the direction of paddle
		yVelocity = yDirection;
	}
	public void move() {					//moves the paddle up and down
		y = y + yVelocity;
	}
	public void draw(Graphics g) {			//draws the paddles shapes for both players
		if(id == 1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
		g.fillRect(x,y, width, height);     // Rectangular paddles 
	}
}
