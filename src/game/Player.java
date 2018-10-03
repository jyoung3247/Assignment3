package game;

import java.awt.Graphics2D;

public interface Player {
	int PLAYER_UP = 100;
	int PLAYER_DOWN = 101;
	int PLAYER_LEFT = 102;
	int PLAYER_RIGHT = 103;
	
	public void draw(Graphics2D g2d);
	public void move(int direction, int frameheight, int framewidth);
}
