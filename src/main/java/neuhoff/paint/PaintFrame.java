package neuhoff.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton pencil, line, square, oval, bucket, undo, redo, color, one,
			two, three, four, prevTool, lastStroke;
	private Color clr;
	private JColorChooser chooser;
	private int strokenum;

	public PaintFrame() {

		setTitle("PaintFrame");
		setSize(900, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		chooser = new JColorChooser();
		clr = Color.BLACK;
		
		canvas = new Canvas(this);
		canvas.setColor(clr);
		add(canvas, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		add(panel, BorderLayout.PAGE_START);
		
		JPanel stroke = new JPanel();
		stroke.setLayout(new BoxLayout(stroke, BoxLayout.Y_AXIS));

		Dimension d = new Dimension(90, 100);
		prevTool = pencil = new JButton(new ImageIcon(new ImageIcon("pencil.png")
				.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		pencil.setPreferredSize(d);
		pencil.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		line = new JButton(new ImageIcon(new ImageIcon("line.png").getImage()
				.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		line.setPreferredSize(d);
		square = new JButton(new ImageIcon(new ImageIcon("square.png")
				.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		square.setPreferredSize(d);
		oval = new JButton(new ImageIcon(new ImageIcon("circle.png").getImage()
				.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		oval.setPreferredSize(d);
		bucket = new JButton(new ImageIcon(new ImageIcon("bucket.png")
				.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		bucket.setPreferredSize(d);
		undo = new JButton(new ImageIcon(new ImageIcon("undo.png").getImage()
				.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		undo.setPreferredSize(d);
		redo = new JButton(new ImageIcon(new ImageIcon("redo.png").getImage()
				.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		redo.setPreferredSize(d);
		color = new JButton(new ImageIcon(new ImageIcon("color.png").getImage()
				.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		color.setPreferredSize(d);

		d = new Dimension(90, 25);
		lastStroke = one = new JButton(new ImageIcon("1.png"));
		one.setPreferredSize(d);
		one.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		two = new JButton(new ImageIcon("2.png"));
		two.setPreferredSize(d);
		three = new JButton(new ImageIcon("3.png"));
		three.setPreferredSize(d);
		four = new JButton(new ImageIcon("4.png"));
		four.setPreferredSize(d);

		stroke.add(one);
		stroke.add(two);
		stroke.add(three);
		stroke.add(four);

		panel.add(pencil);
		panel.add(line);
		panel.add(square);
		panel.add(oval);
		panel.add(bucket);
		panel.add(undo);
		panel.add(redo);
		panel.add(color);
		panel.add(stroke);

		setVisible(true);

		pencil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new PencilTool());
				prevTool.setBorder(BorderFactory.createEmptyBorder());
				pencil.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				prevTool = pencil;
			}
		});

		line.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new LineTool());
				prevTool.setBorder(BorderFactory.createEmptyBorder());
				line.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				prevTool = line;
			}
		});

		oval.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new OvalTool());
				prevTool.setBorder(BorderFactory.createEmptyBorder());
				oval.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				prevTool = oval;
			}
		});

		square.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new SquareTool());
				prevTool.setBorder(BorderFactory.createEmptyBorder());
				square.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				prevTool = square;
			}
		});

		bucket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new BucketTool(canvas.getBuffer()));
				prevTool.setBorder(BorderFactory.createEmptyBorder());
				bucket.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				prevTool = bucket;
			}
		});

		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.undo();
			}
		});

		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.redo();
			}
		});

		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chooser.setPreviewPanel(new JPanel());
				JColorChooser.createDialog(canvas, "Choose a background", false,
						chooser, new OKListener(), null).setVisible(true);
			}
		});

		one.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setStroke(1);
				lastStroke.setBorder(BorderFactory.createEmptyBorder());
				one.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				lastStroke = one;
			}
		});
		
		two.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setStroke(2);
				lastStroke.setBorder(BorderFactory.createEmptyBorder());
				two.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				lastStroke = two;
			}
		});
		
		three.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setStroke(4);
				lastStroke.setBorder(BorderFactory.createEmptyBorder());
				three.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				lastStroke = three;
			}
		});
		
		four.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setStroke(6);
				lastStroke.setBorder(BorderFactory.createEmptyBorder());
				four.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				lastStroke = four;
			}
		});
		
	}

	@SuppressWarnings("serial")
	private class OKListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			clr = chooser.getColor();
			canvas.setColor(clr);
		}
	}

	public static void main(String[] args) {
		new PaintFrame();
	}

}
