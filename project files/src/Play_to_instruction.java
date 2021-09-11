

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class Play_to_instruction extends JPanel implements ActionListener{
	
	private JLabel  instuctionPage;
	
	private JButton playGround_button;
	private JButton back_button;
	
	public Play_to_instruction() {
		
		instuctionPage = new JLabel("");
		
		playGround_button = new JButton("play");
		back_button = new JButton("back");
		
		setLayout(null);
		setVisible(true);
		setSize(1240,640);
		
		instuctionPage.setBounds(0,0,1240,640);
		
		playGround_button.setBounds(740,490,200,80);
		back_button.setBounds(300,490,200,80);
		
		playGround_button.setFont(new Font("Chiller", Font.BOLD, 35));
		back_button.setFont(new Font("Chiller", Font.BOLD, 35));
		
		playGround_button.addActionListener(this);
		back_button.addActionListener(this);
		
		instuctionPage.setIcon(new ImageIcon("pic\\instruction.jpg"));
		
		playGround_button.setBackground(new Color(251, 203, 151));
		back_button.setBackground(new Color(251, 203, 151));
		
		playGround_button.setForeground(Color.BLACK);
		back_button.setForeground(Color.BLACK);
		
		add(playGround_button);
		add(back_button);
		add(instuctionPage);
		
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == playGround_button)
		{
			Main_Application.instructonPage.setVisible(false);
			Play_ground play_ground = new Play_ground();
			
			Main_Application.gamePage.add(play_ground);
			Main_Application.gamePage.setSize(1240, 640);
			Main_Application.gamePage.setVisible(true);
		}
		if(event.getSource() == back_button)
		{
			
			Main_Application.instructonPage.setVisible(false);
			
			Main_Application.homePage.setVisible(true);
		}

	}
	
}
