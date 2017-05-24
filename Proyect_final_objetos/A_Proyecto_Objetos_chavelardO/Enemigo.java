import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Soni here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Actor
{
    /** the amount of change in x anf y during each act */
    private int velX;
    private int velY = 2;
    private int l1;
    private int l2;
    private int ban;
    
   /** Variables para imtercambio de imagenes*/
  private GreenfootImage imagen1;
   private GreenfootImage imagen2;
   private GreenfootImage imagen3;
   private GreenfootImage imagen4;
    //private String sound;
   
    public Enemigo(String i1, String i2, String i3, String i4)
    {
        imagen1 = new GreenfootImage(i1);
        imagen2 = new GreenfootImage(i2);
        imagen3 = new GreenfootImage(i3);
        imagen4 = new GreenfootImage(i4);
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
    public Enemigo(int l1, int l2,String i1, String i2, String i3, String i4)
    {
        this.l1 = l1;
        this.l2 = l2;
        imagen1 = new GreenfootImage(i1);
        imagen2 = new GreenfootImage(i2);
        imagen3 = new GreenfootImage(i3);
        imagen4 = new GreenfootImage(i4);
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
        mantenimientoPlataforma();
        direccion();
        
       
    }    
    
    public int movimiento()
    { 
        int d=0;
      
         if( getX()!=l1 && ban == 0)
        {
           move(-1);
           d=1;
           ban=0;
        }
        else{
            ban=1;
        }
        
         if( getX()!=l2 && ban == 1)
        {
           move(1);
           d=2; 
           ban = 1;
        } 
        else{
            ban=0;
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
    
    
  }


