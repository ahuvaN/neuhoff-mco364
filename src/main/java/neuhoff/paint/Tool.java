package neuhoff.paint;

import java.awt.Graphics2D;

public abstract class Tool {

	protected PaintProperties properties;
	
	public Tool(PaintProperties prprties){
		properties = prprties;
	}
	
	abstract void mousePressed(Graphics2D graphics, int x, int y);
	abstract void mouseReleased(int x, int y);
	abstract void mouseDragged(int x, int y);
	abstract void drawPreview(Graphics2D g);
	}
