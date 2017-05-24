import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Soni here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personaje extends Actor
{
    /** the amount of change in x anf y during each act */
    private int velX;
    private int velY = 2;
   
    
   /** Variables para imtercambio de imagenes*/
   private GreenfootImage imagen1;
   private GreenfootImage imagen2;
   private GreenfootImage imagen3;
   private GreenfootImage imagen4;
    //private String sound;
   
    public Personaje()
    {
        imagen1 = new GreenfootImage("Jugador1D.jpg");
        imagen2 = new GreenfootImage("Jugador2D.png");
        imagen3 = new GreenfootImage("Jugador1I.png");
        imagen4 = new GreenfootImage("Jugador2I.png");
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
    public Personaje(int theVelX, int theVelY)
    {
        imagen1 = new GreenfootImage("soni.png");
        imagen2 = new GreenfootImage("soni3.png");
        imagen1 = new GreenfootImage("soni2.png");
        imagen2 = new GreenfootImage("soni4.png");
        velX = 1;
        velY = 1;
    }
    
    /**
     * Act - do whatever the Soni wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         MyWorld mundo = (MyWorld) getWorld();
        mantenimientoPlataforma();
        jump();
        direccion();
        CreaBomba();
      
        
         if(Greenfoot.getRandomNumber(710) > 707)
                {
                   mundo.CreaVida();
                   
                }
                
           if(isTouching(Vida.class))
        {
               
                removeTouching(Vida.class);
                mundo.incrmentaVida();
        }
       
    }    
    
    public int validaBall() //envia la validacion a world
    {
        if(isTouching(BallA.class))
        {
           return 1;
        }
        
        return 0;
    }
    
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
    
    public void mantenimientoPlataforma()
    {
         if (!isTouching(PlataA.class))
        {
           setLocation(getX(), getY() + velY);
        }
    }
    
   public void jump()
    {
        if(isTouching(PlataA.class))
        {
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX(), getY() - velY-70);
            
        }
    }
    }
    
   
    public void ilucionCorrerD()
    {
        if(getImage()==imagen1)//get image regresa la imagen que esta actualmete
        {
            setImage(imagen2);
        }
        else{
           setImage(imagen1);
        }
    }
    
    public void direccion()
    {
        int dire;
        
        dire = movimiento();
         if(dire==2){
        ilucionCorrerD();
       }
        if(dire==1){
        ilucionCorrerI();
       }
    }
    
    public void ilucionCorrerI()
    {
        if(getImage()==imagen3)//get image regresa la imagen que esta actualmete
        {
            setImage(imagen4);
        }
        else{
           setImage(imagen3);
        }
    }
    
     public void CreaBomba()
    {
         MyWorld mundo = (MyWorld) getWorld();
        //setLocation(getX() + velX, getY() + velY);
        
        if( getX() >= 300 && getX()<= 490 && getY() >= 77 && getY()<= 200)
        {
            if(Greenfoot.isKeyDown("s")){
                if(Greenfoot.getRandomNumber(100) > 70)
                {
                   mundo.CreaBomba(getX(), getY());
                }
                
        }
        }
    
    }
    
  }

