import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.geom.FlatteningPathIterator;

import javax.swing.*;

public class ShowHigh extends JPanel implements ActionListener{
	
	private ImageIcon imageIcon[];
	private ImageIcon backImage;
	private Timer timer = new Timer(30, this);
	private int frame = 0;
	private JButton exit;
	
	public ShowHigh() {
		
		setLayout(null);
		setVisible(true);
		setSize(1240,640);
		
		imageIcon = new ImageIcon[50];
		backImage = new ImageIcon("pic\\gameOver.jpg");
		for(int i = 0; i<imageIcon.length ; i++)
		{
			imageIcon[i] = new ImageIcon("high\\"+ (i+1) +".jpg");
		}
		timer.start();
		
		exit = new JButton("Exit");
		exit.setBounds(850,450,200,80);
		exit.setForeground(Color.black);
		exit.setBackground(new Color(251, 203, 151));
		exit.setFont(new Font("Chiller", Font.BOLD, 35));
		exit.addActionListener(this);
		add(exit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if(e.getSource() == exit)
		{
			Main_Application.makeHigh.setVisible(false);
			
			Thanks thanks = new Thanks();
			Main_Application.makeThanks.add(thanks);
			Main_Application.makeThanks.setSize(1240,640);
			Main_Application.makeThanks.setVisible(true);
		}
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(frame>=49)
		{
			frame = 0;
		}
		frame++;
		backImage.paintIcon(this, g, 0, 0);
		imageIcon[frame].paintIcon(this, g, 445, 225);
	}
	

}
