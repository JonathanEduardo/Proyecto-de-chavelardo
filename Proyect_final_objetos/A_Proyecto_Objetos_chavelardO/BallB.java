import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class balllllll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallB extends Ball
{
    
    public BallB()
    {
       super();
    } 
    
    /**
     * Balls will move and check if they have hit a brick or paddle or
     * one of the edges of the world
     */
    public void act() 
    {          
        super.act();
        mata();
         
    }
    
    public void mata()
    {
         MyWorld mundo = (MyWorld) getWorld(); 
        
        int i = 1;
        
       
        
        if(isTouching(Personaje.class))
            {
               removeTouching(Personaje.class);
               mundo.decrementaVidas();
               mundo.ReapareceJugador();
            }
        
        
    }
    
   
}
