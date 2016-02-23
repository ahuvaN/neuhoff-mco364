package neuhoff.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PencilTool implements Tool {

	private int x;
	private int y;
	
	@Override
	public void mousePressed(Graphics g, int x, int y, BufferedImage buffer) {
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y, BufferedImage buffer) {
		
	}

	@Override
	public void mouseDragged(Graphics g, int x, int y, BufferedImage buffer) {

		g.setColor(Color.BLACK);
		g.drawLine(this.x, this.y, x, y);
		this.x = x;
		this.y = y;
	}

	@Override
	public void drawPreview(Graphics g) {
		
	}

	

}
