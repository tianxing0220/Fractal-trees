import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * An abstract class to serve as a basis for drawing fractals.
 * Defines the methods used to display the fractals.
 * 
 * @author Joel
 * @version Fa2014
 */
public abstract class FractalDrawing
{
	private DrawableFrame frame; //what we're using to display the drawing
	private BufferedImage fractalImage; //an image that can be drawn on
	/**
	 * The graphics object of the image that we're drawing (used for redrawing)
	 */
	protected Graphics2D graphics;
	/**
	 * The width and height of the drawing.
	 */
	protected int width, height;
	
	/**
	 * Constructs a new FractalDrawing object. This constructor should be called by all subclasses in order to properly initialize the drawing
	 * @param title The name of the drawing (to be shown on the display frame)
	 * @param width The width of the fractal to draw
	 * @param height The height of the fractal to draw
	 */
	public FractalDrawing(String title, int width, int height)
	{
		this.width = width; //make instance variable
		this.height = height;
		fractalImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		graphics = fractalImage.createGraphics();
		frame = new DrawableFrame(title, fractalImage);
		clearDrawing(); //clear the image
		frame.refresh(); //show cleared image

		drawFractal(); //and start drawing!
		showFractal(); //show the fractal when it's done
	}

	/**
	 * An abstract method that draws the fractal on the graphics context. Note that this method is also called by the constructor
	 */
	public abstract void drawFractal();

	/**
	 * Clears the drawing canvas (resets it to white)
	 */
	public void clearDrawing()
	{
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.BLACK);
		frame.refresh();
	}
	
	/**
	 * Shows the current fractal drawing on the canvas
	 */
	public void showFractal()
	{
		frame.refresh();
	}

	/**
	 * A "pause" function for use in slowing down drawing (so that you can see the growth). This method shows the current drawing after the pause ends.
	 * @param milliseconds The number of milliseconds to wait
	 */
	public void wait(int milliseconds)
	{
        try{
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e){
            // ignoring exception at the moment (since we don't have multithreading that will interrupt)
        }

        frame.refresh();
	}
}
