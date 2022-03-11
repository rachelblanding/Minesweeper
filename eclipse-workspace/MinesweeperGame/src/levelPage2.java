import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class levelPage2 {
		//Buttons for the easy, medium, and hard gameplay
		JButton buttonEasy = new JButton("Easy 9X9/ 10 mines");
		JButton buttonMedium = new JButton("med 9X9/ 10 mines");
		JButton buttonHard = new JButton("hard 9X9/ 10 mines");
		//Panel for the game arrays class (create hidden buttons and shown buttons)
		JPanel game = new JPanel();
		//Panel for this class (create easy, medium, and hard gameplay)
		JPanel panel = new JPanel();
		//Original frame
		JFrame frame = new JFrame();
		//Difficulty of gameplay (button pressed)
		int difficultyNum;

}
