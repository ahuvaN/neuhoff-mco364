package neuhoff.paint;

import java.awt.Color;
import java.awt.Graphics;

public class SquareTool implements Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	@Override
	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.drawRect(x, x, 1, 1);
		x1 = x;
		y1 = y;	
		x2 = x;
		y2 = x;
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.drawRect(x1, y1, x, x);//(x1, y1, x, y);
		
	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		x2 = x;
		y2 = x;
	}

	@Override
	public void drawPreview(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x1, y1, x2, y2);
	}

}