
public class HTree extends FractalDrawing{
	private int iter = 0;
	
	public HTree(int a, int b)
	{
		super("HTree",a,b);
	}
	public void drawFractal()
	{
		helper(250,120,300,0.5,0);
	}
	public void helper(int a, int b, int c, double d, int i)
	{
		if(i>5)
		{
			return;
		}
		drawH(a,b,c,d);
		helper((int)(a-d*(c-b)),(int)(b-d*(c-b)/2),(int)(b+d*(c-b)/2),d,i+1);
		helper((int)(a+d*(c-b)),(int)(b-d*(c-b)/2),(int)(b+d*(c-b)/2),d,i+1);
		helper((int)(a-d*(c-b)),(int)(c-d*(c-b)/2),(int)(c+d*(c-b)/2),d,i+1);
		helper((int)(a+d*(c-b)),(int)(c-d*(c-b)/2),(int)(c+d*(c-b)/2),d,i+1);
		

	}
	public void drawH(int a, int b, int c, double d)
	{
		int x1 = (int)(a-d*(c-b));
		int y1 = b;
		int z1 = (int)(a+d*(c-b));
		int y2 = c;
		
		graphics.drawLine(a,b,a,c);
		graphics.drawLine(x1, y1, z1, y1);
		graphics.drawLine(x1, y2, z1, y2); // draw the H
		
		
	}

}
