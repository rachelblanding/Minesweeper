import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//Create the game where you an press buttons, flag buttons, create bombs and numbers for buttons
//*this method is not working, not showing this panel for some reason
public class gameArrays extends JPanel{
	int xAxis;
	int yAxis;
	int bombNumber;
	int dLevel;
	JButton[][] hiddenArr;
	JButton[][] shownArr;
	Icon bombIcon;
	Icon flag;
	
	//panel for playGame class
	JPanel playGame = new JPanel();
	//this panel
	JPanel panel = new JPanel();
	//original frame
	JFrame frame = new JFrame();
	public gameArrays(JFrame frame, JPanel panel, int difficultyNum) {
		this.panel = panel;
		this.frame = frame;
		this.dLevel = difficultyNum;
		GridBagLayout layout = new GridBagLayout();
		playGame.setLayout(layout);
		GridBagConstraints lyt = new GridBagConstraints();
		playGame.setPreferredSize(new Dimension(150,450));
		//Create the number of tiles and bombs for each difficulty level
		Arrays arr = new Arrays(difficultyNum);
		xAxis = arr.getXAxis();
		yAxis = arr.getYAxis();
		bombNumber = arr.getBombNumber();
		
		tiles tile = new tiles(xAxis,yAxis,bombNumber);
		emojis emoji = new emojis();
		bombIcon = emoji.getBombIcon();
		flag = emoji.getFlagIcon();
		
		//Create all JButtons from tiles
		for(int x = 0; x < xAxis; x++) {
			for(int y = 0; y < yAxis; y++) {
				shownArr[x][y] = new JButton(tile.getShownArr(x, y));
				hiddenArr[x][y] = new JButton(tile.getHiddenArr(x, y));
			}
		}
		for(int x= 0; x < xAxis; x++) {
			for(int y = 0; y < yAxis; y++) {
				int ax = x;
				int ay = y;
				hiddenArr[x][y].addMouseListener(new MouseListener() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
						
							//TO-DO: create timer class
							// TODO Auto-generated method stub
							if (e.getButton()==MouseEvent.BUTTON3) {
								if(hiddenArr[ax][ay].getIcon()==null) {
									hiddenArr[ax][ay].setIcon(flag);
									hiddenArr[ax][ay].setText("");
								}else {
									hiddenArr[ax][ay].setIcon(null);
									hiddenArr[ax][ay].setText("      ");
								}
							}else if(e.getButton()==MouseEvent.BUTTON1) {
								hiddenArr[ax][ay].setVisible(false);
								shownArr[ax][ay].setVisible(true);
								if(shownArr[ax][ay].getText().equals(tile.getHiddenArr(ax, ay))) {
									//TO-DO: zero numbers class
								
									//zeroNumbers(x,y,xAxis,yAxis);
								}
								//End game if bomb pressed
								if(shownArr[ax][ay].getIcon() != null) {
									if(shownArr[ax][ay].getIcon().equals(bombIcon)) {
										shownArr[ax][ay].setBackground(Color.RED);
										for(int i = 0; i < xAxis; i++) {
											for(int j = 0; j < yAxis; j++) {
												
												if(shownArr[i][j].getIcon() != null) {

												if(shownArr[i][j].getIcon().equals(bombIcon) ) {
													
													hiddenArr[i][j].setVisible(false);
													shownArr[i][j].setVisible(true);
												}
												}
											}
										}
										//TO-DO: emoji class
										//emojiGui.setIcon(sadEmoji);
									}
								}else {
									//TO-DO: win game lose game class
								
									/*for(int i = 0; i < xAxis; i++) {
									for(int j = 0; j < yAxis; j++) {
										if(hiddenArr[i][j].isVisible()==true) {
											//not all tiles pressed
											winGame = 0;
										}
									}
								}
									if(winGame == 1) {
										emojiGui.setIcon(winEmoji);
									}
									}*/
								//Win game if all correct pressed
								

							}

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

		
		panel.removeAll();
		//show clear tiles
		for(int x = 0; x < xAxis; x++) {
			for(int y = 0; y < yAxis; y++) {
				lyt.gridx = x;
				lyt.gridy = y;
				System.out.println("should add " + shownArr[x][y].getText() + " at x " + x + " and y " + y);
				playGame.add(shownArr[x][y], lyt);
				shownArr[x][y].setVisible(false);
				panel.add(hiddenArr[x][y], lyt);
				hiddenArr[x][y].setVisible(true);
			}
		}
		//frame.add(p);
		panel.setVisible(true);
		//playGame.add(new playGame(frame,panel,hiddenArr,shownArr, xAxis, yAxis));
		//frame.add(playGame);
		//playGame.setVisible(true);

	}
	public void board(int x, int y, int bomb) {
		shownArr = new JButton[x][y];
		hiddenArr = new JButton[x][y];
		//tiles tile = new tiles(x,y,bomb);
		
		bombIcon = new ImageIcon(new ImageIcon("src/download.PNG").getImage().getScaledInstance(20, 16, Image.SCALE_DEFAULT));
		//JButton Array
				for(int xx = 0; xx<x;xx++) {
					for(int yy=0;yy<y;yy++) {
						shownArr[xx][yy] = new JButton();
						hiddenArr[xx][yy] = new JButton("      ");
					}
				}
				assignBombs(x,y,bomb);
				assignTileNumbers(x,y,bomb);
				
				for(int xx = 0; xx < x; xx++) {
					for(int yy = 0; yy < y; yy++) {
						int ax = xx;
						int ay = yy;
						hiddenArr[xx][yy].addMouseListener(new MouseListener() {
						@Override
						public void mouseClicked(MouseEvent e) {
							//TO-DO: create timer class
							// TODO Auto-generated method stub
							if (e.getButton()==MouseEvent.BUTTON3) {
								if(hiddenArr[ax][ay].getIcon()==null) {
									hiddenArr[ax][ay].setIcon(flag);
									hiddenArr[ax][ay].setText("");
								}else {
									hiddenArr[ax][ay].setIcon(null);
									hiddenArr[ax][ay].setText("      ");
								}
							}else if(e.getButton()==MouseEvent.BUTTON1) {
								hiddenArr[ax][ay].setVisible(false);
								shownArr[ax][ay].setVisible(true);
								if(shownArr[ax][ay].getText().equals("  0  ")) {
									//TO-DO: zero numbers class
								
									//zeroNumbers(x,y,xAxis,yAxis);
								}
								//End game if bomb pressed
								if(shownArr[ax][ay].getIcon() != null) {
									if(shownArr[ax][ay].getIcon().equals(bombIcon)) {
										shownArr[ax][ay].setBackground(Color.RED);
										for(int i = 0; i < xAxis; i++) {
											for(int j = 0; j < yAxis; j++) {
												
												if(shownArr[i][j].getIcon() != null) {

												if(shownArr[i][j].getIcon().equals(bombIcon) ) {
													
													hiddenArr[i][j].setVisible(false);
													shownArr[i][j].setVisible(true);
												}
												}
											}
										}
										//TO-DO: emoji class
										//emojiGui.setIcon(sadEmoji);
									}
								}else {
									//TO-DO: win game lose game class
								
									/*for(int i = 0; i < xAxis; i++) {
									for(int j = 0; j < yAxis; j++) {
										if(hiddenArr[i][j].isVisible()==true) {
											//not all tiles pressed
											winGame = 0;
										}
									}
								}
									if(winGame == 1) {
										emojiGui.setIcon(winEmoji);
									}
									}*/
								//Win game if all correct pressed
								

							}

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

				

	}
	public void assignTileNumbers(int x, int y, int bomb) {
		//loop to assign numbers to tiles according to how many nearby bombs there are
				for(int numy = 0; numy < x; numy++) {
					for(int numx = 0; numx < y; numx++) {

						//make sure the tile does not already have a bomb
						if(shownArr[numx][numy].getText()!= "") {
							int bombNum=0;

							if(numx!=(x-1)) {
								if(numy!=0) {
									if(shownArr[numx+1][numy-1].getText()== "") {
										bombNum++;
									}
								}
								if(shownArr[numx+1][numy].getText()== "") {
									bombNum++;
								}
								if(numy!=(y-1)) {
									if(shownArr[numx+1][numy+1].getText()== "") {
										bombNum++;
									}
								}
							}
							if(numx!=0) {
								if(numy!=0) {
									if(shownArr[numx-1][numy-1].getText()== "") {
										bombNum++;
									}
								}
								if(shownArr[numx-1][numy].getText()== "") {
									bombNum++;
								}
								if(numy!=(y-1)) {
									if(shownArr[numx-1][numy+1].getText()== "") {
										bombNum++;
									}
								}
							}
							if(numy!=0) {
								if(shownArr[numx][numy-1].getText()== "") {
									bombNum++;
								}
							}
							if(numy!=(y-1)) {
								if(shownArr[numx][numy+1].getText()== "") {
									bombNum++;
								}
							}
							shownArr[numx][numy]=new JButton("  " + Integer.toString(bombNum) + "  ");
						}
					}
				}
	}
	public void assignBombs(int x, int y, int bomb) {
		//loop to assign bomb tiles
		for(int num = 0; num <bomb; num++) {
			int bombx = (int) Math.floor(Math.random()*x);
			int bomby = (int) Math.floor(Math.random()*y);
			if(shownArr[bombx][bomby].getText()!="") {
				shownArr[bombx][bomby] = new JButton("");
				shownArr[bombx][bomby].setIcon(bombIcon);
			}else {
				num--;
			}
		}
	}
}


