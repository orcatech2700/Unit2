import edu.fcps.Turtle;

public class TwistyTurtle extends Turtle
{  
   public void drawShape()
   {
      drawShape(5);
   }
   public void drawShape(int n)
   {
      setPenDown(true);
      if(n <= 400)
      {
         forward(n);
         turnLeft(123);
         drawShape(n + 10);
      }
   }
}