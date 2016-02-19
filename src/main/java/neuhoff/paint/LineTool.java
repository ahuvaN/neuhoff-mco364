package neuhoff.paint;

import java.awt.Color;
import java.awt.Graphics;

public class LineTool implements Tool {

	private int x;
	private int y;
	private int x2;
	private int y2;
	
	@Override
	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;		
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.drawLine(this.x, this.y, x, y);
		
	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		x2 = x;
		y2 = y;
	}

	@Override
	public void drawPreview(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(x, y, x2, y2);
	
	}

}
