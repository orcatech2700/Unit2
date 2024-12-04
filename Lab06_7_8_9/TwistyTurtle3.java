import edu.fcps.Turtle;

public class TwistyTurtle3 extends Turtle
{  
   public void drawShape()
   {
      drawShape(25);
   }
   public void drawShape(int n)
   {
      setPenDown(true);
      if(n <= 150)
      {
         setPenDown(true);
         for(int x = 0; x <= 3; x++)
         {
            forward(n);
            turnLeft(90);
         }
         turnLeft(45);
         drawShape(n + 5);
      }
   }
}