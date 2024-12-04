import java.awt.*;
import javax.swing.*;

public class Driver03
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Lab03 - Webbing and Sunshine");
      frame.setSize(400, 437);
      frame.setLocation(100, 50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Panel03());
      frame.setVisible(true);
   }
}