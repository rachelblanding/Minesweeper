import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//How tiles when buttons are pressed
public class playGame extends JPanel{
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints lyt = new GridBagConstraints();
	JFrame frame = new JFrame();
	//this panel
	JPanel panel = new JPanel();
	JButton[][] hiddenArr;
	JButton[][] shownArr;
	int xAxis;
	int yAxis;
	Icon flag;
	Icon bomb;
	int winGame = 1;
	public playGame(JFrame frame, JPanel panel, JButton[][] hiddenArr, JButton[][] shownArr, int xx, int yy) {
		this.panel = panel;
		this.frame = frame;
		this.hiddenArr = hiddenArr;
		this.shownArr = shownArr;
		this.xAxis = xx;
		this.yAxis = yy;
		panel.setLayout(layout);
		System.out.println("iGot here");
		panel.setPreferredSize(new Dimension(150,450));
		panel.add(new JButton("idk why its now working"));
		for(int k = 0; k<xAxis; k++) {
			for(int j = 0; j< yAxis; j++) {
				int x = k;
				int y = j;
				lyt.gridx=k;
				lyt.gridy=j+1;
				//panel.add(shownArr[k][j], lyt);
				//shownArr[k][j].setVisible(false);

				//panel.add(hiddenArr[k][j], lyt);
				//shownArr[k][j].setVisible(true);
				
				shownArr[k][j].setBackground(Color.lightGray);
				
				//mouse listener
				buttonClicked(k,j);
			}
		}
		
		

	}
	public void buttonClicked(int x, int y) {
		
		hiddenArr[x][y].addMouseListener(new MouseListener() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton()==MouseEvent.BUTTON3) {
					if(hiddenArr[x][y].getIcon()==null) {
						hiddenArr[x][y].setIcon(flag);
						hiddenArr[x][y].setText("");
					}else {
						hiddenArr[x][y].setIcon(null);
						hiddenArr[x][y].setText("      ");
					}
				}else if(e.getButton()==MouseEvent.BUTTON1) {
					hiddenArr[x][y].setVisible(false);
					shownArr[x][y].setVisible(true);
					if(shownArr[x][y].getText().equals("  0  ")) {
						//--zeroNumbers(x,y,xAxis,yAxis);
						//algorithm to get all nearby zero numbers if a zero is pressed
						zeroNumbers zero = new zeroNumbers();
					}
					//End game if bomb pressed
					if(shownArr[x][y].getIcon() != null) {
						if(shownArr[x][y].getIcon().equals(bomb)) {
							shownArr[x][y].setBackground(Color.RED);
							//show all bombs
							for(int i = 0; i < xAxis; i++) {
								for(int j = 0; j < yAxis; j++) {
									
									if(shownArr[i][j].getIcon() != null) {

									if(shownArr[i][j].getIcon().equals(bomb) ) {
										
										hiddenArr[i][j].setVisible(false);
										shownArr[i][j].setVisible(true);
									}
									}
								}
							}
							//--emojiGui.setIcon(sadEmoji);
						}
					}else {
						for(int i = 0; i < xAxis; i++) {
						for(int j = 0; j < yAxis; j++) {
							if(hiddenArr[i][j].isVisible()==true) {
								//not all tiles pressed
								winGame = 0;
							}
						}
					}
						if(winGame == 1) {
							//--emojiGui.setIcon(winEmoji);
						}
						}
					//Win game if all correct pressed
					

				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
