import javax.swing.*;
public class Driver12
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Lab12 - Get the Prize");
      frame.setSize(400, 400);
      frame.setLocation(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new PrizePanel());
      frame.setVisible(true);
   }
}