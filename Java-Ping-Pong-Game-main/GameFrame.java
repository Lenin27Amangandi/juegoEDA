import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameFrame extends  JFrame{

	GamePanel panel;  // creating object of GamePanel class 
	
	// this constructor of Gameframe class creates new GUI window using awt and swing modules
	GameFrame(){
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("--Ping Pong Game--");
		this.setResizable(false);
		this.setBackground(Color.ORANGE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
