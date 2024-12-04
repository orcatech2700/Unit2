import java.awt.*;
import javax.swing.*;

public class Panel01 extends JPanel
{
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 400, 400);
        g.setColor(Color.GREEN.darker());
        g.fillRect(0, 350, 400, 50);
        g.setColor(Color.PINK);
        g.fillRect(100, 200, 150, 150);
        g.setColor(Color.BLACK);
        g.drawRect(100, 200, 150, 150);
        g.fillRect(150, 275, 50, 75);
        int xPoints[] = {75, 175, 275};
        int yPoints[] = {200, 150, 200};
        g.setColor(Color.GRAY.brighter());
        g.fillPolygon(xPoints, yPoints, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 3);
        g.setColor(new Color(120, 196, 235));
        g.fillRect(150, 210, 23, 23);
        g.fillRect(178, 210, 23, 23);
        g.fillRect(150, 237, 23, 23);
        g.fillRect(178, 237, 23, 23);
        
        g.setFont(new Font("Segoe UI", Font.BOLD, 30));
        g.setColor(Color.WHITE);
        g.drawString("Welcome Home!", 40, 40);
        g.setColor(Color.YELLOW.brighter());
        g.fillOval(300, 75, 50, 50);
        g.setColor(Color.WHITE);
        for(int x = 0; x <= 400; x += 20)
        {
            g.fillRect(x, 290, 5, 60);
        }
        g.fillRect(0, 300, 400, 5);
        g.fillRect(0, 340, 400, 5);
        
        for(int x = 0; x <= 400; x += 90)
        {
            g.fillOval(x, 100, 80, 50);
            g.fillOval(x+7, 90, 50, 50);
        }
    }
}