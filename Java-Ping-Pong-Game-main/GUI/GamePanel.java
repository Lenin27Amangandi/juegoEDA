package GUI;
// import java.awt.*;
// import java.awt.event.*;
// import java.util.*;
// import javax.swing.*;

// import BL.Score;
// import Entities.Ball;
// import Entities.Paddle;

// public class GamePanel extends JPanel implements Runnable{
// 	// defining some required initial characteristic variables
// 	static final int GAME_WIDTH = 1000;
// 	static final int GAME_HEIGHT = (int)(GAME_WIDTH*(0.5555));
// 	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
// 	static final int BALL_DIAMETER = 50;
// 	static final int PADDLE_WIDTH = 25;
// 	static final int PADDLE_HEIGHT = 100;
	
// 	//creating instances of game objects 
// 	Thread gameThread;
// 	Image image;
// 	Graphics graphics;
// 	Random random;
// 	Paddle paddle1;
// 	Paddle paddle2;
// 	Ball ball;
// 	Score score;
	
// 	//constructor for GamePanel class. starts the GUI in action 
// 	GamePanel(){
// 		newPaddles();
// 		newBall();
// 		score = new Score(GAME_WIDTH,GAME_HEIGHT);
// 		this.setFocusable(true);
// 		this.addKeyListener(new AL());
// 		this.setPreferredSize(SCREEN_SIZE);
		
// 		gameThread = new Thread(this);
// 		gameThread.start();
		
// 	}
// 	// method to create a new Ball 
// 	public void newBall() {
// 		random = new Random();
// 		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),
// 				random.nextInt(GAME_HEIGHT-BALL_DIAMETER),
// 				BALL_DIAMETER,BALL_DIAMETER);
// 	}
// 	// method to create 2 new Paddles for both players.
// 	public void newPaddles() {
// 		paddle1 = new Paddle(0,
// 				(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),
// 				PADDLE_WIDTH,PADDLE_HEIGHT,
// 				1);
// 		// paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,
// 		// 		(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),
// 		// 		PADDLE_WIDTH,PADDLE_HEIGHT,
// 		// 		2);

// 		paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH - 10,  // Coloca un margen de 10 píxeles desde el borde derecho
//                      (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
//                      PADDLE_WIDTH, PADDLE_HEIGHT, 2);
// 	}
// 	// method to color the balls and paddles
// 	public void paint(Graphics g) {
// 		image = createImage(getWidth(),getHeight());
// 		graphics = image.getGraphics();
// 		draw(graphics);
// 		g.drawImage(image,0,0,this);
// 	}
// 	// method to draw ball and paddles
// 	public void draw(Graphics g) {
// 		paddle1.draw(g);
// 		paddle2.draw(g);
// 		ball.draw(g);
// 		score.draw(g);
// 	}
// 	// method to move the Paddles
// 	public void move() {
// 		paddle1.move();
// 		paddle2.move();
// 		ball.move();
// 	}


	

// 	// method to check the collision between ball and paddles/walls
// 	public void checkCollision() {
		
// 		//bounce ball off the top and bottom edges
// 		if(ball.y <= 0)
// 			ball.setYDirection(-ball.yVelocity);
// 		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER)
// 			ball.setYDirection(-ball.yVelocity);
		
// 		//bounce ball of paddles
// 		if(ball.intersects(paddle1)) {					// for paddle1 
// 			ball.xVelocity = Math.abs(ball.xVelocity);
// 			ball.xVelocity++;
// 			if(ball.yVelocity>0)
// 				ball.yVelocity++;						//increase the ball speed with each collision
// 			else
// 				ball.yVelocity--;
// 			ball.setXDirection(ball.xVelocity);
// 			ball.setYDirection(ball.yVelocity);
// 		}
// 		if(ball.intersects(paddle2)) {					// for paddle2 
// 			ball.xVelocity = Math.abs(ball.xVelocity);
// 			ball.xVelocity++;
// 			if(ball.yVelocity>0)
// 				ball.yVelocity++;						//increase the ball speed with each collision
// 			else
// 				ball.yVelocity--;
// 			ball.setXDirection(-ball.xVelocity);
// 			ball.setYDirection(ball.yVelocity);
// 		}
// 		//stops paddles at window edges
// 		if(paddle1.y <=0)
// 			paddle1.y = 0;
// 		if(paddle1.y >= GAME_HEIGHT-PADDLE_HEIGHT)
// 			paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
// 		if(paddle2.y <=0)
// 			paddle2.y = 0;
// 		if(paddle2.y >= GAME_HEIGHT-PADDLE_HEIGHT)
// 			paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
		
// 		//gives a player 1 point and creates new paddles and ball
// 		if(ball.x <=0) {
// 			score.player2++;
// 			newPaddles();
// 			newBall();
// 		}
// 		//gives a player 1 point and creates new paddles and ball
// 		if(ball.x >=GAME_WIDTH-BALL_DIAMETER) {
// 			score.player1++;
// 			newPaddles();
// 			newBall();
// 		}
// 	}
// 	// method to run the Game (GameLoop)
// 	public void run() {
// 		long lastTime = System.nanoTime();
// 		double amountOfTicks = 60;			//controls the speed of frames
// 		double ns = 1000000000/amountOfTicks;
// 		double delta = 0;
		
// 		while(true) {
// 			long now = System.nanoTime();
// 			delta += (now - lastTime)/ns;
// 			lastTime = now;
			
// 			if(delta >= 1) {
// 				move();
// 				checkCollision();
// 				repaint();
// 				delta--;
// 			}
			
// 		}
		
// 	}
// 	public class AL extends KeyAdapter{  	 //Action Listener class 
// 		public void keyPressed(KeyEvent e) { //checks which key is pressed
// 			paddle1.keyPressed(e);
// 			paddle2.keyPressed(e);
// 		}
// 		public void keyReleased(KeyEvent e) { //checks which key is released
// 			paddle1.keyReleased(e);
// 			paddle2.keyReleased(e);
// 		}
// 	}
// }



import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import BL.Score;
import Entities.Ball;
import Entities.Paddle;

public class GamePanel extends JPanel implements Runnable {
    // Constantes del juego
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * 0.5555);
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 50;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;

    // Objetos del juego
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;

    // Imagen de fondo
    Image backgroundImage;

    // Constructor
    public GamePanel() {
        // Cargar imagen de fondo
        backgroundImage = new ImageIcon("Java-Ping-Pong-Game-main/Utilies/Fondo.jpg").getImage()
                .getScaledInstance(GAME_WIDTH, GAME_HEIGHT, Image.SCALE_SMOOTH);

        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2),
                        random.nextInt(GAME_HEIGHT - BALL_DIAMETER),
                        BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPaddles() {
        paddle1 = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
                             PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
                             PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }

    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    public void checkCollision() {
        if (ball.y <= 0) ball.setYDirection(-ball.yVelocity);
        if (ball.y >= GAME_HEIGHT - BALL_DIAMETER) ball.setYDirection(-ball.yVelocity);

        if (ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity) + 1;
            ball.yVelocity += (ball.yVelocity > 0) ? 1 : -1;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if (ball.intersects(paddle2)) {
            ball.xVelocity = -Math.abs(ball.xVelocity) - 1;
            ball.yVelocity += (ball.yVelocity > 0) ? 1 : -1;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if (paddle1.y <= 0) paddle1.y = 0;
        if (paddle1.y >= GAME_HEIGHT - PADDLE_HEIGHT) paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        if (paddle2.y <= 0) paddle2.y = 0;
        if (paddle2.y >= GAME_HEIGHT - PADDLE_HEIGHT) paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;

        if (ball.x <= 0) {
            score.player2++;
            newPaddles();
            newBall();
        }

        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player1++;
            newPaddles();
            newBall();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }

	@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Dibuja la imagen de fondo
    g.drawImage(backgroundImage, 0, 0, this);

    // Convierte a Graphics2D para manejar transparencia
    Graphics2D g2d = (Graphics2D) g;

    // Establece una capa negra con transparencia (0.0 = invisible, 1.0 = opaco)
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f)); // 0.4 = 40% opaco
    g2d.setColor(Color.BLACK);
    g2d.fillRect(0, 0, getWidth(), getHeight());

    // Restaura la opacidad total para el resto del dibujo
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

    // Dibuja los objetos del juego encima
    draw(g);
}

}

