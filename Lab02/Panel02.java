import java.awt.*;
import javax.swing.*;

public class Panel02 extends JPanel
{
   public void paintComponent(Graphics g)
   {
      ImageIcon thomas = new ImageIcon("tj.jpg");
      
      g.setColor(Color.RED);
      g.fillRect(0, 0, 400, 400);
      g.setColor(Color.YELLOW.darker());
      
      g.fillRect(100, 50, 200, 300);
      
      int r = 11;
      for(int x = 100; x <= 300; x += 20)
      {
         g.fillOval(x - r, 50 - r, 2 * r, 2 * r);
      }
      for(int x = 100; x <= 300; x += 20)
      {
         g.fillOval(x - r, 350 - r, 2 * r, 2 * r);
      }
      for(int y = 50; y <= 350; y += 20)
      {
         g.fillOval(100 - r, y - r, 2 * r, 2 * r);
      }
      for(int y = 50; y <= 350; y += 20)
      {
         g.fillOval(300 - r, y - r, 2 * r, 2 * r);
      }
      g.drawImage(thomas.getImage(), 105, 55, 190, 290, null);
      
      g.setColor(Color.WHITE);
      g.setFont(new Font("Serif", Font.ITALIC, 30));
      g.drawString("Our Fearless Leader", 70, 390);
   }
}