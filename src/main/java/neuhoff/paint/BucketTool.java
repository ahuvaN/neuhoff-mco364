package neuhoff.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BucketTool implements Tool {

	private boolean[][] mark;
	private Color color;

	@Override
	public void mousePressed(Graphics g, int x, int y, BufferedImage buffer) {
		mark = new boolean[buffer.getHeight()][buffer.getWidth()];

	}

	@Override
	public void mouseReleased(Graphics g, int x, int y, BufferedImage buffer) {
		for (int row = 0; row < buffer.getHeight(); row++) {
            for (int col = 0; col < buffer.getWidth(); col++) {
                flood(buffer, row, col,
                      g.getColor(), color);	
                }
            }
	}

	@Override
	public void mouseDragged(Graphics g, int x, int y, BufferedImage buffer) {
	}

	@Override
	public void drawPreview(Graphics g) {
	}
	
	public void setColor(Color c){
		color = c;
	}

	private void flood(BufferedImage img, int row, int col,
			Color srcColor, Color tgtColor) {
		// make sure row and col are inside the image
		if (row < 0 || col < 0 || row >= img.getHeight() || col >= img.getWidth())
			return;

		// make sure this pixel hasn't been visited yet
		if (mark[row][col])
			return;

		// make sure this pixel is the right color to fill
		if (!(img.getRGB(col, row) == srcColor.getAlpha()))
			return;

		// fill pixel with target color and mark it as visited
		img.setRGB(col, row, color.getAlpha());
		mark[row][col] = true;

		// recursively fill surrounding pixels
		// (this is equivelant to depth-first search)
		flood(img, row - 1, col, srcColor, color);
		flood(img, row + 1, col, srcColor, color);
		flood(img, row, col - 1, srcColor, color);
		flood(img, row, col + 1, srcColor, color);
	}

}
