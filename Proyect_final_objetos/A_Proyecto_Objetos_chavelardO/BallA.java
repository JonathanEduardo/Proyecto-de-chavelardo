import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class BallA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallA extends Ball

{   
    private int ban;
    
    
    public BallA()
    {
     super();
     ban = 0;
    }
    
     /**
     * Balls will move and check if they have hit a brick or paddle or
     * one of the edges of the world
     */
    public void act() 
    {          
        super.act();
    
        mata();
        mata2();
     
        
   }
    
    public void mata()  // Funcion para matar al los enemigos 
    {
         MyWorld mundo = (MyWorld) getWorld(); 
         int nivel = mundo.getNivel();
         int punt = mundo.getPuntos();
         int marca =  mundo.getMarca();
         int marca2 =  mundo.getMarca2();
         int marca3 =  mundo.getMarca3();
         
         if( nivel == 1 && punt <= marca-2){
            
         if(isTouching(Personaje.class))
         {
           ban = 1;
         }
        
         if(ban == 1 && isTouching(EnemigoA.class))   // El valor de la ultima condicion debe ser el mismo de incrementa puntos
         {
           removeTouching(EnemigoA.class);
           mundo.incrementaPuntos();
           ban = 0;
            mundo.CreaBalaEnemiga();
          }
        }
        
          if( nivel == 2 && punt <= marca2-2){
         if(isTouching(Personaje.class))
         {
           ban = 1;
         }
        
         if(ban == 1 && isTouching(EnemigoA.class))   // El valor de la ultima condicion debe ser el mismo de incrementa puntos
         {
           removeTouching(EnemigoA.class);
           mundo.incrementaPuntos();
           ban = 0;
            mundo.CreaBalaEnemiga();
          }
        }
        
        if( nivel == 3 && punt <= marca3-2){
         if(isTouching(Personaje.class))
         {
           ban = 1;
         }
        
         if(ban == 1 && isTouching(EnemigoA.class))   // El valor de la ultima condicion debe ser el mismo de incrementa puntos
         {
           removeTouching(EnemigoA.class);
           mundo.incrementaPuntos();
           ban = 0;
            mundo.CreaBalaEnemiga();
          }
        }
        
    } 
    
      public void mata2()  // Funcion para matar al los enemigos 
    {
         MyWorld mundo = (MyWorld) getWorld(); 
         int nivel = mundo.getNivel();
         int punt = mundo.getPuntos();
         int marca =  mundo.getMarca();
         int marca2 =  mundo.getMarca2();
         int marca3 =  mundo.getMarca3();
         
         if( nivel == 1 && punt <= marca-2){
            
         if(isTouching(Personaje.class))
         {
           ban = 1;
         }
        
         if(ban == 1 && isTouching(EnemigoB.class))   // El valor de la ultima condicion debe ser el mismo de incrementa puntos
         {
           removeTouching(EnemigoB.class);
           mundo.incrementaPuntos();
           ban = 0;
            mundo.CreaBalaEnemiga();
          }
        }
        
          if( nivel == 2 && punt <= marca2-2){
         if(isTouching(Personaje.class))
         {
           ban = 1;
         }
        
         if(ban == 1 && isTouching(EnemigoB.class))   // El valor de la ultima condicion debe ser el mismo de incrementa puntos
         {
           removeTouching(EnemigoB.class);
           mundo.incrementaPuntos();
           ban = 0;
            mundo.CreaBalaEnemiga();
          }
        }
        
        if( nivel == 3 && punt <= marca3-2){
         if(isTouching(Personaje.class))
         {
           ban = 1;
         }
        
         if(ban == 1 && isTouching(EnemigoB.class))   // El valor de la ultima condicion debe ser el mismo de incrementa puntos
         {
           removeTouching(EnemigoB.class);
           mundo.incrementaPuntos();
           ban = 0;
            mundo.CreaBalaEnemiga();
          }
        }
        
    } 
   
    }
    

