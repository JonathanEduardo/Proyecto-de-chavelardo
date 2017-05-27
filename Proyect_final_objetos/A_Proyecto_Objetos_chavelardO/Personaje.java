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
   
    
     /**
     * Constructor con parametros para definir la velocidad del jugador
     * imagen es el nombre de las imagenes para dar efecto de correr
     */
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
     * Constructor con parametros para definir la velocidad del jugador
     * @param theVelX   the amount to change in X per act
     * @param theVelY   the amount to change in Y per act
     * imagen es el nombre de las imagenes para dar efecto de correr
     */
    public Personaje(int theVelX, int theVelY)
    {
        imagen1 = new GreenfootImage("Jugador1D.jpg");
        imagen2 = new GreenfootImage("Jugador2D.png");
        imagen3 = new GreenfootImage("Jugador1I.png");
        imagen4 = new GreenfootImage("Jugador2I.png");
        velX = 1;
        velY = 1;
    }
    
    /**
     * Act - do whatever the Soni wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         
        mantenimientoPlataforma();
        jump();
        direccion();
        CreaBomba();
      
        creaVida();
        
        
       
    }    
    
    
    /**
     * Valida si ha tocado la BallA esto sirve para validar las muertes del enemigo
     */
    private int validaBall() //envia la validacion a world
    {
        if(isTouching(BallA.class))
        {
           return 1;
        }
        
        return 0;
    }
    
    
    
    /**
     * Metdo que permite moverte de izq a der.
     * d  es una variable que indica hacia donde esta en movimiento si es 1 es izq si es 2 es derecha y eso lo enviamos a el metodo ilicionCorrer 
     */
    private int movimiento()
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
     * Mantiene al personeje en la plataforma
     */
    private void mantenimientoPlataforma()
    {
         if (!isTouching(PlataA.class))
        {
           setLocation(getX(), getY() + velY);
        }
    }
    
    
    /**
     * hace brimcar al jugador
     */
   private void jump()
    {
        if(isTouching(PlataA.class))
        {
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX(), getY() - velY-70);
            
        }
    }
    }
    
   /**
    * crea la ilucion de correr a la derecha
    */
    private void ilucionCorrerD()
    {
        if(getImage()==imagen1)//get image regresa la imagen que esta actualmete
        {
            setImage(imagen2);
        }
        else{
           setImage(imagen1);
        }
    }
    
    
    /**
     * manda llmar la ilucion de correr 
     */
    private void direccion()
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
    
    /**
     * crea la ilucion de correr a la izquierda
     */
    private void ilucionCorrerI()
    {
        if(getImage()==imagen3)//get image regresa la imagen que esta actualmete
        {
            setImage(imagen4);
        }
        else{
           setImage(imagen3);
        }
    }
    
    
    /**
     * Crea bomba con la tecla "s" y define coordenadas de donde poder crearla en un espacio definido
     */
     private void CreaBomba()
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
    
    
    /**
     * se crea la vida cada cierta vez 
     */
    private void creaVida()
    {
        MyWorld mundo = (MyWorld) getWorld();
         if(Greenfoot.getRandomNumber(710) > 708)
                {
                   mundo.CreaVida();
                   
                }
           if(isTouching(Vida.class))
        {
               
                removeTouching(Vida.class);
                mundo.incrmentaVida();
        }
    }
    
  }

