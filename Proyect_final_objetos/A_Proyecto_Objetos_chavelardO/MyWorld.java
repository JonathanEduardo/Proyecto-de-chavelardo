/**
 * *************************************************
 * Autor: Jhonathan Eduardo Quistiano Henrnadez    *
 * Nombre de juego: Chabelardo                     *
 * Fecha: 5/26/2017                                *
 * Lenguaje: Java                                  *
 * *************************************************
 */


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int numeroVidas = 3;
    private int marca = 5;  //Variable de n valor para pasar al nivel 2
    private int marca2 = 10; //Variable de n valor para pasar al nivel 3
    private int marca3 = 15; //Variable de n valor para ganar
    private Counter contTiempo;  //contador de tiemp
    private Counter contVidas;   //conntador de vidas
    private Counter contPunt;    //contador de puntuaje
    private int contMuer;       //contador de muertes
    private Counter contnivel;//contador de puntos
    private ArrayList<BallB> balls= new ArrayList<BallB>();
     private ArrayList<Vida> vidas= new ArrayList<Vida>();
    private Personaje pers;
    private EnemigoA ene;
    private Boton Start, Salir, Help, Cre;
    private LinkedList <GreenfootImage> imagenes; //lista de imagenes
    private int l = 0; 
   // private int jefe = 0;
    
   
    //Meidas para el mundo
    public static final int ancho = 800;  
    public static final int altura = 600;
   
    /**
     * Constructor for objects of class Space.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(ancho, altura, 1);
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("menu2.jpg"));      //0
        imagenes.add(new GreenfootImage("control.png")); //1
        imagenes.add(new GreenfootImage("e.png"));//2
        imagenes.add(new GreenfootImage("coyote.png")); //3            
        imagenes.add(new GreenfootImage("c.png")); //4
        
        
        Start = new Boton(getImagen(1));
        Salir = new Boton(getImagen(2));
        Help = new Boton(getImagen(3));
        Cre = new Boton(getImagen(4));
       menu();  
    }
    
   
    
    /**
     * Metodo que crea el menú del juego. 
     * Manda a llamar las imagenes de los botones y el del fondo
     */
    public void menu()
    {
        removeObjects(getObjects(null));
        addObject(Start, 400, 150);
        addObject(Help, 100, 400);
        addObject(Cre, 650, 490);
        Greenfoot.setSpeed(40);
        setBackground(getImagen(0));
        
        
    }
    
    
    /**
     * Metodo de actua aqui manda llamar el seleccionador controlado a traves del mause
     */
       public void act()
    {
        seleccionar();
    } 
     
    /**
     * Método que selecciona entre todos los botones que aparescan
     * en el juegoya sea el de salir que regresa al menú, el de start manda 
     * }al nivel 1, help manda a la ayuda y el boton de creditos.
     */
    public void seleccionar()
    {
        if(Greenfoot.mouseClicked(Salir)) {
            removeObjects(getObjects(null));
            menu();
        }
        if(Greenfoot.mouseClicked(Start)) {
            removeObjects(getObjects(null));
            l = 1;
            nivel1();
        }
         if(Greenfoot.mouseClicked(Help)) {
            removeObjects(getObjects(null));
            Help();
        }
        if(Greenfoot.mouseClicked(Cre)){
            removeObjects(getObjects(null));
            Creditos();
        }
    }
    
       /**
     * Metodo que crea la ayuda. La ayuda se manda a llamar
     * la imagen de ayuda y el boton de salir.
     */
    public void Help()
    {
        removeObjects(getObjects(null));

        GreenfootImage hp = new GreenfootImage("ayuda.jpg");
        setBackground(hp);
        addObject(Salir,740,580);  
    }
    
    /**
     * Método donde aparecen los creditos en una imagen
     */
    public void Creditos()
    {
        removeObjects(getObjects(null));

        GreenfootImage hp = new GreenfootImage("ImaCre2.jpg");
        setBackground(hp);
        addObject(Salir,740,580);  
    }
    
    /**
     * Método del nivel uno del juego
     */
    public void nivel1()
    {
      
        setBackground("Nivel1.jpg");
        //Greenfoot.playSound("Sonido1.wav"); 
        addObject(new Personaje(),37,552);
        addObject(new BallB(), ancho/2, altura/2);
        balls.add(new BallB());
        addObject(new BallA(), 200, altura/2);
        addObject(new Jefe1(0,700,"Jefe1-1.png","Jefe1-2.png"),350,70);
        GeneraPlataformas(); //Generador de plataformas 
        Greenfoot.setSpeed(45);
        
         
        contVidas = new Counter("Vidas: "); //contadores 
        addObject(contVidas,50,altura-10);
        contnivel = new Counter("Nivel:"); //contadores 
        addObject(contnivel,375,altura-10);
        contnivel.setValue(1);
        contVidas.setValue(numeroVidas);
        contPunt = new Counter("Puntos: ");
        addObject(contPunt,750,altura-10);
        contPunt.setValue(0);
       
    }
    
    /**
     * Método del nievel 2
     */
    public void nivel2()
    {
         
      
        removeObjects(getObjects(null));
        balls.clear();
        vidas.clear();
        setBackground("Nivel2.jpg");
        addObject(new BallB(), ancho/2, altura/2);
         addObject(new BallB(), ancho/2, altura/2);
        balls.add(new BallB());
        addObject(new BallA(), 200, altura/2);
        addObject(new Personaje(),37,552);
        addObject(new Jefe2(0,700,"Jefe2-1.png","Jefe2-2.png"),350,70);
        GeneraPlataformas();
        Greenfoot.setSpeed(45);
        contadores();
       
    }
    
    /**
     * Método del nivel 3 del juego
     */
    public void nivel3()
    {
        removeObjects(getObjects(null));
        balls.clear();
        vidas.clear();
        setBackground("Nivel3.jpg");
        addObject(new BallB(), ancho/2, altura/2);
         addObject(new BallB(), ancho/3, altura/4);
          addObject(new BallB(), ancho/4, altura/3);
        balls.add(new BallB());
        addObject(new BallA(), 200, altura/2);
        addObject(new Personaje(),37,552);
        addObject(new Jefe1(0,700,"Jefe1-1.png","Jefe1-2.png"),5,70);
        addObject(new Jefe2(0,700,"Jefe2-1.png","Jefe2-2.png"),795,70);
        GeneraPlataformas();
        Greenfoot.setSpeed(45);
       contadores();
       
       
    }
    
    
    /**
     * Metodo donde se evaluan los contadores 
     */
     public void contadores(){
        addObject(contVidas,50,altura-10);
        contVidas.setValue(contVidas.getValue());
        addObject(contPunt,750,altura-10);
        contPunt.setValue(contPunt.getValue());
        addObject(contnivel,375,altura-10);
        contnivel.setValue(contnivel.getValue());
    }
    
    /**
     * Metodo donde se crean las plataformas acompaniadas de sus enemigos encima una por una
     */
    public void GeneraPlataformas()
   {
      
      //Piso
       addObject(new PlataA(),112,altura -20);
       addObject(new PlataA(),340,altura -20);
       addObject(new PlataA(),568,altura -20);
       addObject(new PlataA(),690,altura -20);
       
       //Creacion de los enemigos y sus respectivas plataformas
       addObject(new PlataA(),382,544);
       addObject(new EnemigoA(292,472),372,504);
       addObject(new PlataA(),656,501);
       addObject(new EnemigoB(576,746),686,460);
       addObject(new PlataA(),156,473);
       addObject(new EnemigoB(66,246),76,433);
       addObject(new PlataA(),431,425);
       addObject(new EnemigoA(341,521),451,385);
       
       addObject(new PlataA(),156,358);////
       addObject(new EnemigoA(66,246),86,322);  
       
       addObject(new PlataA(),656,343);
       addObject(new EnemigoA(576,746),586,303);
       addObject(new PlataA(),415,268);
       addObject(new EnemigoB(325,505),400,228); 
       addObject(new PlataA(),144,209);
       addObject(new EnemigoA(54,234),220,170);
       addObject(new PlataA(),676,193);
       addObject(new EnemigoA(586,766),590,153);
       
    
   }
    
    
    

    /**
     * Metodo que regresa las imagenes en una lista.
     */
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
    /**
     * Metodos para regesar los botones
     */
    public Boton getJugar()
    {
        return Start;
    }
    
    /**
     * Metodo que muetra la ayuda del juego en una imagen
     */
    public Boton getAyuda()
    {
        return Help;
    }
   
   /**
    * Metodo donde se decrementan las vidas del jugador.
    */
    public void decrementaVidas()  //Metodo para incrementar cont de vidas
    {
        contVidas.add(-1);
        if(contVidas.getValue() <= 0)
       {
           muere();
       }
    }
   
    /**
     * Metodo que loca la imagen de perder cuando ya no tiene vidas
     */
    public void muere()
    {
        removeObjects(getObjects(null));
        //ban=1;
        GreenfootImage pe = new GreenfootImage("Perdiste.jpg");
        setBackground(pe);
        addObject(Salir,740,450);
    }
    
    /**
     * metodo que regresa un tipo de marca o limite para pasar de nivel al segundo
     * se utiliza en la clase Jefe1 para diferenciar de quien matar
     */
    public int getMarca()
    {
       return marca;
    }
    
    /**
     * metodo que regresa un tipo de marca o limite para pasar de nivel al tercer nivel 
     * se utiliza en la clase jefe 2 para difereciar de quien matar
     */
    public int getMarca2()
    {
       return marca2;
    }
    
      /**
     * metodo que regresa un tipo de marca o limite para pasar de nivel al tercer nivel 
     * se utiliza en la clase jefe 2 para difereciar de quien matar
     */
    public int getMarca3()
    {
       return marca3;
    }
    
    /**
     * Metodo para incrementar cont de puntos
     * Tambien actua como cambio de nivel
     */
     public void incrementaPuntos() 
    {
        contPunt.add(+1);
        UltimaPlata();
        if(contPunt.getValue() == marca)
            { 
                 incrementaNivel(); 
              nivel2();
            }
             
        if(contPunt.getValue() == marca2)
            { 
                 incrementaNivel();
              nivel3();
            }
            
        if(contPunt.getValue() == marca3)
        {
            Gana();
        }
    }
    
    
    /**
     * Metodo que genera la ultima plataforma donde se encuentra el rango para insertar la bomba
     * lo genera despues de cierto puntuaje que esta dado por la variable "marca"
     */
    public void UltimaPlata()
    {
         if(contPunt.getValue() == marca -1)
        { 
            addObject(new PlataA(),400,120);
            
        }
         
        if(contPunt.getValue() == marca2 -1)
        {
           addObject(new PlataA(),400,120);
        }
        
        if(contPunt.getValue() == marca3 -1)
        {
           addObject(new PlataA(),400,120);
        }
    }
    
    
    /**
     * regresa los puntos que se lleva
     */
    public int getPuntos()
    {
        return contPunt.getValue();
    }

    
    
     /**
    * Metodo que se encarga de poner la imagen de ganar cuando haya 
    * terminado el juego.
    */
   public void Gana(){
       removeObjects(getObjects(null));
       GreenfootImage gan = new GreenfootImage("Fin.jpg");
       setBackground(gan);
       addObject(Salir,740,450);
    }
    
    /**
     * metodo que incrementa el contador de nivel
     */
    public void incrementaNivel() 
    {
        contnivel.add(+1);
    }
    
       
    /**
     * metodo que incrementa el contador de nivel
     */
    public void incrementaVida() 
    {
        contVidas.add(+1);
    }
    
    /**
     * Método que se encarga de sumar una vida al jugador
     */
    public void incrmentaVida() 
    {
        contVidas.add(+1);
    }
    
    /**
     * Método que se encarga de sumar a los enemigos
     */
    public void cuentaEnemigos()
    {
        contMuer++;
    }
    
    /**
     * Metodo que regresa la cantidad de muertes de los enemigos
     */
    public int getcuE()
    {
        return contMuer;
    }
    
    /**
     * Metodo que crea la BalaB(bala enemiga)
     */
    public void CreaBalaEnemiga()
    {
        if(balls.size()<5){
         addObject(new BallB(), ancho/2, altura/2);
         balls.add(new BallB());
        }
    }
    
    /**
     * Metodo para reaparecer al jugador 
     */
    public void ReapareceJugador()
    {
        addObject(new Personaje(),10,altura-50);
    }

    /**
     * Metodo que crea bomba
     * x = poscion en eje x dada por la poscicion del jugador
     * y = poscion en eje y dada por la poscicion del jugador
     */
    public void CreaBomba(int x, int y)
    {
        addObject(new Bomba(),x,y);
    }
    
    /**
     * metodo regresa nivel
     */
    public int getNivel()
    {
        return contnivel.getValue();
    }
   
    
    /**
     * metodo que crea vida
     */
    public void CreaVida()
    {
        int x, y;
        x = Greenfoot.getRandomNumber(750);
        y = Greenfoot.getRandomNumber(580);
        
        if( y > 130 && vidas.size()<2){
            addObject(new Vida(),x,y);
            vidas.add(new Vida());
       }
    }
    
    
    /**
     * metodo regresa numero de vidas
     */
    public int getVidas()
    {
        return contVidas.getValue();
    }
}