package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;

	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private BufferedImage buffer;
	private Tool tool;
	private Color color;
	private int stroke = 1;

	public Canvas(JFrame frame) {

		setBackground(Color.WHITE);
		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();
		buffer = new BufferedImage(frame.getWidth(), frame.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		tool = new PencilTool();

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				undo.push(deepCopy());
				tool.mousePressed((Graphics2D) buffer.getGraphics(), e.getX(),
						e.getY(), stroke);
				repaint();
			}

			private BufferedImage deepCopy() {
				ColorModel cm = buffer.getColorModel();
				boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
				WritableRaster raster = buffer.copyData(buffer.getRaster()
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
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview((Graphics2D) g);

	}

	public void undo() {
		if (!undo.isEmpty()) {
			redo.push(buffer);
			buffer = undo.pop();
			repaint();
		}	}

	public void redo() {
		if (!redo.isEmpty()) {
			undo.push(buffer);
			buffer = redo.pop();
			repaint();
		}	}

	public BufferedImage getBuffer() {
		return buffer;
	}

	public void setColor(Color c) {
		color = c;
		tool.setColor(color);
	}
	
	public void setStroke(int val){
		stroke = val;
		tool.setStroke(new BasicStroke(stroke));
	}

	public void setTool(Tool newtool) {
		tool = newtool;
		tool.setColor(color);
	}
}