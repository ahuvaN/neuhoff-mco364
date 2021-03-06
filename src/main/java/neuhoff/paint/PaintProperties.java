package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class PaintProperties {

	private int width, height;
	private Color color;
	private int weight;
	private boolean fill;
	private BufferedImage image;
	private BasicStroke stroke;
	
@Inject
public PaintProperties() {
		this.width = 900;
		this.height = 700;
		this.color = Color.BLACK;
		this.weight = 0;
		this.fill = false;
		this.image = new BufferedImage(900, 800,
				BufferedImage.TYPE_INT_ARGB);
		this.stroke = new BasicStroke(1);
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public boolean isFill() {
		return fill;
	}
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public BasicStroke getStroke() {
		return stroke;
	}
	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}
}
