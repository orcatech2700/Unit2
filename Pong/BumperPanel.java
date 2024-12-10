import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class BumperPanel extends JPanel
{
    private static final int FRAME = 400;
    private static final Color BACKGROUND = new Color(0, 0, 0);
    private static final Color BALL_COLOR = Color.BLACK;
    private static final Color PRIZE_COLOR = Color.RED;
    private static final Color BUMPER_COLOR = Color.BLUE;
    private static final double BALL_DIAM = 50;
    private static final double PRIZE_DIAM = 25;
    private static final int BUMPER_WIDTH = 75;
    private static final int BUMPER_HEIGHT = 125;

    private BufferedImage myImage;
    private Graphics myBuffer;
    private Ball ball;
    private Bumper lPaddle;
    private Bumper rPaddle;
    private int leftScore;
    private int rightScore;
    private int paddleHeight = 100;
    private int paddleWidth = 20;
    private Timer timer;
    private boolean wPressed = false;
    private boolean sPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean spacePressed = false;
    private boolean gameStarted = false;
    private int deltaPM = (int) (FRAME / 40);

    private int ballColorCount = 0;
    
    private int winScore = 3;
    // 0 white
    // 1 red
    // 2 orange
    // 3 yellow
    // 4 green
    // 5 blue
    // 6 magenta
    
    
    public BumperPanel()
    {
        myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
        myBuffer = myImage.getGraphics();
        
        
        
        // create ball and jump
        ball = new Ball(100, 100, 30, Color.WHITE);
        ball.jump(FRAME, FRAME);
        ball.setdx(FRAME / 150);
        ball.setdy(FRAME / 150);
        
        
        lPaddle = new Bumper(20, (FRAME / 2) - (paddleHeight / 2), paddleWidth, paddleHeight, Color.RED);
        rPaddle = new Bumper(FRAME - 40, (FRAME / 2) - (paddleHeight / 2), paddleWidth, paddleHeight, Color.CYAN);

        // ensure ball is outside the bumper
        if (lPaddle.inBumper(ball) || rPaddle.inBumper(ball)) ball.jump(FRAME, FRAME);
        
        addMouseListener(new Mouse());
        addKeyListener(new KeyLeft());
        addKeyListener(new KeyRight());
        addKeyListener(new Key());
        setFocusable(true);
        leftScore = 0;
        rightScore = 0;
        timer = new Timer(5, new Listener());
        timer.start();
        
       
    }

    public void paintComponent(Graphics g)
    {
        g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
    }

    private class KeyLeft extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
        	if (e.getKeyCode() == KeyEvent.VK_W)
            {
            	wPressed = true;
            	sPressed = false;           	
            }
            else if (e.getKeyCode() == KeyEvent.VK_S) 
            {
            	wPressed = false;
            	sPressed = true; 
            }
            else
            {
            	wPressed = false;
            	sPressed = false;
            }
        }
    }

    private class KeyRight extends KeyAdapter
    {
    	
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
            	upPressed = true;
            	downPressed = false;           	
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) 
            {
            	upPressed = false;
            	downPressed = true; 
            }
            else if (!(e.getKeyCode() == KeyEvent.VK_UP))
            {
            	upPressed = false;
            	downPressed = false;           	
            }
            else if (!(e.getKeyCode() == KeyEvent.VK_DOWN)) 
            {
            	upPressed = false;
            	downPressed = false; 
            }
            else
            {
            	upPressed = false;
            	downPressed = false;
            }
        }
    }
    
    private class Key extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
            {
            	spacePressed = true;
            }
            else
            {
            	spacePressed = false;
            }
        }
    }
    
    private class Mouse extends MouseAdapter
    {
    	public void mouseClicked(MouseEvent e)
    	{
    		if(e.isMetaDown())
    		{
    			if(deltaPM > 10)
    				deltaPM = deltaPM - 5;
    		}
    		else if(e.isShiftDown())
    		{
    			if(ballColorCount < 6)
    			{
    				ballColorCount++;
    			}
    			else
    			{
    				ballColorCount = 0;
    			}
    			
    			// 0 white
    		    // 1 red
    		    // 2 orange
    		    // 3 yellow
    		    // 4 green
    		    // 5 blue
    		    // 6 magenta
    			
    			if(ballColorCount == 0)
    				ball.setColor(Color.WHITE);
    			if(ballColorCount == 1)
    				ball.setColor(Color.RED);
    			if(ballColorCount == 2)
    				ball.setColor(Color.ORANGE);
    			if(ballColorCount == 3)
    				ball.setColor(Color.YELLOW);
    			if(ballColorCount == 4)
    				ball.setColor(Color.GREEN);
    			if(ballColorCount == 5)
    				ball.setColor(Color.BLUE);
    			if(ballColorCount == 6)
    				ball.setColor(Color.MAGENTA);
    			
    		}
    		else
    		{
    			if(deltaPM < 100) deltaPM = deltaPM + 5;
    		}
    	}
    }
    
    private class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	
        	if(!gameStarted)
        	{
        		myBuffer.setColor(BACKGROUND);
	            myBuffer.fillRect(0, 0, FRAME, FRAME);
	            myBuffer.setColor(Color.WHITE);
	            myBuffer.setFont(new Font("Segoe UI", Font.BOLD, 70));
	            myBuffer.drawString("Pong", 115, 200);
	            myBuffer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	            myBuffer.drawString("Press SPACE to start", 115, 240);
	            if(spacePressed) gameStarted = true;
        	}
        	else
        	{
	            // clear buffer and move ball
	            myBuffer.setColor(BACKGROUND);
	            myBuffer.fillRect(0, 0, FRAME, FRAME); 
	            ball.move(FRAME, FRAME);
	
	            // check for collisions
	            
	            BumperCollision.collide(lPaddle, ball);
	            BumperCollision.collide(rPaddle, ball);
	            
	            if(leftScore >= winScore)
	            {
	            	// show message RED WINS
	            	myBuffer.setColor(BACKGROUND);
		            myBuffer.fillRect(0, 0, FRAME, FRAME); 
		            myBuffer.setColor(Color.RED);
		            myBuffer.setFont(new Font("Segoe UI", Font.BOLD, 60));
		            myBuffer.drawString("RED wins!", 50, 200);
		            myBuffer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		            myBuffer.drawString("Press SPACE to play again", 100, 240);
		            if(spacePressed)
		            {
		            	leftScore = 0;
		            	rightScore = 0;
		            }
		            repaint();
	            }
	            else if (rightScore >= winScore)
	            {
	            	// show message BLUE wins
	            	myBuffer.setColor(BACKGROUND);
		            myBuffer.fillRect(0, 0, FRAME, FRAME); 
		            myBuffer.setColor(Color.CYAN);
		            myBuffer.setFont(new Font("Segoe UI", Font.BOLD, 60));
		            myBuffer.drawString("BLUE wins!", 50, 200);
		            myBuffer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		            myBuffer.drawString("Press SPACE to play again", 100, 240);
		            if(spacePressed)
		            {
		            	leftScore = 0;
		            	rightScore = 0;
		            }
		            repaint();
	            }
	            else
	            {
	            
		            //move paddles
		            if(wPressed)
		            	if(lPaddle.getY() >= 0)
		            		lPaddle.setY(lPaddle.getY() - deltaPM);
		            
		            if(sPressed)
		            	if(lPaddle.getY() <= (FRAME - lPaddle.getHeight()))
		            		lPaddle.setY(lPaddle.getY() + deltaPM);
		            
		            if(upPressed)
		            	if(rPaddle.getY() >= 0)
		            		rPaddle.setY(rPaddle.getY() - deltaPM);
		            
		            if(downPressed)
		            	if(rPaddle.getY() <= (FRAME - rPaddle.getHeight()))
		            		rPaddle.setY(rPaddle.getY() + deltaPM);
		            
		            //check if ball is touching either side
		            
		            if(ball.getX() <= ball.getDiameter() / 2) //left side
		            {
		            	ball.setX(200);
		            	ball.setY(200);
		            	rightScore++;
		            }
		            
		            if(ball.getX() >= 398 - (ball.getDiameter() / 2)) //right side
		            {
		            	ball.setX(200);
		            	ball.setY(200);
		            	leftScore++;
		            }
		            
		            // draw ball, bumper & prize
		            ball.draw(myBuffer);
		            lPaddle.draw(myBuffer);
		            rPaddle.draw(myBuffer);
		
		            
		            // update hits on buffer
		            myBuffer.setColor(Color.BLACK);
		            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 24));
		            myBuffer.setColor(Color.RED);
		            myBuffer.drawString(String.valueOf(leftScore), 50, 25);
		            myBuffer.setColor(Color.CYAN);
		            myBuffer.drawString(String.valueOf(rightScore), FRAME - 75, FRAME - 25);
		            
		            myBuffer.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		            myBuffer.setColor(Color.WHITE);
		            myBuffer.drawString("Pong by Jack Raison, Kevin Portillo", FRAME - 280, 23);
		            
		            myBuffer.setFont(new Font("Segoe UI", Font.BOLD, 15));
		            myBuffer.drawString("Paddle Speed: " + deltaPM + "      Score to Win: " + winScore, 50, FRAME - 25);
		            repaint();
	            }
        	}        
        }
    }

    // checks to see if the ball & prize collide
    // if so, increments hits & relocates prize    
    public void collide(Ball b, Polkadot p)
    {
        // find distance between ball & prize centers
        double dist = distance(b.getX(), b.getY(), p.getX(), p.getY());

        if (dist < p.getRadius() + b.getRadius())
        {
        	p.jump(FRAME, FRAME); // relocate prize
        }
    }

    private double distance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
