package neuhoff.paint;

import java.awt.Graphics2D;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public abstract class Tool {

	protected PaintProperties properties;
	protected CanvasRepaintManager manager;
	
	@Inject
	public Tool(CanvasRepaintManager mng, PaintProperties prprties){
		properties = prprties;
		manager = mng;
	}
	
	abstract void mousePressed(Graphics2D graphics, int x, int y);
	abstract void mouseReleased(int x, int y);
	abstract void mouseDragged(int x, int y);
	abstract void drawPreview(Graphics2D g);
	}
