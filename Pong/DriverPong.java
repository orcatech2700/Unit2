import javax.swing.*;
public class DriverPong
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Pong - Jack Raison, Kevin Portillo");
      frame.setSize(800, 800);
      frame.setLocation(200, 200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new BumperPanel());
      frame.setVisible(true);
   }
}