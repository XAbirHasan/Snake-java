

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;


public class High_score extends JPanel implements ActionListener{
	
	private JButton back_button;
	private JLabel highScore_show;
	private JLabel thisPageImage;
	
	private String score = "";
	
	public High_score() {
		score = Integer.toString(Main_Application.bestScore);
		
		back_button = new JButton("back");
		highScore_show = new JLabel("High Score : " +score);
		thisPageImage = new JLabel("");
		
		setLayout(null);
		setVisible(true);
		setSize(1240,640);
		
		back_button.setBounds(480,480,200,80);
		highScore_show.setBounds(450,300,400,80);
		thisPageImage.setBounds(0, 0, 1240, 640);
		
		back_button.setFont(new Font("Chiller", Font.BOLD, 35));
		highScore_show.setFont(new Font("Chiller", Font.BOLD, 45));
		
		back_button.addActionListener(this);
		
		back_button.setBackground(new Color(251, 203, 151));
		
		highScore_show.setForeground(Color.BLACK);
		back_button.setForeground(Color.BLACK);
		
		thisPageImage.setIcon(new ImageIcon("pic\\highScore.jpg"));
		
		
		add(highScore_show);
		add(back_button);
		add(thisPageImage);
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == back_button)
		{
			
			Main_Application.highScorePage.setVisible(false);
			Main_Application.homePage.setVisible(true);
			//main_Application.main_Frame.add(home_page);
		}
	}
}
