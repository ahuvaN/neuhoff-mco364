package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private Canvas canvas;
	private JButton undo, redo, color, one,	two, three, four;
	private JColorChooser chooser;
	private PaintProperties properties;

	public PaintFrame() {

		setTitle("PaintFrame");
		setSize(900, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		properties = new PaintProperties(900, 700, Color.BLACK, 0,
				false, new BufferedImage(900, 800,
						BufferedImage.TYPE_INT_ARGB), new BasicStroke(1));
		chooser = new JColorChooser();
		properties.setColor(Color.BLACK);

		canvas = new Canvas(properties);
		add(canvas, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		add(panel, BorderLayout.PAGE_START);

		JPanel stroke = new JPanel();
		stroke.setLayout(new BoxLayout(stroke, BoxLayout.Y_AXIS));

		Dimension d = new Dimension(90, 100);
		
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ToolButton button = (ToolButton) event.getSource();
				canvas.setTool(button.getTool());
			}
		};
		
		ToolButton buttons[] = new ToolButton[] {
				new ToolButton(new PencilTool(properties), "/pencil.png"),
				new ToolButton(new LineTool(properties), "/line.png"),
				new ToolButton(new SquareTool(properties), "/square.png"),
				new ToolButton(new OvalTool(properties), "/circle.png"),
				new ToolButton(new BucketTool(properties), "/bucket.png"),
		};
		
		for (ToolButton button: buttons){
			panel.add(button);
			button.addActionListener(listener);
		}
		
		undo = new JButton(new ImageIcon(getClass().getResource(
				("/undo.png"))));
		undo.setPreferredSize(d);
		redo = new JButton(new ImageIcon(getClass().getResource(
				("/redo.png"))));
		redo.setPreferredSize(d);
		color = new JButton(new ImageIcon(getClass().getResource(
				("/color.png"))));
		color.setPreferredSize(d);

		d = new Dimension(90, 25);
		one = new JButton(new ImageIcon(getClass().getResource("/1.png")));
		one.setPreferredSize(d);
		two = new JButton(new ImageIcon(getClass().getResource("/2.png")));
		two.setPreferredSize(d);
		three = new JButton(new ImageIcon(getClass().getResource("/3.png")));
		three.setPreferredSize(d);
		four = new JButton(new ImageIcon(getClass().getResource("/4.png")));
		four.setPreferredSize(d);

		stroke.add(one);
		stroke.add(two);
		stroke.add(three);
		stroke.add(four);

		panel.add(undo);
		panel.add(redo);
		panel.add(color);
		panel.add(stroke);

		setVisible(true);

			
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canvas.undo();
			}
		});

		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canvas.redo();
			}
		});

		color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooser.setPreviewPanel(new JPanel());
				JColorChooser.createDialog(canvas, "Choose a background",
						false, chooser, new OKListener(), null)
						.setVisible(true);
			}
		});

		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				properties.setStroke(new BasicStroke(1));
			}
		});

		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				properties.setStroke(new BasicStroke(2));
			}
		});

		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				properties.setStroke(new BasicStroke(4));
			}
		});

		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				properties.setStroke(new BasicStroke(6));
			}
		});

	}

	@SuppressWarnings("serial")
	private class OKListener extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			properties.setColor(chooser.getColor());
		}
	}

	public static void main(String[] args) {
		new PaintFrame();
	}

}
