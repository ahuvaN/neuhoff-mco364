package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {

	private BufferedImage img;
	private Color color;
	private Graphics2D g;
	
	public BucketTool(BufferedImage image){
		img = image;
	}

	@Override
	public void mousePressed(Graphics2D graphics, int x, int y, int stroke) {
		int bkgd = img.getRGB(x, y);
		bucketFill(bkgd, x, y);
	}

	private void bucketFill(int bkgd, int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			x = p.getX();
			y = p.getY();
			if (x > 0 && y > 0 && x < img.getWidth() && y < img.getHeight()
					&& bkgd == img.getRGB(x, y)) {
				
				img.setRGB(x, y, color.getRGB());

				queue.add(new Point(x + 1, y));
				queue.add(new Point(x - 1, y));
				queue.add(new Point(x, y + 1));
				queue.add(new Point(x, y - 1));
			}
		}		
	}

	@Override
	public void mouseReleased(int x, int y) {
		
	}

	@Override
	public void mouseDragged(int x, int y) {
	}

	@Override
	public void drawPreview(Graphics2D g) {
	}
	
	public void setColor(Color c){
		color = c;
	}

	@Override
	public void setStroke(BasicStroke basicStroke) {
	}

	
}
