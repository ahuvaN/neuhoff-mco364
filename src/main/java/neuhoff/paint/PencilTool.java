package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class PencilTool extends Tool {

	public PencilTool(PaintProperties prprties) {
		super(prprties);
	}

	private int x;
	private int y;
	private Graphics2D g;

	@Override
	public void mousePressed(Graphics2D graphics, int x, int y) {
		g = graphics;
		g.setStroke(properties.getStroke());
		g.setColor(properties.getColor());
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
	}

	@Override
	public void mouseReleased(int x, int y) {

	}

	@Override
	public void mouseDragged(int x, int y) {

		g.setColor(properties.getColor());
		g.drawLine(this.x, this.y, x, y);
		this.x = x;
		this.y = y;
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
