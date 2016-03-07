package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class SquareTool extends Tool {

	public SquareTool(PaintProperties prprties) {
		super(prprties);
	}

	private int x1, x2, y1, y2, width, height;
	private Graphics2D g;

	@Override
	public void mousePressed(Graphics2D graphics, int x, int y) {
		g = graphics;
		g.setStroke(properties.getStroke());
		g.setColor(properties.getColor());
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
		g.drawRect(x1, y1, width, height);
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
		g.setColor(properties.getColor());
		g.setStroke(properties.getStroke());
		g.drawRect(x1, y1, width, height);
	}

	public void setColor(Color c) {
		properties.setColor(c);
	}

	public void setStroke(BasicStroke stroke) {
		properties.setStroke(stroke);
	}

}
