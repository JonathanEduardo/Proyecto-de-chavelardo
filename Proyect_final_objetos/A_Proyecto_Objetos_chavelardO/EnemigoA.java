import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemigoA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemigoA extends Enemigo
{
     private int velX;
    private int velY = 2;
    private int l1;
    private int l2;
    private int ban;
    
    
    public EnemigoA()
    {
        super("Rocax1.png","Rocax2.png","Rocax3.png","Rocax4.png");
    }
    
     /**
     * Constructor that takes initial values for all fields
     * super llamado a clase padre pasando por parametro nombre de la imagen del enemigo
     * @param l1 es el limite en eje de las x que indica el limite inicial donde el enemigo camina de lado a lado
     * @param l2 es el limite en eje de las x que indica el limite final donde el enemigo camina de lado a lado
     */
    public EnemigoA(int l1, int l2)
    {
        super(l1,l2,"Rocax1.png","Rocax2.png","Rocax3.png","Rocax4.png");
        
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
    }    
    
  
}
