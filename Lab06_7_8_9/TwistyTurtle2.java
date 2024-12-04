import edu.fcps.Turtle;

public class TwistyTurtle2 extends Turtle
{  
   public void drawShape()
   {
      drawShape(0);
   }
   public void drawShape(int n)
   {
      setPenDown(true);
      if(n <= 150)
      {
         forward(n);
         turnLeft(30);
         drawShape(n + 2);
      }
   }
}