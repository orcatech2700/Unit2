	//Name______________________________ Date_____________
   import edu.fcps.Turtle;
   import java.awt.Color;
   import javax.swing.*;
   public class Driver08
   {
      public static void main(String[] args)
      {
      
      	JFrame frame = new JFrame("Lab08 - Flower Turtles");
         frame.setSize(400, 400);
         frame.setLocation(200, 200);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new TurtlePanel());
         frame.setVisible(true);
         
         FlowerTurtle.clearScreen();
         int size = 60;
         int startX = 100;
         int xIncr = 140;
         for(int c = 0; c <= 3; c++)
         {
            if(c == 0)
            {
               FlowerTurtle red = new FlowerTurtle(startX + (xIncr * c), size, Color.RED);
               red.drawShape();
               System.out.println("Printing RED flower");
            }
            else if(c == 1)
            {
               FlowerTurtle orange = new FlowerTurtle(startX + (xIncr * c), size, Color.ORANGE);
               orange.drawShape();
               System.out.println("Printing ORANGE flower");
            }
            else if(c == 2)
            {
               FlowerTurtle purple = new FlowerTurtle(startX + (xIncr * c), size, Color.MAGENTA.darker());
               purple.drawShape();
               System.out.println("Printing PURPLE flower");
            }
            else
            {
               FlowerTurtle yellow = new FlowerTurtle(startX + (xIncr * c), size, Color.YELLOW.darker());
               yellow.drawShape();
               System.out.println("Printing YELLOW flower");
            }
            System.out.println(c);
         }

      }
   }