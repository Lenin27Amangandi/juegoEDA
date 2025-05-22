package Entities;
import java.awt.*;
import java.util.*;

// public class Ball extends Rectangle {

	//initializing position and speed parameter variables
// 	Random random;
// 	public int xVelocity;
// 	public int yVelocity;
// 	int initialSpeed=2;
	
// 	public Ball(int x, int y, int width, int height){		//sets the coordinates and direction of balls
// 		super(x,y,width,height);
// 		random = new Random();
// 		int randomXDirection = random.nextInt(2);
// 		if(randomXDirection == 0)
// 			randomXDirection--;
// 		setXDirection(randomXDirection*initialSpeed);
		
// 		int randomYDirection = random.nextInt(2);
// 		if(randomYDirection == 0)
// 			randomYDirection--;
// 		setYDirection(randomYDirection*initialSpeed);
		
// 	}
// 	public void setXDirection(int randomXDirection) {		//sets the x-direction of ball
// 		xVelocity = randomXDirection;
// 	}
// 	public void setYDirection(int randomYDirection) {		//sets the y-direction of ball
// 		yVelocity = randomYDirection;
// 	}
// 	public void move() {						// updates the coordinates of balls
// 		x += xVelocity;
// 		y += yVelocity;
// 	}
// 	public void draw(Graphics g) {				// draws the ball shape
// 		g.setColor(Color.white);
// 		g.fillOval(x,y,height,width);			// oval shaped ball
// 	}
// }



import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle {

	public Random random;
	public int xVelocity;
	public int yVelocity;
	public int initialSpeed = 2;
	public Image ballImage;

	// Constructor público
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		random = new Random();

		// Dirección aleatoria en X
		int randomXDirection = random.nextInt(2);
		if (randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection * initialSpeed);

		// Dirección aleatoria en Y
		int randomYDirection = random.nextInt(2);
		if (randomYDirection == 0)
			randomYDirection--;
		setYDirection(randomYDirection * initialSpeed);

		// Cargar y escalar imagen
		ballImage = new ImageIcon("Java-Ping-Pong-Game-main/Utilies/EsferaDelDragon.png")
				.getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
				// .getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}

	// Setters públicos
	public void setXDirection(int xDirection) {
		this.xVelocity = xDirection;
	}

	public void setYDirection(int yDirection) {
		this.yVelocity = yDirection;
	}

	// Getters públicos (opcional, pero útil si otras clases acceden a coordenadas)
	public int getXVelocity() {
		return xVelocity;
	}

	public int getYVelocity() {
		return yVelocity;
	}

	public int getXPosition() {
		return x;
	}

	public int getYPosition() {
		return y;
	}

	public int getBallWidth() {
		return width;
	}

	public int getBallHeight() {
		return height;
	}

	// Mover la pelota
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}

	// Dibujar la imagen
	public void draw(Graphics g) {
		g.drawImage(ballImage, x, y, null);
	}
}

