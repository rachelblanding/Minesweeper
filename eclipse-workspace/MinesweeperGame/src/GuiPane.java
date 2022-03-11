import java.awt.Color;

import javax.swing.*;

public class GuiPane extends JFrame{
	JFrame frame = new JFrame("Minesweeper");
	JPanel levelPgPanel = new JPanel();
	//JPanel panel2 = new JPanel();
	//JButton but1 = new JButton("im but 1");
	//JButton but2 = new JButton("im but 2");
	public GuiPane() {
	frame.setBackground(Color.BLACK);
	levelPgPanel.add(new levelPage(frame, levelPgPanel));
	frame.add(levelPgPanel);
	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	frame.setVisible(true);
		
		
		
		
	
		
		
	}

}
