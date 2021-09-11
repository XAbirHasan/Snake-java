

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Game_Mode extends JPanel implements ActionListener {
	
	private JButton back_button;
	private JRadioButton noMaze;
	private JRadioButton maze;
	private JLabel thisPageImage;
	public Game_Mode() {
		back_button = new JButton("back");
		
		noMaze = new JRadioButton("No Maze");
		maze = new JRadioButton("Maze");
		thisPageImage = new JLabel("");
		
		setLayout(null);
		setVisible(true);
		setSize(1240,640);
		
		back_button.setBounds(530,450,200,80);
		
		noMaze.setBounds(580,150,200,80);
		maze.setBounds(580,250,200,80);
		thisPageImage.setBounds(0, 0, 1240, 640);
	
		back_button.setFont(new Font("Chiller", Font.BOLD, 35));
		noMaze.setFont(new Font("Chiller", Font.BOLD, 35));
		maze.setFont(new Font("Chiller", Font.BOLD, 35));
		
		noMaze.setForeground(Color.BLACK);
		maze.setForeground(Color.BLACK);
		back_button.setForeground(Color.BLACK);
		
		noMaze.setBackground(new Color(11,162,230));
		maze.setBackground(new Color(11,162,230));
		back_button.setBackground(new Color(251, 203, 151));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(noMaze);
		buttonGroup.add(maze);
		
		back_button.addActionListener(this);
		noMaze.addActionListener(this);
		maze.addActionListener(this);
		
		thisPageImage.setIcon(new ImageIcon("pic\\gameMode.jpg"));
		
		add(back_button);
		add(noMaze);
		add(maze);
		add(thisPageImage);
		
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == back_button)
		{
			Main_Application.modePage.setVisible(false);
			Main_Application.homePage.setVisible(true);
			//main_Application.main_Frame.add(home_page);
		}
		if (event.getSource() == noMaze) 
		{
			Main_Application.mode_of_game = 0;
			//System.out.println(Main_Application.mode_of_game);
		}
		if(event.getSource() == maze)
		{
			Main_Application.mode_of_game = 1;
			//System.out.println(Main_Application.mode_of_game);
		}
	}
}
