package neuhoff.paint;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton{

	private Tool tool;
	
	public ToolButton(Tool tool, String icon){
		this.tool = tool;
		this.setIcon(new ImageIcon(getClass().getResource(
				(icon))));
		this.setPreferredSize( new Dimension(90, 100));
	}
	
	public Tool getTool(){
		return tool;
	}
}

