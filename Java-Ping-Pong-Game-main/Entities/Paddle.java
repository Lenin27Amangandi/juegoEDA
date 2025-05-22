// package Entities;
// import java.awt.*;
// import java.awt.event.*;

// public class Paddle extends Rectangle {

// 	int id;
// 	int yVelocity;
// 	int speed=20; 	// setting initial speed of ball

// 	public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
// 		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);		//sets the paddle coordinates and 
// 		this.id = id;								//information for which player's paddle
// 	}

// 	public void keyPressed(KeyEvent e) {
// 		switch(id) {
// 		case 1:									//paddle movement for player1 which uses 'w' and 's' keys 
// 			if(e.getKeyCode()==KeyEvent.VK_W) {
// 				setYDirection(-speed);
// 				move();
// 			}
// 			if(e.getKeyCode()==KeyEvent.VK_S) {
// 				setYDirection(speed);
// 				move();
// 			}
// 			break;
// 		case 2:									//paddle movement for player2 which uses arrow keys 
// 			if(e.getKeyCode()==KeyEvent.VK_UP) {
// 				setYDirection(-speed);
// 				move();
// 			}
// 			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
// 				setYDirection(speed);
// 				move();
// 			}
// 			break;
// 		}
// 	}
// 	public void keyReleased(KeyEvent e) {  //for stopping the movement of paddles 
// 		switch(id) {
// 		case 1:
// 			if(e.getKeyCode()==KeyEvent.VK_W) {
// 				setYDirection(0);
// 				move();
// 			}
// 			if(e.getKeyCode()==KeyEvent.VK_S) {
// 				setYDirection(0);
// 				move();
// 			}
// 			break;
// 		case 2:
// 			if(e.getKeyCode()==KeyEvent.VK_UP) {
// 				setYDirection(0);
// 				move();
// 			}
// 			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
// 				setYDirection(0);
// 				move();
// 			}
// 			break;
// 		}
// 	}
// 	public void setYDirection(int yDirection) { 	// sets the direction of paddle
// 		yVelocity = yDirection;
// 	}
// 	public void move() {					//moves the paddle up and down
// 		y = y + yVelocity;
// 	}
// 	public void draw(Graphics g) {			//draws the paddles shapes for both players
// 		if(id == 1)
// 			g.setColor(Color.blue);
// 		else
// 			g.setColor(Color.red);
// 		g.fillRect(x,y, width, height);     // Rectangular paddles 
// 	}
// }

package Entities;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // Necesario para ImageIcon

public class Paddle extends Rectangle {

	int id;
	int yVelocity;
	int speed = 15; // Velocidad de la paleta
	Image paddleImage; // Imagen de la paleta

	// Constructor
	public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
		super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT); // Establece las coordenadas y tamaño de la paleta
		this.id = id; // ID del jugador (1 o 2)

		// Cargar las imágenes según el jugador
		if (id == 1) {
			// Carga la imagen para el jugador 1 y escala
			paddleImage = new ImageIcon("Java-Ping-Pong-Game-main/Utilies/PersonajeJugable.jpg").getImage()
					// .getScaledInstance(PADDLE_WIDTH, PADDLE_HEIGHT, Image.SCALE_SMOOTH);
					.getScaledInstance(40, PADDLE_HEIGHT, Image.SCALE_SMOOTH);
		} else {
			// Carga la imagen para el jugador 2 y escala
			paddleImage = new ImageIcon("Java-Ping-Pong-Game-main/Utilies/PersonajeRayo.png").getImage()
					// .getScaledInstance(PADDLE_WIDTH, PADDLE_HEIGHT, Image.SCALE_SMOOTH);
					.getScaledInstance(40, PADDLE_HEIGHT, Image.SCALE_SMOOTH);
		}
	}

	// Método para mover la paleta
	public void keyPressed(KeyEvent e) {
		switch (id) {
			case 1: // Jugador 1 (teclas 'W' y 'S')
				if (e.getKeyCode() == KeyEvent.VK_W) {
					setYDirection(-speed);
					move();
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					setYDirection(speed);
					move();
				}
				break;
			case 2: // Jugador 2 (flechas '↑' y '↓')
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					setYDirection(-speed);
					move();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					setYDirection(speed);
					move();
				}
				break;
		}
	}

	// Método para detener la paleta al soltar la tecla
	public void keyReleased(KeyEvent e) {
		switch (id) {
			case 1:
				if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
					setYDirection(0);
					move();
				}
				break;
			case 2:
				if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
					setYDirection(0);
					move();
				}
				break;
		}
	}

	// Establece la dirección del movimiento de la paleta
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}

	// // Mueve la paleta
	public void move() {
		y = y + yVelocity;
	}

	// Dibuja la imagen de la paleta
	public void draw(Graphics g) {
		g.drawImage(paddleImage, x, y, null); // Dibuja la imagen en lugar de un rectángulo
	}
}
