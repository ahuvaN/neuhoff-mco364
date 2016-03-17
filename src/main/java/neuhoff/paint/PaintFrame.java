package neuhoff.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {

	@Inject
	public PaintFrame(Canvas canvas, PaintToolbar toolbar) {

		setTitle("PaintFrame");
		setSize(900, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		add(canvas, BorderLayout.CENTER);
		add(toolbar, BorderLayout.PAGE_START);
		

		setVisible(true);
	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class);
	}

}
