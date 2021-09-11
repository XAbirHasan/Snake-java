import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class Game_Over extends JPanel implements ActionListener{
	
	private JLabel gameOver;
	private JLabel showScore;
	private JButton exit;
	private boolean gotoHigh = false;
	
	public Game_Over() {
		gameOver = new JLabel("");
		showScore = new JLabel("Your Score : " + Main_Application.score_of_game);
		exit = new JButton("Exit");
		
		setLayout(null);
		setVisible(true);
		setSize(1240,640);
		
		gameOver.setBounds(0,0,1240,640);
		showScore.setBounds(500,250,500,80);
		exit.setBounds(850,450,200,80);
		
		showScore.setForeground(Color.white);
		exit.setForeground(Color.black);
		
		exit.setBackground(new Color(251, 203, 151));
		
		exit.setFont(new Font("Chiller", Font.BOLD, 35));
		showScore.setFont(new Font("Chiller", Font.BOLD, 45));
		gameOver.setIcon(new ImageIcon("pic\\gameOver.jpg"));
		
		exit.addActionListener(this);
		
		add(exit);
		add(showScore);
		add(gameOver);
		if(Main_Application.bestScore<Main_Application.score_of_game)
		{
			try {
				
				PrintWriter printFile = new PrintWriter(Main_Application.file);
				
				printFile.print(Main_Application.score_of_game);
				printFile.close();
				gotoHigh = true;
				
			} catch (IOException e) {
				
				System.out.printf("Error %s\n",e);
			}

		}	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
		{
			if(gotoHigh == true)
			{
				Main_Application.gameOverPage.setVisible(false);
				
				ShowHigh showHigh = new ShowHigh();
				
				Main_Application.makeHigh.add(showHigh);
				Main_Application.makeHigh.setSize(1240, 640);
				Main_Application.makeHigh.setVisible(true);
			}
			else {
				Main_Application.gameOverPage.setVisible(false);
				
				Thanks thanks = new Thanks();
				Main_Application.makeThanks.add(thanks);
				Main_Application.makeThanks.setSize(1240,640);
				Main_Application.makeThanks.setVisible(true);
			}
		}
		
	}
}
