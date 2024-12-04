	//Name______________________________ Date_____________
   import edu.fcps.Turtle;
   import java.awt.Color;
   import javax.swing.*;
   public class Driver09
   {
      public static void main(String[] args)
      {
      
      	JFrame frame = new JFrame("Lab09 - Twisty Turtles");
         frame.setSize(400, 400);
         frame.setLocation(200, 200);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new TurtlePanel());
         frame.setVisible(true);
         
         
         TwistyTurtle tw1 = new TwistyTurtle();
         tw1.drawShape();
         
         TwistyTurtle2 tw2 = new TwistyTurtle2();
         tw2.drawShape();
         
         TwistyTurtle3 tw3 = new TwistyTurtle3();
         tw3.drawShape();
      }
   }