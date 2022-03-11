import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class levelPage extends JPanel{
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
	
	public levelPage(JFrame frame, JPanel panel) {
		this.panel = panel;
		this.frame = frame;
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		GridBagConstraints lyt = new GridBagConstraints();
		panel.setPreferredSize(new Dimension(150,450));
		
		//Easy button with clicked action listener
		lyt.gridy = 0;
		lyt.gridx = 0;
		panel.add(buttonEasy,lyt);
		buttonEasy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				game.add(new gameArrays(frame, panel, 1));
				lyt.gridx = 0;
				lyt.gridy = 0;
				frame.add(game);
				game.setVisible(true);
				
			}
			
		});
		
		//Medium button with clicked action listener
		lyt.gridx = 0;
		lyt.gridy = 1;
		panel.add(buttonMedium,lyt);
		buttonMedium.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				game.add(new gameArrays(frame, panel, 2));
				lyt.gridx = 0;
				lyt.gridy = 0;
				frame.add(game);
				game.setVisible(true);
				
			}
			
		});
		
		//Hard button with clicked action listener
		lyt.gridx = 0;
		lyt.gridy = 2;
		panel.add(buttonHard,lyt);
		buttonHard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				game.add(new gameArrays(frame, panel, 3));
				lyt.gridx = 0;
				lyt.gridy = 0;
				frame.add(game);
				game.setVisible(true);
				
			}
			
		});
	}
	
	

}
