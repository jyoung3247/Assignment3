package game;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class It implements Player {
	private int x=0;
	private int y=0;
	private int stepX = 1;
	private int stepY = 1;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	

	public void move(int direction, int frameheight, int framewidth) {
		System.out.println(direction);
		if(direction == 100){
			if(y - stepY < 0) {
				
			}
			else {
				y-= stepY;
			}
		}
		if(direction == 101){
			if(y + stepY + 20 >  frameheight) {
				
			}
			else {
				y+= stepY;
			}
		}
		if(direction == 102){
			if(x - stepX <  0) {
				
			}
			else {
				x-= stepX;
			}
		}
		if(direction == 103){
			if(x + stepX + 20 >  framewidth) {
				
			}
			else {
				x+= stepX;
			}
		}
	}
	public void draw(Graphics2D g2d) {
		Shape itShape = new Ellipse2D.Double(x, y, 20, 20);
		g2d.fill(itShape);

	}

}
