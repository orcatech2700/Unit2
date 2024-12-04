	//Name______________________________ Date_____________
   import edu.fcps.Turtle;
   import java.awt.Color;
   import javax.swing.*;
   public class Driver07
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("Polygon Turtles");
         frame.setSize(400, 400);
         frame.setLocation(200, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new TurtlePanel());
         frame.setVisible(true);
         
         PolygonTurtle triangle = new PolygonTurtle(100.0, 3);
         triangle.setColor(Color.RED);
         triangle.setThickness(6);
         triangle.setSize(50);
         triangle.setSides(3);
         triangle.drawShape();
         
         PolygonTurtle square = new PolygonTurtle(100.0, 3);
         square.setColor(Color.ORANGE);
         square.setThickness(6);
         square.setSize(50);
         square.setSides(4);
         square.drawShape();
         
         PolygonTurtle pentagon = new PolygonTurtle(100.0, 3);
         pentagon.setColor(Color.YELLOW);
         pentagon.setThickness(6);
         pentagon.setSize(50);
         pentagon.setSides(5);
         pentagon.drawShape();
         
         PolygonTurtle hexagon = new PolygonTurtle(100.0, 3);
         hexagon.setColor(Color.GREEN.darker());
         hexagon.setThickness(6);
         hexagon.setSize(50);
         hexagon.setSides(6);
         hexagon.drawShape();
         
         PolygonTurtle octagon = new PolygonTurtle(100.0, 3);
         octagon.setColor(Color.BLUE);
         octagon.setThickness(6);
         octagon.setSize(50);
         octagon.setSides(8);
         octagon.drawShape();
         
         PolygonTurtle decagon = new PolygonTurtle(100.0, 3);
         decagon.setColor(Color.MAGENTA);
         decagon.setThickness(6);
         decagon.setSize(50);
         decagon.setSides(10);
         decagon.drawShape();
         
      
         /************************/
      	/*                      */
      	/* Your code goes here. */
      	/*                      */
      	/************************/
      
      }
   }