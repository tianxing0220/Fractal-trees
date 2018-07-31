
public class FractalTree extends FractalDrawing{
	public FractalTree(int a, int b)
	{
		super("FractalTree",a,b);
	}
	public void drawFractal()
	{
		drawTree(250,430,75,Math.PI/2,Math.PI/9,0.8,0);
	}
	public void drawTree(int x, int y, int length, double trunkAngle, double splitAngle, double ratio, int iter)
	{
		if(iter>14)
		{
			return;
		}
		if(iter==0)
		{
			int x1 = (int)(x+length*Math.cos(trunkAngle));
			int y1 = (int)(y-length*Math.sin(trunkAngle));
			graphics.drawLine(x, y, x1, y1);
			drawTree(x1,y1,length,trunkAngle,splitAngle,ratio,iter+1);
		}
		else
		{
			int x1 = (int)(x+Math.pow(ratio, iter)*length*Math.cos(trunkAngle-splitAngle));
			int y1 = (int)(y-Math.pow(ratio, iter)*length*Math.sin(trunkAngle-splitAngle));
			int x2 = (int)(x+Math.pow(ratio, iter)*length*Math.cos(trunkAngle+splitAngle));
			int y2 = (int)(y-Math.pow(ratio, iter)*length*Math.sin(trunkAngle+splitAngle));
			graphics.drawLine(x, y, x1, y1);
			graphics.drawLine(x, y, x2, y2);
			drawTree(x1,y1,length,trunkAngle-splitAngle,splitAngle,ratio,iter+1);
			drawTree(x2,y2,length,trunkAngle+splitAngle,splitAngle,ratio,iter+1);
		}
	}
}
