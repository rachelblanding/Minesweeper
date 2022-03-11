import java.awt.Image;

import javax.swing.*;

public class emojis {
	private Icon bombIcon;
	private Icon flag;
	public emojis() {
		bombIcon = new ImageIcon(new ImageIcon("src/download.PNG").getImage().getScaledInstance(20, 16, Image.SCALE_DEFAULT));
		flag = new ImageIcon(new ImageIcon("src/flag.PNG").getImage().getScaledInstance(20, 16, Image.SCALE_DEFAULT));

	}
	public Icon getBombIcon() {
		return bombIcon;
	}
	public Icon getFlagIcon() {
		return flag;
	}

}
