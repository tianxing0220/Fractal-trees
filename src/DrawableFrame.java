import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * A frame that shows an image that can be drawn on.
 * @author Joel
 * @version Fa2014
 */
public class DrawableFrame extends JFrame
{
	private DrawingPanel panel; //the drawing panel
	private Image image; //the image that we're currently drawing
	
	/**
	 * Make a new frame to show a given drawing
	 * @param title The title for the frame
	 * @param drawing The drawing to be displayed
	 */
	public DrawableFrame(String title, Image drawing)
	{
		super(title);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.image = drawing;
		panel = new DrawingPanel();
		panel.setPreferredSize(new Dimension(drawing.getWidth(null),drawing.getHeight(null)));
		panel.setBackground(Color.WHITE); //we draw on a white background
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);

		this.pack();
		this.setVisible(true);
	}

	/**
	 * Refreshes the displayed drawing
	 */
	public void refresh()
	{
		panel.repaint();
	}

	/**
	 * Updated the drawing by replacing it with the given image, which must have the same size as the image used to construct the frame
	 * @param drawing The new drawing to show
	 * @throws IllegalArgumentException if the given image is of a different size
	 */
	public void updateDrawing(Image drawing)
	{
		if(drawing.getWidth(null) != image.getWidth(null) || drawing.getHeight(null) != drawing.getHeight(null))
			throw new IllegalArgumentException("Given image has different size");
		
		image = drawing;
		panel.repaint();
	}
	
	/**
	 * A private inner class that contains the panel that we're drawing on.
	 * We've overwritten paintComponent to specify our own painting.
	 */
	private class DrawingPanel extends JPanel {
		public void paintComponent(Graphics g)
		{
			g.drawImage(image, 0, 0, null); //just draw the image on the canvas
		}
	}
}
