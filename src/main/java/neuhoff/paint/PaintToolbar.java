package neuhoff.paint;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class PaintToolbar extends JPanel{

	private JButton undo, redo, color, one,	two, three, four;
	private JColorChooser chooser;
	private Canvas canvas;
	private PaintProperties properties;
	
	@Inject
	public PaintToolbar(Canvas cnvs, PaintProperties props){
		canvas = cnvs;
		properties = props;
		setLayout(new FlowLayout());
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
			add(button);
			button.addActionListener(listener);
		}
		chooser = new JColorChooser();

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

		add(undo);
		add(redo);
		add(color);
		add(stroke);

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
}
