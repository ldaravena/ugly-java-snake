package grupodos.interfazGrafica;

import grupodos.objetosPrincipales.Serpiente;
import grupodos.objetosPrincipales.Mapa;
import grupodos.objetosPrincipales.Alimento;
import grupodos.interfazGrafica.Interfaz;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * 
 * Clase Panel que permite controlar y visualizar los elementos del juego.
 * 
 * @author Leonardo Aravena Cuevas
 */

public class Panel extends JPanel implements ActionListener,KeyListener{
    
    /**
     * Puntero a la Interfaz.
     */
    private Interfaz ventana;
    /**
     * Personaje principal del juego en modo individual.
     */
    private Serpiente serpiente;
    /**
     * Serpiente del jugador 1 en el modo multijugador.
     */
    private Serpiente serpiente1;
    /**
     * Serpiente del jugador 2 en el modo multijugador.
     */
    private Serpiente serpiente2;
    /**
     * Alimento para el serpiente.
     */
    private Alimento alimento;
    /**
     * Escenario donde se mueve la serpiente.
     */
    private Mapa mapa;
    /**
     * Variable de tiempo para el control del movimiento automático de la serpiente.
     */
    private Timer tiempo;
    /**
     * Variable para la dirección de movimiento de la serpiente en modo Individual y del jugador 1 en modo Multijugador.
     */
    private int movimiento;
    /**
     * Variable para la dirección de movimiento de la serpiente del jugador 2 en modo Multijugador.
     */
    private int movimiento2;
    /**
     * Variable para contar el alimento comido por la serpiente, que tambien corresponde al puntaje en el modo Individual.
     */
    private int puntos;
    /**
     * Variable para controlar cuando se juega, se pone en pausa o se pierde.
     */
    private boolean jugar;
    /**
     * Velocidad a la que se mueve la Serpiente.
     */
    private int velocidad;
       /**
     * Variable para la selección de los distintos escenarios del juego.
     */
   private int nivel;
    /**
     * Variable para determinar cuanto alimento se requiere para cambiar de escenario.
     */
    private int objetivo;
    /**
     * Variable para contar el alimento comido por la serpiente del jugador 1, que tambien corresponde al puntaje en el modo Multijugador.
     */
    private int puntos1;
    /**
     * Variable para contar el alimento comido por la serpiente del jugador 2, que tambien corresponde al puntaje en el modo Multijugador.
     */
    private int puntos2;
    /**
     * Variable para 
     */
    private int valorVelocidad;
    /**
     * Identifica si se juega en modo Multijugador.
     */
    private boolean multijugador;
    /**
     * Identifica si se juega en el modo Individual Rotativo o Fijo.
     */
    private boolean modoJuego;
    /**
     * Coordenada 'x' de ubicación del punto de partida de la cabeza de la serpiente en modo Individual.
     */
    private int x;
    /**
     * Coordenada 'y' de ubicación del punto de partida de la cabeza de la serpiente en modo Individual.
     */
    private int y;

    /** 
     * Método constructor que recibe el puntero de la Interfaz y las configuraciones de modo individual o multijuador.
     * 
     * @param ventana  Interfaz que contiene al Panel.
     * @param multijugador Indica si se inicia en modo Multijugador
     * @param modoJuego En el modo individual indica si se inicia en modo "Rotativo o "Fijo"
     * @param velocidad Velocidad a la que se mueve la serpiente en modo individual "Fijo"
     * @param nivel Nivel en el que se juega en modo individual "Fijo"
     * @param objetivo Cantidad de alimento que para cambiar de nivel en modo "Rotativo"
     */
    public Panel(Interfaz ventana, boolean multijugador, boolean modoJuego, int velocidad, int nivel, int objetivo){
        
        //Se recibe el puntero de la Interfaz
        this.ventana=ventana;
        
        this.multijugador=multijugador;

        this.nivel=nivel;
        
        this.nivel--;
        
        this.modoJuego=modoJuego;

        this.objetivo=objetivo;
        
        this.velocidad=velocidad; //Velocidad inicial 
        
        //Agrega el Listener del teclado
        this.addKeyListener(this);
        
        //Enfoca el Panel para los eventos del teclado
        this.setFocusable(true);
        
        this.setBackground(new Color(152,251,152));
        
        if(modoJuego){
            
            this.nivel=0;
            velocidad=2;
        }
        
        if(!multijugador){
    
            switch(this.nivel){
            
            case 0:
                
                x=400;
                y=300;
                
                break;
                
            case 1:
                
                x=300;
                y=300;

                break;
                
            case 2:
                
                x=300;
                y=200;

                break;
                
            case 3:
                
                x=200;
                y=80;

                break;
                
            case 4:
                
                x=200;
                y=40;

                break;
            }
            
            mapa = new Mapa(this.nivel);
            serpiente = new Serpiente(x,y,false);
            alimento = new Alimento(100,100);
           
            movimiento=4;
        }
        
        else{
            
            mapa = new Mapa(5);
            
            serpiente1 = new Serpiente(200,100,false);
            serpiente2= new Serpiente(200,500,true);
        
            alimento = new Alimento(400,400);
        
            movimiento =4;
            movimiento2 =4;
        }

        switch(velocidad){
            
            case 1:
                
                valorVelocidad=400;
                break;
                
            case 2:
                valorVelocidad=300;
                break;
                
                
            case 3:
                valorVelocidad=250;
                break;
                
                
            case 4:
                valorVelocidad=200;
                break;
                
            case 5:
                valorVelocidad=100;
                break;
                
        }
        
        
        //Se inicia el Timer:
        tiempo = new Timer(valorVelocidad,null);
        
        //Se agrega el Listener:
        tiempo.addActionListener(this);
        
        //Ubica el alimento en una posición aleatoria
        alimento.reinicio();
        ubicarAlimento();
 
    }
    /**
     * Método para controlar cuando se inicia, se pone en pausa o se pierde el juego.
     */
    public void jugar(){

        if(jugar){
            
            tiempo.stop();
            jugar=false;  
        }
        
        else{
            
            tiempo.start();
            jugar=true;
        }
    }
    /**
     * Método para reiniciar el juego en modo individual una vez que se pierde.
     */
    public void reinicio(){
        
        if(modoJuego){
            
            x=400;
            y=300;
            nivel=0;
            valorVelocidad=300;
        }
        
        serpiente = new Serpiente(x,y,false);
        alimento = new Alimento(100,100);
        
        movimiento=4;
        
        tiempo.setDelay(valorVelocidad);
        
        mapa= new Mapa(nivel);
        
        ubicarAlimento();
        
        jugar(); 
        repaint();
    }
     /**
     * Método para reiniciar el juego en modo multijugador una vez que se pierde.
     */
    public void reinicioMultijugador(){
        
        serpiente1 = new Serpiente(200,100,false);
        serpiente2= new Serpiente(200,500,true);
        
        alimento = new Alimento(400,400);
        
        movimiento =4;
        movimiento2=4;
        
        tiempo.setDelay(valorVelocidad);
        jugar();
        repaint();
    }
    /**
     * Método para mover la serpiente en el modo de juego individual y comprobar si ha comido el alimento.
     */
    private void mover(){
        
        if(serpiente.moverCrecer(movimiento, alimento.comido(serpiente.ubicacion()))){
            
            puntos++; //Al comer aumenta el contador
            ubicarAlimento();
            
            if(puntos%objetivo==0 && modoJuego) cambiarNivel();
            
            ventana.puntaje(puntos); //Envia el contador alimento la Interfaz para mostrar el puntaje
        }
        repaint();
    }
    
    /**
     * Método para mover la serpiente del jugador 1 en el modo de juego multijugador y comprobar si ha comido el alimento.
     */
    private void moverJugador1(){

        if(serpiente1.moverCrecer(movimiento, alimento.comido(serpiente1.ubicacion())) ){
            
            
           puntos1++;
           ubicarAlimento();
           
           ventana.puntosMultijugador(puntos1,puntos2);
        
        }
        repaint();

    }
    /**
     * Método para mover la serpiente del jugador 2 en el modo de juego multijugador y comprobar si ha comido el alimento.
     */
    private void moverJugador2(){
        
         if(serpiente2.moverCrecer(movimiento2, alimento.comido(serpiente2.ubicacion())) ){
            
            puntos2++;
            
            ubicarAlimento();
            
            ventana.puntosMultijugador(puntos1,puntos2);
                     
        }
         repaint();
    }
    
    /**
     * Método para cambiar el nivel una vez haya comido la cantidad 'objetivo' de alimentos.
     */
    private void cambiarNivel(){
        
        serpiente=null;
            
        nivel++;
        
        movimiento=4;
        
        switch(nivel){
            
            case 1:
                
                x=300;
                y=300;
                
                break;
                
            case 2:
                
                x=300;
                y=200;

                break;
                
            case 3:
                
                x=200;
                y=80;

                break;
                
            case 4:
                
                x=200;
                y=40;

                break;
                
            case 5:
                
                x=400;
                y=300;

                nivel=0;
                tiempo.setDelay(100);
                break;
        }
        
        serpiente = new Serpiente(x,y,false);
        mapa = new Mapa(nivel);
        ubicarAlimento();
    }
    
    /**
     * Método para ubicar un nuevo alimento una vez comido.
     */
    private void ubicarAlimento(){
        
        //Mientras el alimento se ubique dentro de algún bloque se elige una nueva ubicación.
        while(mapa.choqueMapa(alimento.ubicacion())){
            
            alimento.reinicio();
        }
    }
    
    /**
     * Método utilizado en el modo indivudal para verificar si la serpiente choca con su cuerpo con algún obstaculo del escenario.
     */
    private void verChoque(){
 
        if(serpiente.chocaCuerpo(serpiente.ubicacion()) || mapa.choqueMapa(serpiente.ubicacion())){
            
            tiempo.stop();
            jugar=false;
            serpiente.morir();
            ventana.reinicio();
            puntos=0;
            repaint();
        }
    }
    /**
     * Método utilizado en el modo multijugador para verificar si la serpiente del jugador 1 choca con su cuerpo, con el cuerpo de la serpiente del jugador 2 con algún obstaculo del escenario.
     */
    private void verChoqueJugador1(){

        if( serpiente1.chocaCuerpo(serpiente1.ubicacion()) || serpiente2.chocaCuerpo(serpiente1.ubicacion()) 
            || mapa.choqueMapa(serpiente1.ubicacion()) ){
            
            tiempo.stop();
            jugar=false;
            serpiente1.morir();
            ventana.reinicio();
            puntos1=0;
            repaint();
        }        
    }
    /**
     * Método utilizado en el modo multijugador para verificar si la serpiente del jugador 2 choca con su cuerpo, con el cuerpo de la serpiente del jugador 1 con algún obstaculo del escenario.
     */
    private void verChoqueJugador2(){
        
         if( serpiente2.chocaCuerpo(serpiente2.ubicacion()) ||  serpiente1.chocaCuerpo(serpiente2.ubicacion()) 
            || mapa.choqueMapa(serpiente2.ubicacion()) ){
            
            tiempo.stop();
            jugar=false;
            serpiente2.morir();
            ventana.reinicio();
            puntos2=0;
            repaint();
        }
    }
    
    /**
     * Método para mostrar todos los elementos que componen el juego en pantalla.
     * 
     * @param g Clase Graphics.
     */
    
    @Override
    public void paint(Graphics g){
               
        super.paint(g);

        mapa.paint(g);

        alimento.paint(g);
        
        if(multijugador){
 
            serpiente1.paint(g);
            serpiente2.paint(g);
        }
        
        else{
            
            serpiente.paint(g);
        }
    }

    /**
     * Método no utilizado.
     * @param e Evento de Teclado.
     */
    @Override
    public void keyTyped(KeyEvent e) {}
    
    /**
     * Método que verifica que tecla se pulsó para dirigir la serpiente.
     * @param e Evento de Teclado.
     */
    @Override
    public void keyPressed(KeyEvent e) {
            
            //Al presionar una de las flechas direccionales se cambia la direccion
            switch(e.getKeyCode()){
                
                case KeyEvent.VK_UP:
                    
                    if(movimiento!=2 && jugar){
                     
                        movimiento=1;
                    
                        if(multijugador){
                            
                            moverJugador1();
                            verChoqueJugador1();

                        }
                        
                        else{
                            
                            mover();
                            verChoque();
                        }
                    }
                    
                    break;
                    
                case KeyEvent.VK_DOWN:
                    
                    if(movimiento!=1 && jugar){
                        

                        movimiento=2;
                        
                        if(multijugador){
                            
                            moverJugador1();
                            verChoqueJugador1();
                        }
                        
                        else{
                            
                            mover();
                            verChoque();
                        }
                    }
                    
                    break;
                    
                case KeyEvent.VK_LEFT:
                    
                    if(movimiento!=4 && jugar){

                        movimiento=3;
                        
                        if(multijugador){
                            
                            moverJugador1();
                            verChoqueJugador1();

                        }
                        
                        else{
                            
                            mover();
                            verChoque();
                        }
                    }
                    break;
                    
                case KeyEvent.VK_RIGHT:
                    
                    if(movimiento!=3 && jugar){

                        movimiento=4;
                        
                        if(multijugador){
                            
                            moverJugador1();
                            verChoqueJugador1();

                        }
                        
                        else{
                            
                            mover();
                            verChoque();
                        }
                    }
                    
                    break;
                    
                case KeyEvent.VK_W:
                    
                    if(movimiento2!=2 && jugar){
                      
                        movimiento2=1;
                        
                        if(multijugador){
                            
                            moverJugador2();
                            verChoqueJugador2();

                        }

                        
                    }
                    break;
                    
                case KeyEvent.VK_S:
                    
                    if(movimiento2!=1 && jugar){

                        movimiento2=2;
                        
                        if(multijugador){
                            
                            moverJugador2();
                            verChoqueJugador2();

                        }
                    }
                    break;
                
                case KeyEvent.VK_A:
                    
                    if(movimiento2!=4 && jugar){

                        movimiento2=3;
                        
                        if(multijugador){
                            
                            moverJugador2();
                            verChoqueJugador2();

                        }

                    }
                    break;
                    
                case KeyEvent.VK_D:
                    
                    if(movimiento2!=3 && jugar){

                        movimiento2=4;
                        
                        if(multijugador){
                            
                            moverJugador2();
                            verChoqueJugador2();

                        }

                    }
                    break;
                    
            }
    }
    
    /**
     * Método no utilizado.
     * @param e Evento de Teclado.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    /**
     * Método que llama a los métodos para mover la(s) serpiente(s) y comprobar si ha(n) chocado.
     * @param e Evento de Acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

     
       if(multijugador){
           
           moverJugador1();
           verChoqueJugador1();
           
           moverJugador2();
           verChoqueJugador2();
       }
       
       else{
           
           mover();
           verChoque();
       }
    }
}
