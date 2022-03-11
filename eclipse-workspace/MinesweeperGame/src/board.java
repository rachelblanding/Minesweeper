

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author Rachel Blanding
 *@version MineSweeper game
 */
public class board extends JFrame{
	private JButton easyButton;
	private JButton normalButton;
	private JButton hardButton;
	GridBagConstraints lyt;
	GridBagLayout layout;
	
	public board() {
		
		//set the layout
		layout = new GridBagLayout();
		setLayout(layout);
		lyt = new GridBagConstraints();
		lyt.gridy = 0;
		lyt.gridx = 0;
		setPreferredSize(new Dimension(150,450));
		
		//set the title
		setTitle("MineSweeper");
		
		
		//Easy button
		easyButton = new JButton("Easy 9x9/ 10 mines");
		lyt.gridx=1;
		lyt.gridy=1;
		add(easyButton, lyt);
		easyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number easyGame = new number(1,layout,lyt);
				easyGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				easyGame.setVisible(true);
			}
		});
		//use number(1);
		
		//Normal button
		normalButton = new JButton("Normal 16x16/ 40 mines");
		lyt.gridx=1;
		lyt.gridy=2;
		add(normalButton, lyt);
		normalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number easyGame = new number(2,layout,lyt);
				easyGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				easyGame.setVisible(true);
			}
		});
		//use number(2);
		
		//Hard button
		hardButton = new JButton("Hard 16x30/ 99 mines");
		lyt.gridx=1;
		lyt.gridy=3;
		add(hardButton, lyt);
		hardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number easyGame = new number(3,layout,lyt);
				easyGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				easyGame.setVisible(true);
			}
		});
		//use number(3);
	
		//need to create actionlistener events to buttons to take it to number.java (number(1),number(2), or number(3))
		
	}

}
