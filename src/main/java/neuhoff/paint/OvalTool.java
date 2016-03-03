package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class OvalTool implements Tool {

	private int x1, x2, y1, y2, width, height;
	private Color color;
	private Graphics2D g;
	private BasicStroke b;
	
	@Override
	public void mousePressed(Graphics2D graphics, int x, int y, int stroke) {
		g = graphics;
		b = new BasicStroke(stroke);
		g.setStroke(b);
		g.setColor(color);
		x1 = x2 = x;
		y1 = y2 = y;	
		width = height = 0;
	}

	@Override
	public void mouseReleased(int x, int y) {
		x2 = x;
		y2 = y;
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);
		g.drawOval(x1, y1, width, height);
	}

	@Override
	public void mouseDragged(int x, int y) {
		x2 = x;
		y2 = y;
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(color);
		g.setStroke(b);
		g.drawOval(x1, y1, width, height);
	}

	@Override
	public void setColor(Color c) {
		color = c;		
	}

	@Override
	public void setStroke(BasicStroke stroke) {
		b = stroke;
		g.setStroke(b);		
	}

}
