package neuhoff.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;

	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private Tool tool;
	private BufferedImage img;
	private PaintProperties properties;

	public Canvas(PaintProperties props) {

		properties = props;
		setBackground(Color.WHITE);
		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();
		tool = new PencilTool(properties);

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				undo.push(deepCopy());
				tool.mousePressed((Graphics2D) properties.getImage()
						.getGraphics(), e.getX(), e.getY());
				repaint();
			}

			private BufferedImage deepCopy() {
				img = properties.getImage();
				ColorModel cm = img.getColorModel();
				boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
				WritableRaster raster = img.copyData(img.getRaster()
						.createCompatibleWritableRaster());
				return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
			}

			public void mouseReleased(MouseEvent e) {
				tool.mouseReleased(e.getX(), e.getY());
				repaint();
			}

		});

		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				tool.mouseDragged(e.getX(), e.getY());
				repaint();
			}

			public void mouseMoved(MouseEvent e) {
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		tool.drawPreview((Graphics2D) g);

	}

	public void undo() {
		if (!undo.isEmpty()) {
			redo.push(img);
			img = undo.pop();
			repaint();
		}
	}

	public void redo() {
		if (!redo.isEmpty()) {
			undo.push(img);
			img = redo.pop();
			repaint();
		}
	}

	public BufferedImage getBuffer() {
		return img;
	}

	public void setTool(Tool newtool) {
		tool = newtool;
	}

	public void setColor(Color color) {
		properties.setColor(color);
	}
}