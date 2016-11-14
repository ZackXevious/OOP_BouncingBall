/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;

/**
 *
 * @author Zachary Kirchens
 */
public class MainWindow 
{
    public static void main(String [] args)
    {
        // TODO code application logic here
        //Run GUI in different thread than main
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new JFrame("A Bouncing Ball");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                BallWorld superBallWorld = new BallWorld();
                frame.setContentPane(superBallWorld);
                
                //Add Listener for the resizing of the window
                frame.addComponentListener(new ComponentListener() {
                    @Override
                    public void componentResized(ComponentEvent ce) {
                        superBallWorld.setHeight(frame.getHeight());
                        superBallWorld.setWidth(frame.getWidth());
                    }
                    //These do Nothing
                    @Override
                    public void componentMoved(ComponentEvent ce) {}
                    @Override
                    public void componentShown(ComponentEvent ce) {}
                    @Override
                    public void componentHidden(ComponentEvent ce) {}
                });
                frame.pack();
                frame.setVisible(true);
            }
//        });
        
    }
    
}
