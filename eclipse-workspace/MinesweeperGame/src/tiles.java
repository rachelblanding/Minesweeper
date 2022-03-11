import javax.swing.JButton;

public class tiles {
	private String[][] hiddenArr;
	private String[][] shownArr;

	public tiles(int x, int y, int bomb) {

		//initial numbers and spaces
		for (int xNum = 0; xNum < x; x++) {
			for (int yNum = 0; yNum < y; y++) {
				this.shownArr[xNum][yNum] = "0";
				this.hiddenArr[xNum][yNum] = "      ";
			}
		}

		//Create bombs
		for(int num = 0; num < bomb; num++) {
			int bombx = (int) Math.floor(Math.random()*x);
			int bomby = (int) Math.floor(Math.random()*y);
			if(shownArr[bombx][bomby]!="") {
				shownArr[bombx][bomby] = "";
			}else {
				num--;
			}
		}
		//loop to assign numbers to tiles according to how many nearby bombs there are
		for(int numy = 0; numy < x; numy++) {
			for(int numx = 0; numx < y; numx++) {

				//make sure the tile does not already have a bomb
				if(shownArr[numx][numy]!="") {
					int bombNum=0;

					if(numx!=(x-1)) {
						if(numy!=0) {
							if(shownArr[numx+1][numy-1] == "") {
								bombNum++;
							}
						}
						if(shownArr[numx+1][numy] == "") {
							bombNum++;
						}
						if(numy!=(y-1)) {
							if(shownArr[numx+1][numy+1] == "") {
								bombNum++;
							}
						}
					}
					if(numx!=0) {
						if(numy!=0) {
							if(shownArr[numx-1][numy-1] == "") {
								bombNum++;
							}
						}
						if(shownArr[numx-1][numy] == "") {
							bombNum++;
						}
						if(numy!=(y-1)) {
							if(shownArr[numx-1][numy+1] == "") {
								bombNum++;
							}
						}
					}
					if(numy!=0) {
						if(shownArr[numx][numy-1] == "") {
							bombNum++;
						}
					}
					if(numy!=(y-1)) {
						if(shownArr[numx][numy+1] == "") {
							bombNum++;
						}
					}
					shownArr[numx][numy]= "  " + bombNum + "  ";
				}
			}
		}

	}
	public String getShownArr(int x, int y) {
		return shownArr[x][y];
	}
	public String getHiddenArr(int x, int y) {
		return hiddenArr[x][y];
	}
	

}
