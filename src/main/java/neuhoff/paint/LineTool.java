package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class LineTool extends Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Graphics2D g;

	public LineTool(CanvasRepaintManager manager, PaintProperties properties){
		super(manager, properties);
	}
	@Override
	public void mousePressed(Graphics2D graphics, int x, int y) {
		g = graphics;
		g.setStroke(properties.getStroke());
		g.setColor(properties.getColor());
		g.fillOval(x, y, 1, 1);
		x1 = x2 = x;
		y1 = y2 = y;
	}

	@Override
	public void mouseReleased(int x, int y) {
		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x, y);

	}

	@Override
	public void mouseDragged(int x, int y) {
		x2 = x;
		y2 = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		g.setStroke(properties.getStroke());
		g.drawLine(x1, y1, x2, y2);

	}

	
	public void setColor(Color c) {
		properties.setColor(c);
	}

	public void setStroke(BasicStroke stroke) {
		properties.setStroke(stroke);
	}

}
