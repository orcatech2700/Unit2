import javax.swing.*;
public class Driver14
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Lab14 - Prize with Bumper");
      frame.setSize(400, 400);
      frame.setLocation(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new BumperPanel());
      frame.setVisible(true);
   }
}