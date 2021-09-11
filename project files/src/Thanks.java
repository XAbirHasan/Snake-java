import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class Thanks extends JPanel implements ActionListener{

	private ImageIcon imageIcon[];
	private ImageIcon backImage;
	private Timer timer = new Timer(35, this);
	private int frame = 0;
	
	public Thanks() {
		
		setLayout(null);
		setVisible(true);
		setSize(1240,640);
		
		imageIcon = new ImageIcon[111];
		backImage = new ImageIcon("thanks\\thank.jpg");
		for(int i = 0; i<imageIcon.length ; i++)
		{
			imageIcon[i] = new ImageIcon("thanks\\"+ (i+1) +".jpg");
		}
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(frame>=110)
		{
			frame = 0;
		}
		frame++;
		backImage.paintIcon(this, g, 0, 0);
		imageIcon[frame].paintIcon(this, g, 154, 0);
	}
	
}
