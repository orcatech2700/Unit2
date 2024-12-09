// Name: 				Date:

import java.awt.*;
   
public class Bumper
{
    //private fields, all ints, for a Bumper
    //hint: the "location" of the bumper begins at its top left corner.      
	private int xPos;
   private int yPos;
   private int width;
   private int height;
   private Color color;
   
   
     //constructors
   public Bumper()         //default constructor
   {
      xPos = 10;
      yPos = 10;
      width = 10;
      height = 10;
      color = Color.BLUE;
   }
   
   public Bumper(int x, int y, int w, int h, Color c)
   {  
      xPos = x;
      yPos = y;
      width = w;
      height = h;
      color = c;
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

   public int getHeight()
   {
      return height;
   }

   public int getWidth()
   {
      return width;
   }

   public Color getColor()
   {
      return color;
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

   public void setColor(Color c)
   {
      color = c;
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
                  return true;            
         return false;
      }  
      // returns distance between (x1, y1) and (x2, y2)
       private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }	
   }
