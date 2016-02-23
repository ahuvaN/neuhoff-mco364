package neuhoff.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public interface Tool {

	void mousePressed(Graphics g, int x, int y, BufferedImage buffer);
	void mouseReleased(Graphics g, int x, int y, BufferedImage buffer);
	void mouseDragged(Graphics g, int x, int y, BufferedImage buffer);
	void drawPreview(Graphics g);
}
