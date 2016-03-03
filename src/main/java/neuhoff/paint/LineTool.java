package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class LineTool implements Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color;
	private Graphics2D g;
	private BasicStroke b;

	@Override
	public void mousePressed(Graphics2D graphics, int x, int y, int stroke) {
		g = graphics;
		b = new BasicStroke(stroke);
		g.setStroke(b);
		g.setColor(color);
		g.fillOval(x, y, 1, 1);
		x1 = x2 = x;
		y1 = y2 = y;
	}

	@Override
	public void mouseReleased(int x, int y) {
		g.setColor(color);
		g.drawLine(x1, y1, x, y);

	}

	@Override
	public void mouseDragged(int x, int y) {
		x2 = x;
		y2 = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(color);
		g.setStroke(b);
		g.drawLine(x1, y1, x2, y2);

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
