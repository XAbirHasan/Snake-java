/*
 *  * this is game home page.........
 * 
 */

import java.awt.*;

import java.awt.event.*;
import java.text.CollationElementIterator;

import javax.swing.*;

public class Home_page extends JPanel implements ActionListener{
	
	JLabel home_background;
	
	private JButton play_button;
	private JButton mode_button;
	private JButton high_score_button;
	private JButton exit_button;
	
	
	public Home_page() {
		
		home_background = new JLabel("");
		
		play_button = new JButton("Play Game");
		mode_button = new JButton("Game Mode");
		high_score_button = new JButton("High Scores");
		exit_button = new JButton("Exit");
		
		setLayout(null);
		setVisible(true);
		setSize(1240,640);
		
		home_background.setBounds(0,0,1240,640);
		
		play_button.setBounds(800,150,200,80);
		mode_button.setBounds(800,250,200,80);
		high_score_button.setBounds(800,350,200,80);
		exit_button.setBounds(800,450,200,80);
		
		play_button.setFont(new Font("Chiller", Font.BOLD, 35));
		mode_button.setFont(new Font("Chiller", Font.BOLD, 30));
		high_score_button.setFont(new Font("Chiller", Font.BOLD, 30));
		exit_button.setFont(new Font("Chiller", Font.BOLD, 30));
		
		play_button.addActionListener(this);
		mode_button.addActionListener(this);
		high_score_button.addActionListener(this);
		exit_button.addActionListener(this);
		
		home_background.setIcon(new ImageIcon("pic\\homePage.jpg"));
		play_button.setBackground(new Color(251, 203, 151));
		mode_button.setBackground(new Color(251, 203, 151));
		high_score_button.setBackground(new Color(251, 203, 151));
		exit_button.setBackground(new Color(251, 203, 151));
		
		play_button.setForeground(Color.BLACK);
		mode_button.setForeground(Color.BLACK);
		high_score_button.setForeground(Color.BLACK);
		exit_button.setForeground(Color.BLACK);
		
		add(play_button);
		add(mode_button);
		add(high_score_button);
		add(exit_button);
		add(home_background);
	
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == play_button)
		{
			Main_Application.homePage.setVisible(false);

			Play_to_instruction play_to_instruction = new Play_to_instruction();
			
			Main_Application.instructonPage.add(play_to_instruction);
			Main_Application.instructonPage.setSize(1240, 640);
			Main_Application.instructonPage.setVisible(true);
			
		}
		if(event.getSource() == mode_button)
		{
			Main_Application.homePage.setVisible(false);
			
			Game_Mode game_Mode = new Game_Mode();
			
			Main_Application.modePage.add(game_Mode);
			Main_Application.modePage.setSize(1240, 640);
			Main_Application.modePage.setVisible(true);
			
		}
		if(event.getSource() == high_score_button)
		{
			Main_Application.homePage.setVisible(false);
			High_score high_score = new High_score();
			
			Main_Application.highScorePage.add(high_score);
			Main_Application.highScorePage.setSize(1240, 640);
			Main_Application.highScorePage.setVisible(true);
			
		}
		if(event.getSource() == exit_button)
		{
			Main_Application.homePage.setVisible(false);
			
			Thanks thanks = new Thanks();
			Main_Application.makeThanks.add(thanks);
			Main_Application.makeThanks.setSize(1240,640);
			Main_Application.makeThanks.setVisible(true);
		}
	}
	

}
