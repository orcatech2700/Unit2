	//Name______________________________ Date_____________
   import edu.fcps.Turtle;
   import java.awt.Color;
   import javax.swing.*;
    public class Driver06
   {
       public static void main(String[] args)
      {
         JFrame frame = new JFrame("Square Turtles");
         frame.setSize(400, 400);
         frame.setLocation(200, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new TurtlePanel());
         frame.setVisible(true);
         
         Turtle.setCrawl(true);     //a class method
      
         SquareTurtle a = new SquareTurtle(300, 300, 90, 100);
         a.setColor(Color.BLUE);
         a.setThickness(6);
         a.setSize(30);
         a.drawShape();
         
         for(int x = 1; x <= 4; x++)
         {
         SquareTurtle b = new SquareTurtle(500, 600, 45, 30);
         b.setColor(Color.WHITE);
         b.setThickness(4);
         b.setSize(x * 30);
         b.drawShape();
         }
         
         for(int x = 1; x <= 5; x++)
         {
         SquareTurtle c = new SquareTurtle(400, 450, x * 30, 80);
         c.setColor(Color.RED);
         c.setThickness(x * 3);
         c.setSize(x * 40);
         c.drawShape();
         }
         
         SquareTurtle d = new SquareTurtle(100, 100, 90, 50);
         d.setColor(Color.MAGENTA);
         d.setThickness(10);
         d.setSize(90);
         d.drawShape();
         
        
         /************************/
      	/*                      */
      	/* Your code goes here. */
      	/*                      */
      	/************************/
      
      }
   }