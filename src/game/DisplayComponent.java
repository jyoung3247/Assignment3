package game;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class DisplayComponent extends JComponent {
	Player playerarray[] = new Player[5];
	int playercount = 0;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		for(int i=0; i<playerarray.length; i++) {
			if(playerarray[i] != null) {
				playerarray[i].draw(g2d);
			}
		}
	}
	public void addPlayer(Player p) {
		playerarray[playercount] = p;
		playercount ++;
	}
}
