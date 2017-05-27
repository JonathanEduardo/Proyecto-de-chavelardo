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
    
    /**
     * Constructor  de la clase enemigoB sin parametros
     *  super llamado a clase padre pasando por parametro nombre de la imagen del enemigo
     */
    public EnemigoB()
    {
        super("Lex1.png","Lex2.png","Lex3.png","Lex4.png");
    }
    
    
     /**
     * Constructor 2 
     *  super llamado a clase padre pasando por parametro nombre de la imagen del enemigo
     * @param l1 es el limite en eje de las x que indica el limite inicial donde el enemigo camina de lado a lado
     * @param l2 es el limite en eje de las x que indica el limite final donde el enemigo camina de lado a lado
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
