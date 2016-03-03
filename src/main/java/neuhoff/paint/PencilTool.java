package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class PencilTool implements Tool {

	private int x;
	private int y;
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
		this.x = x;
		this.y = y;
	}

	@Override
	public void mouseReleased(int x, int y) {

	}

	@Override
	public void mouseDragged(int x, int y) {

		g.setColor(color);
		g.drawLine(this.x, this.y, x, y);
		this.x = x;
		this.y = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {

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
