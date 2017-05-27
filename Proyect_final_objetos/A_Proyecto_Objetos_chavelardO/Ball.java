
import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.util.List;

/**
 * A ball is an object that can hit other objects and bounce off the 
 * edges of the world (except the bottom edge).  It will bounce off of
 * a paddle as well.
 * 
 * @author Barbara Ericson Georgia Tech 
 * @version 1.0 April 6, 2007
 */
public abstract class Ball extends Actor
{
    /** the amount of change in x during each act */
    private int velX;
    private int velY = 2;
    private int cont = 0;
    
    /**
     * Constructor that takes no arguments 
     */
    public Ball()
    {
        // set velX to 1-2 or -1 to -2
        velX = Greenfoot.getRandomNumber(2) + 1;
        if (Greenfoot.getRandomNumber(2) == 0)
          { velX = -1 * velX;
            }
        //updateImage();
    }
    
    /**
     * Constructor that takes initial values for all fields
   
    
     * @param theVelX   the amount to change in X per act
     * @param theVelY   the amount to change in Y per act
     */
    public Ball(int theVelX, int theVelY)
    {
        velX = 1;
        velY = 1;
        //updateImage();
    }
    
    ///////////////////// Methods ///////////////////////////////
    
    /**
     * Balls will move and check if they have hit a brick or paddle or
     * one of the edges of the world
     */
    public void act() 
    {          
        int dire;
        int x,y;
        //dire = movimiento();
       ValidaDimencio();
       
     
        
       
    }
    
    
    /**
     * Metodo que valida el espacio en el cual se puede mover la pelotita usa las variables ancho y altura comolimites 
     */
    public void ValidaDimencio()
    {
         MyWorld mundo = (MyWorld) getWorld();
        setLocation(getX() + velX, getY() + velY);
        if(getX() == 10){
            velX=-velX;
        }
        
        if(getX() == mundo.ancho-10){
            velX=-velX;
        }
        
        if(getY() == 10){
            velY=-velY;
        }
        
        if(getY() == mundo.altura-30){
            velY=-velY;
        }

        if(isTouching(Personaje.class))
        {
            velY=-velY;
            velX=-velX;
        }
    }
    
    
    
    /**
     * Este metodo mueve la pelotita
     */
    public int movimiento()
    { 
        int d=0;
        if(Greenfoot.isKeyDown("left"))
        {
             move(-3);
             d=1;
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
             move(3);
             d=2;
        }
        return d;
    }
    
    
    /**
     * Metdodo abstracto utilizado en BallA y BallB
     */
    public abstract void mata();
}