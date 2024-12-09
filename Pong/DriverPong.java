import javax.swing.JFrame;
public class DriverPong
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Pong - Jack Raison, Kevin Portillo");
      frame.setSize(400, 400);
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new BumperPanel());
      frame.setVisible(true);
   }
}