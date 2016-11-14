/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Zachary Kirchens
 */
public class BallWorld extends JPanel
{
    //Variables-----------------------------------------------------------------
    private int boxWidth = 640;
    private int boxHeight = 480;
    public ArrayList<Ball> Balls = new ArrayList<Ball>();//Arraylist to store all the ball objects
    private static final int UPDATE_RATE = 60;
    private boolean isPaused=false;
    Random rand=new Random();
    
    
    //Constructors--------------------------------------------------------------
    public BallWorld()
    {//Default constructor
        //Initialize the components of the frame
        initComponents();
        
        //Create the main game thread
        Thread gameThread = new Thread()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    for(Ball currBall: Balls)
                    if(!isPaused)
                    {
                        currBall.UpdateBall(boxWidth, boxHeight);
                    }
                    //Refresh the display
                    repaint();
                    
                    //Delay for timing control and gie the other threads a chance
                    try
                    {
                        Thread.sleep(1000 / UPDATE_RATE); //milliseconds
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        gameThread.start(); // Callback run()
    }
      
    
    //Mutators------------------------------------------------------------------
    public void setHeight(int iNewHeight)
    {//Set the height of the panel
        boxHeight=iNewHeight;
    }
    public void setWidth(int iNewWidth)
    {//Set the width of the panel
        boxWidth=iNewWidth;
    }
    //Accessors-----------------------------------------------------------------
    
    //Game Specific Methods-----------------------------------------------------
    public void Pause()
    {//Pauses the game and displays a little dialog box
        isPaused=true;
        JOptionPane.showMessageDialog(this,
    "Click Okay To Continue",
    "Pause Menu",
    JOptionPane.PLAIN_MESSAGE);
        isPaused=false;
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        //Draw the box
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, boxWidth, boxHeight);
        
        //Draw the ball
        for(Ball currBall: Balls)
        {
            g.setColor(currBall.getColor());
            g.fillOval(
                (int)(currBall.getBallX() - currBall.getRadius()),
                (int)(currBall.getBallY() - currBall.getRadius()),
                (int)(2 * currBall.getRadius()),
                (int)(2 * currBall.getRadius()));
        } 
    }
    
    
    //Initialization Method-----------------------------------------------------
    public void initComponents()
    {
        //Sets the default size of the window-----------------------------------
        this.setPreferredSize(new Dimension(boxWidth, boxHeight));
        
        //Add the mouse listener
        this.addMouseListener(new MouseListener()
        {
            @Override
            public void mousePressed(MouseEvent me) 
            {
                Balls.add(new Ball( me.getX(),me.getY(),
                        rand.nextFloat()*50,
                        rand.nextFloat()*10,
                        rand.nextFloat()*10,
                        new Color(
                                Math.abs(rand.nextInt()%256),
                                Math.abs(rand.nextInt()%256),
                                Math.abs(rand.nextInt()%256))));
            }
            
            //These do nothing
            @Override
            public void mouseClicked(MouseEvent me){}
            @Override
            public void mouseReleased(MouseEvent me) {}
            @Override
            public void mouseEntered(MouseEvent me) {}
            @Override
            public void mouseExited(MouseEvent me) {}
            
        });
        
        
        //Add PauseButton
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "PauseTheGame");
        this.getActionMap().put("PauseTheGame", new Action() {
            
            //Pause the game when space is pressed!
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pause();
            }
            
            //These do nothing.
            @Override
            public Object getValue(String string) {return null;}
            @Override
            public void putValue(String string, Object o) {}
            @Override
            public void setEnabled(boolean bln) {}
            @Override
            public boolean isEnabled() {return true;}
            @Override
            public void addPropertyChangeListener(PropertyChangeListener pl) {}
            @Override
            public void removePropertyChangeListener(PropertyChangeListener pl) {}
        });
    }
    
}
