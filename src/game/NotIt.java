package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class NotIt implements Player {
	private int myX;
	private int myY;
	It theIt;
	private int itX;
	private int itY;
	private Boolean tagged;
	private int stepX = 1;
	private int stepY = 1;
	
	public NotIt(int x, int y, It i) {
		myX = x;
		myY = y;
		theIt = i;
		
	}
	
	public void moveAway(int boundaryheight, int boundarywidth) {
		itX =  theIt.getX();
		itY = theIt.getY();

		if((myX + stepX + 20 > boundarywidth)|| (myX + stepX < 0)){
			stepX = -stepX;
		}
		if((myY + stepY + 20 > boundaryheight) || (myY + stepY < 0)){
			stepY = -stepY;
		}

		myX += stepX;
		myY += stepY;
		
		
	}
	public Boolean isTagged() {
		return tagged;
	}
	public void startMoving() {
		
	}
	public void stopMoving() {
		
	}
	
	
	
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		Shape myShape = new Rectangle2D.Double(myX, myY, 20, 20);
		g2d.fill(myShape);

	}

	public void move(int direction, int frameheight, int framewidth) {
		// TODO Auto-generated method stub

	}

}
