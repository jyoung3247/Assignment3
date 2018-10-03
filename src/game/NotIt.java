package game;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.lang.Math;

public class NotIt implements Player {
	private int myX;
	private int myY;
	private It theIt;
	private int itX;
	private int itY;
	private Boolean tagged = false;
	private int stepX = 2;
	private int stepY = 2;
	private int xdistance;
	private int ydistance;
	
	public NotIt(int x, int y, It i) {
		myX = x;
		myY = y;
		theIt = i;
		
	}
	
	public void moveAway(int boundaryheight, int boundarywidth) {
		itX =  theIt.getX();
		itY = theIt.getY();
		xdistance = Math.abs(itX-myX);
		ydistance = Math.abs(itY-myY);	
		if((xdistance < 50)&&(ydistance < 50)) {
			if((myX + stepX + 20 > boundarywidth)|| (myX + stepX < 0)){
				stepX = -stepX;
			}
			if((myY + stepY + 20 > boundaryheight) || (myY + stepY < 0)){
				stepY = -stepY;
			}
		isTagged();
		myX += stepX;
		myY += stepY;
		}
	}
	public Boolean isTagged() {
		if((xdistance<10) && (ydistance<10)) {
			tagged = true;
		}
		return tagged;
	}
	public void startMoving() {
		
	}
	public void stopMoving() {
		
	}
	
	
	
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		if(!tagged) {
			Shape myShape = new Rectangle2D.Double(myX, myY, 20, 20);
			g2d.fill(myShape);
		}
	}

	public void move(int direction, int frameheight, int framewidth) {
		// TODO Auto-generated method stub

	}

}
