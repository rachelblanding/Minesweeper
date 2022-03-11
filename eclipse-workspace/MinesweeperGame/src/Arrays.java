
public class Arrays {
	private int xAxis;
	private int yAxis;
	private int bombNumber;
	
	public Arrays(int dLevel) {
		if(dLevel == 1) {
			this.xAxis = 9;
			this.yAxis = 9;
			this.bombNumber = 10;
		}else if(dLevel == 2) {
			this.xAxis = 16;
			this.yAxis = 16;
			this.bombNumber = 40;
		}else {
			this.xAxis = 16;
			this.yAxis = 30;
			this.bombNumber = 99;
		}
	}
	public int getXAxis() {
		return xAxis;
	}
	public int getYAxis() {
		return yAxis;
	}
	public int getBombNumber() {
		return bombNumber;
	}
	public void setXAxis(int x) {
		
	}

}
