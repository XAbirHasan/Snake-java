/*
 * * this is my play ground .............
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class Play_ground extends JPanel implements ActionListener,KeyListener{
	
	Random random = new Random();

	private double head_dx = ((random.nextInt(16))*40);
	private double head_dy = ((random.nextInt(13))*40); 
	private double width = 40, hight = 40; 
	
	private double []tail_dx = new double[500];
	private double []tail_dy = new double[500];
	private double tail_1_dx, tail_1_dy, next_tail_dx, next_tail_dy;
	
	private double fruit_dx = ((random.nextInt(16))*40);
	private double fruit_dy = ((random.nextInt(13))*40); 
	
	private int score = 0;   // for tail..............
	
	private int scoreShow = 0;
	private String score_show = "";

	private int game_over, left, right, up, down, move, key_move;
	
	private int gameMode;
	
	
	Timer timer = new Timer(250, this);
	
	public Play_ground() {
		left = right = up = down = 1;
		gameMode = Main_Application.mode_of_game;
		fruit();
		if(gameMode == 1)
		{
			headPosition();
		}
		
		setLayout(null);
		setSize(1240,640);
		setVisible(true);
		
		timer.stop();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(Color.black);
		
		
		Graphics2D graphics2d = (Graphics2D) g;
		
		score_show = Integer.toString(scoreShow);
		
		graphics2d.setColor(new Color(255, 255, 255));
		
		graphics2d.setFont(new Font("Chiller", Font.BOLD, 40));
		graphics2d.drawString("Score :", 1000, 270);
		
		graphics2d.setFont(new Font("Chiller", Font.BOLD, 40));
		graphics2d.drawString(score_show, 1110, 272);
		

		
		graphics2d.drawLine(962, 0, 962, 602);
		graphics2d.drawLine(0, 602, 962, 602);
		
		
		graphics2d.setColor(new Color(255, 14, 58));		// fruit .......
		graphics2d.fill(new Rectangle2D.Double(fruit_dx + 5, fruit_dy + 5, width - 10, hight -10)); 
		fruit();
		
		for (int i = 0; i < score  ; i++)            // tail .......
		{
			//System.out.println(tail_dx[i]);
			graphics2d.setColor(new Color(241, 252, 0));
			graphics2d.fill(new Rectangle2D.Double(tail_dx[i] + 3, tail_dy[i] + 3, width - 6, hight - 6));
		}
		graphics2d.setColor(new Color(241, 252, 123));
		graphics2d.fill(new Rectangle2D.Double(head_dx, head_dy, width, hight));    // head.....
		
		//System.out.println(number_of_tail);
		//System.out.println(score);
		//System.out.println(tail_dx[0]);
		
		if(gameMode == 1)  // for maze...........
		{
			graphics2d.setColor(new Color(56, 255, 225));
			graphics2d.fill(new Rectangle(0, 0, 960, 40)); 		// top........
			graphics2d.fill(new Rectangle(0, 560, 960, 40)); 	// bottom.........
			
			graphics2d.fill(new Rectangle(0, 0, 40, 600)); 		// left.....
			graphics2d.fill(new Rectangle(920, 0, 40, 600)); 	// right......
			
			graphics2d.setColor(new Color(0, 0, 0));
			
			graphics2d.drawLine(0, 0, 962, 0); 		// for outside...........
			graphics2d.drawLine(0, 1, 962, 1);    //top......
			
			graphics2d.drawLine(0, 0, 0, 600);
			graphics2d.drawLine(1, 0, 1, 600);    	// left....
			
			
			
			graphics2d.drawLine(40, 40, 920, 40);  			// for inside........
			graphics2d.drawLine(39, 39, 921, 39); 		 // up......
			
			graphics2d.drawLine(40, 40, 40, 560); 
			graphics2d.drawLine(39, 39, 39, 561);     	// left......
			
			graphics2d.drawLine(40, 560, 920, 560);
			graphics2d.drawLine(39, 561, 921, 561);    // bottom........
			
			graphics2d.drawLine(920, 40, 920, 560);    // right............
			graphics2d.drawLine(921, 39, 921, 561);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();	
		movement();
		fruit();
		tail();
		dead();
		if(game_over == 1)
		{
			timer.stop();
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent key) {
		int keyCode = key.getKeyCode();
		timer.start();
		if (game_over == 0)
		{
			if (score != 0)
			{
				key_move = 1;
				if ((keyCode == KeyEvent.VK_UP) && (up == 1))
				{
					left = 1;
					right = 1;
					up = 1;
					down = 0;
				}
				if ((keyCode == KeyEvent.VK_DOWN) && (down == 1))
				{
					left = 1;
					right = 1;
					up = 0;
					down = 1;
				}
				if ((keyCode == KeyEvent.VK_LEFT) && (left == 1))
				{
					left = 1;
					right = 0;
					up = 1;
					down = 1;
				}
				if ((keyCode == KeyEvent.VK_RIGHT) && (right == 1))
				{
					left = 0;
					right = 1;
					up = 1;
					down = 1;
				}
			}
			if (score == 0)
			{
				move = keyCode;;
				key_move = 0;
			}
			if (keyCode == KeyEvent.VK_P)
			{
				timer.stop();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
	
	}
	
	
	void movement()
	{	
		if (key_move == 1)
		{
			if (up == 1)
			{
				head_dy -= 40;						// up
			}
			if (down == 1)
			{
				head_dy += 40;					 //down
			}
			if (left == 1)
			{
				head_dx -= 40;					//left
			}
			if (right == 1)
			{
				head_dx += 40;					//right
			}
		}
		if (key_move == 0) 
		{
			if (move == KeyEvent.VK_UP)
			{
				head_dy -= 40;         // up
			}
			if (move == KeyEvent.VK_DOWN)
			{
				head_dy += 40;         //down
			}
			if (move == KeyEvent.VK_LEFT)
			{
				head_dx -= 40;       //left
			}
			if (move == KeyEvent.VK_RIGHT)
			{
				head_dx += 40;       //right;
			}
		}
		if(gameMode == 0)
		{
			if (head_dx > 920)
			{
				head_dx = 0;
			}
			if (head_dy > 560)
			{
				head_dy = 0;
			}
			if (head_dx < 0)
			{
				head_dx = 920;
			}
			if (head_dy < 0)
			{
				head_dy = 560;
			}
		}
	}
	
	void fruit()
	{
		
		if ((head_dx == fruit_dx) && (head_dy == fruit_dy))
		{
			fruit_dx = ((random.nextInt(16))*40);
			fruit_dy = ((random.nextInt(13))*40);
			
			score += 1;
			scoreShow +=10;
			if(scoreShow == 10)
			{
				score += 1;
			}
			
		}
		
		for (int i = 0; i < score; i++)
		{
			if ((tail_dx[i] == fruit_dx) && (tail_dy[i] == fruit_dy))
			{
				fruit_dx = ((random.nextInt(16))*40);
				fruit_dy = ((random.nextInt(13))*40);
			}
		}
		if(gameMode == 0)
		{
			if (fruit_dx > 920 || fruit_dy > 560 || fruit_dx < 0 || fruit_dy < 0)
			{
				fruit_dx = ((random.nextInt(16))*40);
				fruit_dy = ((random.nextInt(13))*40);
			}
			if (head_dx > 920 || head_dy > 560 || head_dx < 0 || head_dy < 0)
			{
				head_dx = ((random.nextInt(16))*40);
				head_dy = ((random.nextInt(13))*40);
			}
		}
		if(gameMode == 1)
		{
			if (fruit_dx > 910 || fruit_dy > 550 || fruit_dx < 10|| fruit_dy < 10)
			{
				fruit_dx = ((random.nextInt(16))*40);
				fruit_dy = ((random.nextInt(13))*40);
			}
		}
	}
	
	void tail()
	{
		tail_1_dx = tail_dx[0];
		tail_1_dy = tail_dy[0];
	
		tail_dx[0] = head_dx;
		tail_dy[0] = head_dy;
	
		for (int i = 1 ; i < score ; i++)
		{
			next_tail_dx = tail_dx[i];
			next_tail_dy = tail_dy[i];
	
			tail_dx[i] = tail_1_dx;
			tail_dy[i] = tail_1_dy;
	
			tail_1_dx = next_tail_dx;
			tail_1_dy = next_tail_dy;
		}
	}
	
	void dead()
	{
		for (int i = 1; i < score; i++)
		{
			if ((head_dx == tail_dx[i]) && (head_dy == tail_dy[i]))
			{
				Main_Application.score_of_game = scoreShow;
				//System.out.println(Main_Application.score_of_game);
				
				score = 0;
				game_over = 1;
				scoreShow = 0;
				left = right = up = down = 1;
				
				Main_Application.gamePage.setVisible(false);
				
				Game_Over game_Over = new Game_Over();
				
				Main_Application.gameOverPage.add(game_Over);
				Main_Application.gameOverPage.setSize(1240, 640);
				Main_Application.gameOverPage.setVisible(true);
				
			}
		}
		if(gameMode == 1)
		{
			if (head_dx > 880 || head_dy > 520 || head_dx < 40 || head_dy < 40) 
			{
				Main_Application.score_of_game = scoreShow;
				//System.out.println(Main_Application.score_of_game);
				
				score = 0;
				game_over = 1;
				scoreShow = 0;
				left = right = up = down = 1;
				Main_Application.gamePage.setVisible(false);
				
				Game_Over game_Over = new Game_Over();
				
				Main_Application.gameOverPage.add(game_Over);
				Main_Application.gameOverPage.setSize(1240, 640);
				Main_Application.gameOverPage.setVisible(true);
				
			}
			
		}
	}
	
	void headPosition()
	{
		if (head_dx > 890 || head_dy > 530 || head_dx < 30 || head_dy < 30)
		{
			head_dx = ((random.nextInt(16))*40);
			head_dy = ((random.nextInt(13))*40);
		}
	}
	
}
