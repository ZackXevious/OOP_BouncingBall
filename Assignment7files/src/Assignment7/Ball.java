/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import java.awt.Color;

/**
 *
 * @author Zachary Kirchens
 */
public class Ball 
{
    private float ballRadius; //Ball's radius
    private float ballX; // Ball's center (x,y)
    private float ballY;
    private float ballSpeedX; //Ball's speed for x
    private float ballSpeedY; //Ball's speed for y
    private Color color;
    
    
    //Constructors--------------------------------------------------------------
    public Ball(int locX,int locY,float fRadius, float fSpeedX, float fSpeedY, Color cColor)
    {
        this.setRadius(fRadius);
        this.setX(locX);
        this.setY(locY);
        this.setSpeedX(fSpeedX);
        this.setSpeedY(fSpeedY);
        this.setColor(cColor);
    }
    
    
    //Mutators------------------------------------------------------------------
    public void setRadius(float fRadius)
    {//Sets the radius
        ballRadius=fRadius;
    }
    public void setSpeedX(float fSpeedX)
    {//Sets the speed on the X axis
        ballSpeedX=fSpeedX;
    }
    public void setSpeedY(float fSpeedY)
    {//Sets the speed on the Y axis
        ballSpeedY=fSpeedY;
    }
    public void setX(float fLocX)
    {//Sets the location on the X axis
        ballX=fLocX;
    }
    public void setY(float fLocY)
    {//Sets the location on the Y axis
        ballY=fLocY;
    }
    public void setColor(Color cColor)
    {//Sets the color of the ball
        color=cColor;
    }
    
    
    //Accessors-----------------------------------------------------------------
    public float getRadius()
    {//returns the radius of the ball
        return ballRadius;
    }
    public float getSpeedX()
    {//returns the speed of the ball on X axis
        return ballSpeedX;
    }
    public float getSpeedY()
    {//returns the speed of the ball on Y axis
        return ballSpeedY;
    }
    public float getBallX()
    {//returns the location of the ball on X axis
        return ballX;
    }
    public float getBallY()
    {//returns the location of the ball on Y axis
        return ballY;
    }
    public Color getColor()
    {//returns the color of the Ball
        return color;
    }
    
    
    //Game Specific Functions:--------------------------------------------------
    public void UpdateBall(float BOX_WIDTH, float BOX_HEIGHT)
    {//Updates the balls location on the screen
        this.setX(this.getBallX()+this.getSpeedX());
        this.setY(this.getBallY()+this.getSpeedY());
        


        //Check if the ball moves over the bounds
        //If so, adjust the position and flip the speed(s) that need to be flipped.

        //Check the X axis
        if(this.getBallX() - this.getRadius() < 1)
        {
            this.setSpeedX(-this.getSpeedX());
            this.setX(this.getRadius()+1);
        }
        else if(this.getBallX() + ballRadius > (BOX_WIDTH-1))
        {
            this.setSpeedX(-this.getSpeedX());
            this.setX(BOX_WIDTH - this.getRadius()-1);
        }

        //Check the Y axis
        if(this.getBallY() - this.getRadius() < 1)
        {
            this.setSpeedY(-this.getSpeedY());
            this.setY(this.getRadius()+1);
        }
        else if(this.getBallY() + this.getRadius() > (BOX_HEIGHT-5))
        {
            this.setSpeedY(-this.getSpeedY());
            this.setY(BOX_HEIGHT - this.getRadius()-5);
        }
    }
    
}
