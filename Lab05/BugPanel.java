    //Torbert, e-mail: smtorbert@fcps.edu	
	 //version 6.17.2003
	 //version 11.4.09  mlbillington@fcps.edu
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
    public class BugPanel extends JPanel
   {
      private BufferedImage myImage;
      final int N = 400;
       public BugPanel()
      {
         myImage = new BufferedImage(N, N, BufferedImage.TYPE_INT_RGB);
         Graphics buffer = myImage.getGraphics();
         buffer.setColor(Color.BLUE);
         buffer.fillRect(0, 0, N, N);
         buffer.setColor(Color.YELLOW);
         
         Bug bugA = new Bug(0, 0);
         Bug bugB = new Bug(0, N);
         Bug bugC = new Bug(N, N);
         Bug bugD = new Bug(N, 0);
         
         double percent = 0.1;
         while(!bugA.sameSpot(bugB))
         {
            bugA.walkTowards(bugB, percent);
            bugB.walkTowards(bugC, percent);
            bugC.walkTowards(bugD, percent);
            bugD.walkTowards(bugA, percent);
            buffer.drawLine(bugA.getX(), bugA.getY(), bugB.getX(), bugB.getY());
            buffer.drawLine(bugB.getX(), bugB.getY(), bugC.getX(), bugC.getY());
            buffer.drawLine(bugC.getX(), bugC.getY(), bugD.getX(), bugD.getY());
            buffer.drawLine(bugD.getX(), bugD.getY(), bugA.getX(), bugA.getY());
         }
         /************************/
      	/*                      */
      	/* Your code goes here. */
      	/*                      */
      	/************************/
      }
       public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
   }