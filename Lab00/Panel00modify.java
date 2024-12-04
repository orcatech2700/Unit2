import java.awt.*;
import javax.swing.*;

public class Panel00modify extends JPanel
{
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.PINK);
        g.fillRect(0, 0, 800, 800);
        g.setFont(new Font("Serif", Font.BOLD, 50));
        g.setColor(Color.MAGENTA);
        g.drawString("Hello World!", 100, 150);
        g.setFont(new Font("Verdana", Font.ITALIC, 25));
        g.setColor(Color.BLUE);
        g.drawString("A string", 200, 250);
        g.setFont(new Font("Segoe UI", Font.PLAIN, 60));
        g.setColor(Color.ORANGE.darker());
        g.drawString("Another string", 20, 350);
        g.setFont(new Font("Monospaced", Font.BOLD, 45));
        g.setColor(Color.GREEN.darker());
        g.drawString("String 4", 500, 450);
    }
}