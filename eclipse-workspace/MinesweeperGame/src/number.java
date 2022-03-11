
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.lang.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;


public class number extends JFrame{
	protected JButton[][] boardArr;
	JButton[][] clearArr;
	JButton showBut;
	JButton clearBut;
	String clear;
	String show;
	Icon icon;
	Icon flag;
	Icon happyEmoji;
	Icon sadEmoji;
	Icon winEmoji;
	int yAxis;
	int xAxis;
	int bNumber;
	JButton easyButton;
	JButton normalButton;
	JButton hardButton;
	JButton timeNum;
	// set timer
	int timer = 0;
	int initTime = 0;
	int userWins = 0;
	//winGame will be 1 if the game is won
	int winGame = 0;




	public number(int i,GridBagLayout layout, GridBagConstraints lyt) {

		//set the layout
		setLayout(layout);
		//GridBagConstraints lyt = new GridBagConstraints();
		lyt.gridy = 0;
		lyt.gridx = 0;
		setPreferredSize(new Dimension(150,450));

		//set the title
		setTitle("MineSweeper");


		//need to only call when button is pressed
		if(i==1) {
			yAxis = 9;
			xAxis = 9;
			bNumber = 10;
		}else if(i==2) {
			yAxis = 16;
			xAxis = 16;
			bNumber = 40;
		}else if(i==3) {
			yAxis = 16;
			xAxis = 30;
			bNumber = 99;
		}
		lyt.gridx=0;
		lyt.gridy=0;
		JButton userWinGui = new JButton(Integer.toString(userWins));
		add(userWinGui, lyt);
		lyt.gridx=1;
		lyt.gridy=0;
		happyEmoji = new ImageIcon(new ImageIcon("src/happyEmoji.PNG").getImage().getScaledInstance(20, 16, Image.SCALE_DEFAULT));
		sadEmoji = new ImageIcon(new ImageIcon("src/sadEmoji.PNG").getImage().getScaledInstance(20, 16, Image.SCALE_DEFAULT));
		winEmoji = new ImageIcon(new ImageIcon("src/winEmoji.PNG").getImage().getScaledInstance(20, 16, Image.SCALE_DEFAULT));
		JButton emojiGui = new JButton();
		emojiGui.setIcon(happyEmoji);
		add(emojiGui,lyt);
		lyt.gridx=2;
		lyt.gridy=0;

		timeNum = new JButton(Integer.toString(initTime));
		add(timeNum, lyt);

		createTileNumbers(i);
		for(int k =0;k<xAxis;k++) {
			for(int j = 0; j < yAxis; j++) {
				int y = j;
				int x = k;

				lyt.gridx=k;
				lyt.gridy=j+1;


				add(clearArr[k][j], lyt);
				add(boardArr[k][j], lyt);
				boardArr[k][j].setBackground(Color.lightGray);
				//clearArr[k][j].setBackground(Color.gray);
				//clearArr[k][j].setBorder(new LineBorder(Color.darkGray));



				boardArr[k][j].setVisible(false);

				flag = new ImageIcon(new ImageIcon("src/flag.PNG").getImage().getScaledInstance(20, 16, Image.SCALE_DEFAULT));
				clearArr[k][j].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						if(timer==0) {
							time(timeNum);
							timer = 1;
						}else {

						}
						// TODO Auto-generated method stub
						if (e.getButton()==MouseEvent.BUTTON3) {
							if(clearArr[x][y].getIcon()==null) {
								clearArr[x][y].setIcon(flag);
								clearArr[x][y].setText("");
							}else {
								clearArr[x][y].setIcon(null);
								clearArr[x][y].setText("      ");
							}
						}else if(e.getButton()==MouseEvent.BUTTON1) {
							clearArr[x][y].setVisible(false);
							boardArr[x][y].setVisible(true);
							if(boardArr[x][y].getText().equals("  0  ")) {
								zeroNumbers(x,y,xAxis,yAxis);
							}
							//End game if bomb pressed
							if(boardArr[x][y].getIcon() != null) {
								if(boardArr[x][y].getIcon().equals(icon)) {
									boardArr[x][y].setBackground(Color.RED);
									for(int i = 0; i < xAxis; i++) {
										for(int j = 0; j < yAxis; j++) {
											
											if(boardArr[i][j].getIcon() != null) {

											if(boardArr[i][j].getIcon().equals(icon) ) {
												
												clearArr[i][j].setVisible(false);
												boardArr[i][j].setVisible(true);
											}
											}
										}
									}
									emojiGui.setIcon(sadEmoji);
								}
							}else {
								for(int i = 0; i < xAxis; i++) {
								for(int j = 0; j < yAxis; j++) {
									if(clearArr[i][j].isVisible()==true) {
										//not all tiles pressed
										winGame = 0;
									}
								}
							}
								if(winGame == 1) {
									emojiGui.setIcon(winEmoji);
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

	}
	public void time(JButton timeNum) {
		Timer time = new Timer();
		timeNum.setForeground(Color.RED);
		time.scheduleAtFixedRate(new TimerTask() {


			@Override
			public void run() {
				// TODO Auto-generated method stub
				initTime += 1;
				timeNum.setText(Integer.toString(initTime)); 
			}

		}, 100, 1000);

	}
	public void zeroNumbers(int x, int y, int xAxis, int yAxis) {
		//If number equals zero, algorithm to show all nearby zeros
		System.out.println("x="+x+"y="+y);
		if(x==0) {
			//do not use x-1

			if(y==0) {
				//do not use x-1 or y-1
				for(int xx = x; xx <= x+1;xx++) {
					for(int yy =y;yy <= y+1; yy++) {
						if(xx==x & yy==y) {

						}else {
							System.out.println("1xx = " + xx + " and yy =" + yy + " and is " + boardArr[xx][yy].getText());


							if(boardArr[xx][yy].isVisible()==true) {
								System.out.println("already checked here");

							}else if (boardArr[xx][yy].getText().equals("  0  ")){
								System.out.println("equals zero....... RELOOPING");
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								zeroNumbers(xx,yy,xAxis,yAxis);

							}else {
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								System.out.println("printing number.....");
							}
						}
					}
				}
			}else if (y==yAxis-1) {
				//do not use x-1 or y+1
				for(int xx = x; xx <= x+1;xx++) {
					for(int yy =y-1;yy <= y; yy++) {
						if(xx==x & yy==y) {

						}else {
							System.out.println("2xx = " + xx + " and yy =" + yy + " and is " + boardArr[xx][yy].getText());

							if(boardArr[xx][yy].isVisible()==true) {
								System.out.println("already checked here");

							}else if (boardArr[xx][yy].getText().equals("  0  ")){
								System.out.println("equals zero....... RELOOPING");
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								zeroNumbers(xx,yy,xAxis,yAxis);

							}else {
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								System.out.println("printing number.....");
							}
						}
					}
				}
			}else {
				for(int xx = x; xx <= x+1;xx++) {
					for(int yy =y-1;yy <= y+1; yy++) {
						if(xx==x & yy==y) {

						}else {
							System.out.println("3xx = " + xx + " and yy =" + yy + " and is " + boardArr[xx][yy].getText());

							if(boardArr[xx][yy].isVisible()==true) {
								System.out.println("already checked here");

							}else if (boardArr[xx][yy].getText().equals("  0  ")){
								System.out.println("equals zero....... RELOOPING");
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								zeroNumbers(xx,yy,xAxis,yAxis);

							}else {
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								System.out.println("printing number.....");
							}
						}
					}
				}
			}
		}else if (x==xAxis-1) {
			if(y==0) {
				//do not use x+1 or y-1
				for(int xx = x-1; xx <= x;xx++) {
					for(int yy =y;yy <= y+1; yy++) {
						if(xx==x & yy==y) {

						}else {
							System.out.println("4xx = " + xx + " and yy =" + yy + " and is " + boardArr[xx][yy].getText());

							if(boardArr[xx][yy].isVisible()==true) {
								System.out.println("already checked here");

							}else if (boardArr[xx][yy].getText().equals("  0  ")){
								System.out.println("equals zero....... RELOOPING");
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								zeroNumbers(xx,yy,xAxis,yAxis);

							}else {
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								System.out.println("printing number.....");
							}
						}
					}
				}
			}else if (y==yAxis-1) {
				//do not use x+1 or y+1
				for(int xx = x-1; xx <= x;xx++) {
					for(int yy =y-1;yy <= y; yy++) {
						if(xx==x & yy==y) {

						}else {
							System.out.println("5xx = " + xx + " and yy =" + yy + " and is " + boardArr[xx][yy].getText());

							if(boardArr[xx][yy].isVisible()==true) {
								System.out.println("already checked here");

							}else if (boardArr[xx][yy].getText().equals("  0  ")){
								System.out.println("equals zero....... RELOOPING");
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								zeroNumbers(xx,yy,xAxis,yAxis);

							}else {
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								System.out.println("printing number.....");
							}
						}
					}
				}
			}else {
				//do not use x+1
				for(int xx = x-1; xx <= x;xx++) {
					for(int yy =y-1;yy <= y+1; yy++) {
						if(xx==x & yy==y) {

						}else {
							System.out.println("6xx = " + xx + " and yy =" + yy + " and is " + boardArr[xx][yy].getText());

							if(boardArr[xx][yy].isVisible()==true) {
								System.out.println("already checked here");

							}else if (boardArr[xx][yy].getText().equals("  0  ")){
								System.out.println("equals zero....... RELOOPING");
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								zeroNumbers(xx,yy,xAxis,yAxis);

							}else {
								clearArr[xx][yy].setVisible(false);
								boardArr[xx][yy].setVisible(true);
								System.out.println("printing number.....");
							}
						}
					}
				}
			}
		}
		if(y==0) {
			//do not use y-1
			for(int xx = x-1; xx <= x+1;xx++) {
				for(int yy =y;yy <= y+1; yy++) {
					System.out.println("7xx = " + xx + " and yy =" + yy + " and is " + boardArr[xx][yy].getText());
					if(xx==x & yy==y) {

					}else {
						//System.out.println("7xx = " + xx + " and yy =" + yy + " and is " + boardArr[xx][yy].getText());
						System.out.println("x="+x+"y="+y);
						if(boardArr[xx][yy].isVisible()==true) {
							System.out.println("already checked here");

						}else if (boardArr[xx][yy].getText().equals("  0  ")){
							System.out.println("equals zero....... RELOOPING");
							clearArr[xx][yy].setVisible(false);
							boardArr[xx][yy].setVisible(true);
							zeroNumbers(xx,yy,xAxis,yAxis);

						}else {
							clearArr[xx][yy].setVisible(false);
							boardArr[xx][yy].setVisible(true);
							System.out.println("printing number.....");
						}
					}
				}
			}
		}else if(y==yAxis-1) {
			//do not use y+1
			for(int xx = x-1; xx <= x+1;xx++) {
				for(int yy =y-1;yy <= y; yy++) {
					if(xx==x & yy==y) {

					}else {
						System.out.println("8xx = " + xx + " and yy =" + yy + " and is " + boardArr[xx][yy].getText());

						if(boardArr[xx][yy].isVisible()==true) {
							System.out.println("already checked here");

						}else if (boardArr[xx][yy].getText().equals("  0  ")){
							System.out.println("equals zero....... RELOOPING");
							clearArr[xx][yy].setVisible(false);
							boardArr[xx][yy].setVisible(true);
							zeroNumbers(xx,yy,xAxis,yAxis);

						}else {
							clearArr[xx][yy].setVisible(false);
							boardArr[xx][yy].setVisible(true);
							System.out.println("printing number.....");
						}
					}
				}
			}
		}else {
			for(int xx = x-1; xx <= x+1;xx++) {
				for(int yy =y-1;yy <= y+1; yy++) {
					if(xx==x & yy==y) {

					}else {
						System.out.println("9xx = " + xx + " and yy =" + yy + " and is " + boardArr[xx][yy].getText());

						if(boardArr[xx][yy].isVisible()==true) {
							System.out.println("already checked here");

						}else if (boardArr[xx][yy].getText().equals("  0  ")){
							System.out.println("equals zero....... RELOOPING");
							clearArr[xx][yy].setVisible(false);
							boardArr[xx][yy].setVisible(true);
							zeroNumbers(xx,yy,xAxis,yAxis);

						}else {
							clearArr[xx][yy].setVisible(false);
							boardArr[xx][yy].setVisible(true);
							System.out.println("printing number.....");
						}
					}
				}
			}

		}

	}

	public void createTileNumbers(int i) {
		//Create the number for a non-bomb tile using the algorithm
		if(i==1) {
			createBoard(xAxis,yAxis,bNumber);
			startBoard(xAxis,yAxis,bNumber);
		}else if(i==2) {
			createBoard(xAxis,yAxis,bNumber);
			startBoard(xAxis,yAxis,bNumber);
		}else if(i==3) {
			createBoard(xAxis,yAxis,bNumber);
			startBoard(xAxis,yAxis,bNumber);
		}

		//Then assign those tiles numbers to the tiles in the tiles class
	}
	public void createBoard(int x, int y, int bomb) {
		//create the numbers that will be assigned to tiles and bombs
		boardArr = new JButton[x][y];
		icon = new ImageIcon(new ImageIcon("src/download.PNG").getImage().getScaledInstance(20, 16, Image.SCALE_DEFAULT));

		//assign all tiles to 0 originally
		for(int xx = 0; xx<x;xx++) {
			for(int yy=0;yy<y;yy++) {
				boardArr[xx][yy] = new JButton("0");
			}
		}

		//loop to assign bomb tiles
		for(int num = 0; num <bomb; num++) {
			int bombx = (int) Math.floor(Math.random()*x);
			int bomby = (int) Math.floor(Math.random()*y);
			if(boardArr[bombx][bomby].getText()!="") {
				boardArr[bombx][bomby] = new JButton("");
				boardArr[bombx][bomby].setIcon(icon);
			}else {
				num--;
			}
		}

		//loop to assign numbers to tiles according to how many nearby bombs there are
		for(int numy = 0; numy < x; numy++) {
			for(int numx = 0; numx < y; numx++) {

				//make sure the tile does not already have a bomb
				if(boardArr[numx][numy].getText()!= "") {
					int bombNum=0;

					if(numx!=(x-1)) {
						if(numy!=0) {
							if(boardArr[numx+1][numy-1].getText()== "") {
								bombNum++;
							}
						}
						if(boardArr[numx+1][numy].getText()== "") {
							bombNum++;
						}
						if(numy!=(y-1)) {
							if(boardArr[numx+1][numy+1].getText()== "") {
								bombNum++;
							}
						}
					}
					if(numx!=0) {
						if(numy!=0) {
							if(boardArr[numx-1][numy-1].getText()== "") {
								bombNum++;
							}
						}
						if(boardArr[numx-1][numy].getText()== "") {
							bombNum++;
						}
						if(numy!=(y-1)) {
							if(boardArr[numx-1][numy+1].getText()== "") {
								bombNum++;
							}
						}
					}
					if(numy!=0) {
						if(boardArr[numx][numy-1].getText()== "") {
							bombNum++;
						}
					}
					if(numy!=(y-1)) {
						if(boardArr[numx][numy+1].getText()== "") {
							bombNum++;
						}
					}
					boardArr[numx][numy]=new JButton("  " + Integer.toString(bombNum) + "  ");
				}
			}
		}
	}

	public void startBoard(int x, int y, int bomb) {
		//Create the plain gray board then have button to show number
		clearArr = new JButton[x][y];
		for(int numy = 0; numy<y; numy++) {
			for(int numx = 0; numx<x; numx++) {
				clearArr[numx][numy] = new JButton("      ");
			}
		}

	}
}
