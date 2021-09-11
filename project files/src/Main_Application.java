import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class Main_Application {

	public static JFrame homePage = new JFrame("Home Page");
	public static JFrame instructonPage = new JFrame("Instruction page");  ////
	public static JFrame modePage = new JFrame("Game Mode");
	public static JFrame highScorePage = new JFrame("High Score");
	public static JFrame gamePage = new JFrame("Snake Game");
	public static JFrame gameOverPage = new JFrame("Game Over");
	public static JFrame makeHigh = new JFrame("HighScore");
	public static JFrame makeThanks = new JFrame("Thanks");
	
	public static int mode_of_game = 0;
	public static int score_of_game = 0;
	public static int bestScore = 0;
	public static File file;
	
	public static void main(String[] args) {
		
		file = new File("highScore.txt");
		try {
			
			Scanner inputFile = new Scanner(file);
			bestScore = inputFile.nextInt();
			//System.out.println(bestScore);
			
		} catch (FileNotFoundException e) {
			System.out.printf("Error %s\n",e);
		}
		
		Home_page home_page = new Home_page();
		homePage.add(home_page);
		homePage.setVisible(true);
		homePage.setSize(1240, 640);
		
		homePage.setResizable(false);
		instructonPage.setResizable(false);   ////
		modePage.setResizable(false);
		highScorePage.setResizable(false);
		gamePage.setResizable(false);
		gameOverPage.setResizable(false);
		makeHigh.setResizable(false);
		makeThanks.setResizable(false);
		
	}
	
}
