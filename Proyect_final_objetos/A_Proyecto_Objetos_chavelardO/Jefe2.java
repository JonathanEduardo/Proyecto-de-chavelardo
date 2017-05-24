import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jefe2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jefe2 extends Enemigo
{
     private int velX;
    private int velY = 2;
    private int l1;
    private int l2;
    private int ban;
    /**
     * Act - do whatever the Jefe2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Jefe2(int l1, int l2,String ima1, String ima2)
    {
        super(l1,l2,ima1,ima2,ima1,ima2);
        
        velX = 1;
        velY = 1;
        ban = 0;
    }
    
    public void act() 
    {
        super.direccion();
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
