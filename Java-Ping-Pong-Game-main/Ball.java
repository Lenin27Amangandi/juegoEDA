import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle {

	//initializing position and speed parameter variables
	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed=2;
	
	Ball(int x, int y, int width, int height){		//sets the coordinates and direction of balls
		super(x,y,width,height);
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection*initialSpeed);
		
		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0)
			randomYDirection--;
		setYDirection(randomYDirection*initialSpeed);
		
	}
	public void setXDirection(int randomXDirection) {		//sets the x-direction of ball
		xVelocity = randomXDirection;
	}
	public void setYDirection(int randomYDirection) {		//sets the y-direction of ball
		yVelocity = randomYDirection;
	}
	public void move() {						// updates the coordinates of balls
		x += xVelocity;
		y += yVelocity;
	}
	public void draw(Graphics g) {				// draws the ball shape
		g.setColor(Color.white);
		g.fillOval(x,y,height,width);			// oval shaped ball
	}
}
