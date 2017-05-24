import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemigoA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemigoB extends Enemigo
{
     private int velX;
    private int velY = 2;
    private int l1;
    private int l2;
    private int ban;
    
    
    public EnemigoB()
    {
        super("Lex1.png","Lex2.png","Lex3.png","Lex4.png");
    }
    
     /**
     * Constructor that takes initial values for all fields
     * @param theVelX   the amount to change in X per act
     * @param theVelY   the amount to change in Y per act
     */
    public EnemigoB(int l1, int l2)
    {
        super(l1,l2,"Lex1.png","Lex2.png","Lex3.png","Lex4.png");
        
        velX = 1;
        velY = 1;
        ban = 0;
    }
    
    /**
     * Act - do whatever the Soni wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
