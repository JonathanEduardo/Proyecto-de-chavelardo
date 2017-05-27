import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomba extends Actor
{
    /**
     * Act - do whatever the Bomba wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       MataJefe();
    }    
    
    
    /**
     * Metodo que valida la muerte del jefe al contacto con esta clase
     * p es un indicador de puntos para saber cuando y en que momento poder matar al jefe
     * nivel un indicador para sabe cuando matar a que jefe si no esta este en el nivel 3 sufre un error
     */
    public void MataJefe()   //Funcion para validar matar al jefe y pasar de nivel
    {
         MyWorld mundo = (MyWorld) getWorld(); 
         int p = mundo.getPuntos();
         int nivel = mundo.getNivel();
         
         
         if(p >= mundo.getMarca()-1 && nivel == 1)
         {
         if(isTouching(Jefe1.class))
            { 
              removeTouching(Jefe1.class);
              mundo.incrementaPuntos();
             //mundo.incrementaPuntos();
            }
        }
        
        if(p >= mundo.getMarca2()-1 && nivel >=2)
        { 
         if(isTouching(Jefe2.class))
            { 
              removeTouching(Jefe2.class);
              mundo.incrementaPuntos();
             //mundo.incrementaPuntos();
            }
        }
    }
}
