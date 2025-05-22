package GUI;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameFrame extends  JFrame{

	GamePanel panel;
	
	public GameFrame(){
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("--Ping Pong Game--");
		this.setResizable(false);
		this.setBackground(Color.GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
