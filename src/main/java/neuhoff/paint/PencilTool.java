package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class PencilTool extends Tool {

	public PencilTool(CanvasRepaintManager manager, PaintProperties prprties) {
		super(manager, prprties);
	}

	private int x1;
	private int y1;
	private Graphics2D g;

	@Override
	public void mousePressed(Graphics2D graphics, int x, int y) {
		g = graphics;
		g.setStroke(properties.getStroke());
		g.setColor(properties.getColor());
		g.fillOval(x, y, 1, 1);
		manager.repaint(x, y, x+1, y+1);
		x1 = x;
		y1 = y;
	}

	@Override
	public void mouseReleased(int x, int y) {

	}

	@Override
	public void mouseDragged(int x, int y) {

		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x, y);
		x1 = x;
		y1 = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {

	}

	public void setColor(Color c) {
		properties.setColor(c);
	}

	public void setStroke(BasicStroke stroke) {
		properties.setStroke(stroke);
	}

}
