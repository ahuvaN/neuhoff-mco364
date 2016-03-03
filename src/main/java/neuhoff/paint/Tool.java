package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public interface Tool {

	void mousePressed(Graphics2D graphics, int x, int y, int stroke);
	void mouseReleased(int x, int y);
	void mouseDragged(int x, int y);
	void drawPreview(Graphics2D g);
	void setColor(Color c);
	void setStroke(BasicStroke basicStroke);
}
