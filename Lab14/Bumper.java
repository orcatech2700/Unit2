import java.awt.*;

public class Bumper
{
    //private fields, all ints, for a Bumper
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color colour;
    //hint: the "location" of the bumper begins at its top left corner.      
    //constructors
	public Bumper()         //default constructor
    {
    	xPos = 100;
    	yPos = 100;
    	width = 100;
    	height = 100;
    	colour = Color.BLACK;
    }
    public Bumper(int x, int y, int w, int h, Color c)
    {
    	xPos = x;
    	yPos = y;
    	width = w;
    	height = h;
    	colour = c;
    }
    
    // accessor methods  (one for each field)
    public int getX() 
    { 
    	return xPos;
    }
    public int getY()      
    { 
    	return yPos;
    }
    public int getWidth() 
    { 
    	return width;
    }
    public int getHeight()
    {
    	return height;
    }
    public Color getColor() 
    { 
    	return colour;
    }
    
    // modifier methods  (one for each field)
    public void setX(int x)
    {
    	xPos = x;
    }
    public void setY(int y)
    {
    	yPos = y;
    }
    public void setWidth(int w)
    {
    	width = w;
    }
    public void setHeight(int h)
    {
    	height = h;
    }
    public void setColour(Color c)
    {
    	colour = c;
    }
    
    // instance methods
    // chooses a random (x,y) location.  Bumper stays entirely in the window.
    public void jump(int rightEdge, int bottomEdge)
    {
        // moves location to random (x, y) within the edges 
    	xPos = (int) (Math.random() * (rightEdge - width));
        yPos = (int) (Math.random() * (bottomEdge - height));
    }
      
    // draws a rectangular bumper on the buffer
    public void draw(Graphics myBuffer) 
    {
    	myBuffer.setColor(getColor());
    	myBuffer.fillRect(getX(), getY(), getWidth(), getHeight());
	}   
   	// returns true if any part of the polkadot is inside the bumper
	public boolean inBumper(Polkadot dot)
	{
    	for(int x = getX(); x <= getX() + getWidth(); x++)   //starts at upper left corner(x,y)
    	for(int y = getY(); y <= getY() + getHeight(); y++)
    	if(distance(x, y, dot.getX(), dot.getY()) <= dot.getRadius() ) //checks every point on the bumper
    	{
        	return true;
    	}
    	return false;
	}  
	// returns distance between (x1, y1) and (x2, y2)
	private double distance(double x1, double y1, double x2, double y2)
	{
    	return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}	
}
