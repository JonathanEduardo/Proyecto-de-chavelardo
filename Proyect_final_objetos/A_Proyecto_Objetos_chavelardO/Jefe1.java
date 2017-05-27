import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jefe1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jefe1 extends Enemigo
{
      private int velX;
    private int velY = 2;
    private int l1;
    private int l2;
    private int ban;
    
    
    /**
     * constructor sin parametros
     * super llamado a clase padre pasando por parametro nombre de la imagen del enemigo
     */
    public Jefe1()
    {
        super("Jefe1-1.png","Jefe1-2.png","Jefe1-1.png","Jefe1-2.png");
    }
    
    /**
     * Constructor 2 
     * super llamado a clase padre pasando por parametro nombre de la imagen del enemigo que llega desde la clase Myworld
     * @param l1 es el limite en eje de las x que indica el limite inicial donde el enemigo camina de lado a lado
     * @param l2 es el limite en eje de las x que indica el limite final donde el enemigo camina de lado a lado
     */
    public Jefe1(int l1, int l2,String ima1, String ima2)
    {
        super(l1,l2,ima1,ima2,ima1,ima2);
        
        velX = 1;
        velY = 1;
        ban = 0;
    }
    
    /**
     * Act - do whatever the Jefe1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.direccion();
        mata();
    }    
    
    
   /**
     * Metetodo utilizado para matar a Personaje 
     * @param mundo cast para acceder a metodos de Mywordl
     */
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
