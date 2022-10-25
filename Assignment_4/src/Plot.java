
public class Plot {

	//--Private fields--
	private int x, y, width, depth;
	
	
	//--Constructors--
	//Creates a default Plot with width and depth of 1.
	Plot(){
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	//Creates a Plot using the given values.
	Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//Creates a new plot given another plot.
	Plot(Plot otherPlot){
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	//--Methods--
	//Determines if the given plot is encompassed by (is contained by) this plot.
	public boolean encompasses(Plot plot) {
		int 
		topRightX = x + width, //x4
		topRightY = y + depth, //y4
		bottomLeftX = x, //x3
		bottomLeftY = y, //y3
		
		topRightPlotX = plot.getX() + plot.getWidth(), //x2
		topRightPlotY = plot.getY() + plot.getDepth(), //y2
		bottomLeftPlotX = plot.getX(), //x1
		bottomLeftPlotY = plot.getY(); //y1
		
		if((bottomLeftX <= bottomLeftPlotX) && (topRightX >= topRightPlotX) && (bottomLeftY <= bottomLeftPlotY) && (topRightY >= topRightPlotY))
			return true;
		else
			return false;
	}
	
	//Gets the width.
	public int getWidth() {
		return width;
	}
	
	//Gets the depth.
		public int getDepth() {
			return depth;
		}
	
	//Gets the x.
	public int getX() {
		return x;
	}
	
	//Gets the y.
	public int getY() {
		return y;
	}
	
	//Determines if the given plot instance is overlapped by the current plot.
	public boolean overlaps(Plot plot) {
		int 
		topRightX = x + width, //x4
		topRightY = y + depth, //y4
		bottomLeftX = x, //x3
		bottomLeftY = y, //y3
		
		topRightPlotX = plot.getX() + plot.getWidth(), //x2
		topRightPlotY = plot.getY() + plot.getDepth(), //y2
		bottomLeftPlotX = plot.getX(), //x1
		bottomLeftPlotY = plot.getY(); //y1

		if((bottomLeftPlotX < topRightX) && (bottomLeftX < topRightPlotX) && (bottomLeftPlotY < topRightY) && (bottomLeftY < topRightPlotY))
			return true;
		else return false;
	}
	
	//Sets the depth.
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	//Sets the width.
	public void setWidth(int width) {
		this.width = width;
	}
	
	//Sets the x.
	public void setX(int x) {
		this.x = x;
	}
	
	//Sets the y.
	public void setY(int y) {
		this.y = y;
	}
	
	//Represents a Plot object in the following String format.
	public String toString() {
		return String.format("%d,%d,%d,%d", x, y, width, depth);
	}
	
}
