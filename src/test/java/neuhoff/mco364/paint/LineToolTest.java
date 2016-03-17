package neuhoff.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import neuhoff.paint.LineTool;
import neuhoff.paint.PaintProperties;

import org.junit.Test;
import org.mockito.Mockito;

public class LineToolTest {

	@Test
	public void testMouseReleased(){
		
		PaintProperties p = Mockito.mock(PaintProperties.class);
		Mockito.when(p.getColor()).thenReturn(Color.RED);
		
		LineTool tool = new LineTool(p);
		Graphics2D g = Mockito.mock(Graphics2D.class);
		
		tool.mousePressed(g, 5, 5);
		tool.mouseReleased(10, 10);
		Mockito.verify(g, Mockito.atLeastOnce()).setColor(Color.RED);
		Mockito.verify(g).drawLine(5, 5, 10, 10);
		
		
	}
	
	@Test
	public void testDrawPreview(){
		PaintProperties p = Mockito.mock(PaintProperties.class);
		Mockito.when(p.getColor()).thenReturn(Color.RED);
		
		LineTool tool = new LineTool(p);
		Graphics2D g = Mockito.mock(Graphics2D.class);
		
		tool.mousePressed(g, 8, 3);
		tool.mouseDragged(7, 4);
		tool.drawPreview(g);
		
		Mockito.verify(g, Mockito.atLeastOnce()).setColor(Color.RED);
		Mockito.verify(g).drawLine(8, 3, 7, 4);
		
	}
}
