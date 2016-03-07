package neuhoff.paint;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool extends Tool {

	private BufferedImage img;
	private Graphics2D g;
	
	public BucketTool(PaintProperties properties){
		super(properties);
	}

	@Override
	public void mousePressed(Graphics2D graphics, int x, int y) {
		img = properties.getImage();
		int src = img.getRGB(x, y);
		bucketFill(src, x, y);
	}

	private void bucketFill(int src, int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			x = p.getX();
			y = p.getY();
	
			if (x > 0 && y > 0 && x < properties.getWidth() && y < properties.getHeight()
					&& src == img.getRGB(x, y)) {
				
				img.setRGB(x, y, properties.getColor().getRGB());

				queue.add(new Point(x + 1, y));
				queue.add(new Point(x - 1, y));
				queue.add(new Point(x, y + 1));
				queue.add(new Point(x, y - 1));
			}
		}		
	}

	public void mouseReleased(int x, int y) {
		
	}

	public void mouseDragged(int x, int y) {
	}

	public void drawPreview(Graphics2D g) {
	}
	
}
