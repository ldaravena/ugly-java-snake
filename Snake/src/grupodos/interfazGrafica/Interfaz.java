package grupodos.interfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase Interfaz que contiene el panel del juego y botones de control.
 * 
 * @author Leonardo Aravena Cuevas
 */

public class Interfaz extends JFrame{
    
    /**
     * Puntero al Menu.
     */
    private Menu menu;
    /**
     * Panel del juego.
     */
    private Panel panelDibujo;
    /**
     * Panel principal de control que contiene los botones y la etiqueta de texto del puntaje. 
     */
    private JPanel panelPrincipal; 
    /**
     * Panel que contiene el boton 'inicio'.
     */
    private JPanel boton1;
    /**
     * Panel que contiene el boton 'volverMenu'.
     */
    private JPanel boton2;
    /**
     * Panel que contiene la etiqueta de texto del putaje.
     */
    private JPanel scorePanel;
    /**
     * Botón para iniciar, poner en pausa o reiniciar el juego.
     */
    private BotonInicio inicio;
    /**
     * Botón para volver al menú principal.
     */
    private BotonMenu volverMenu;
    /**
     * Etiqueta de texto para mostrar el puntaje en el modo de Juego Individual.
     */
    private JLabel score;
    /**
     * Etiqueta de texto para mostrar el puntaje del jugador 1 en el modo de Juego Multijugador.
     */
    private JLabel score1;
     /**
     * Etiqueta de texto para mostrar el puntaje del jugador 2 en el modo de Juego Multijugador.
     */
    private JLabel score2;
    /**
     * Etiqueta de texto para crear un espacio entre las etiquetas de texto del puntaje de los dos jugadores en el modo de Juego Multijugador.
     */
    private JLabel espacio; 
    /**
    * Variable para controlar el nombre del botón 'inicio' y las pausas o reinicios del juego.
    */
    private int modo; 
    /**
     * Velocidad a la que se mueve la serpiente.
     */
    private int velocidad;
    /**
     * Indica que en escenario se juega.
     */
    private int nivel;
    /**
     * Indica cuando alimento se requiere para cambiar de nivel.
     */
    private int objetivo;
    /**
     * Identifica si se juega en modo "Rotativo" o "Fijo".
     */
    private boolean modoJuego;
    /**
     * Identifica si se juega en modo individual o multijugador.
     */
    private boolean multijugador;
    /** 
     * Método constructor de la Interfaz que recibe el puntero del Menú del juego y las configuraciones para el modo de juego.
     * 
     * @param menu Menu que contiene a la Interfaz.
     * @param multijugador Indica si se juega en modo Multijugador
     * @param modoJuego En el modo Individual indica si se juega en modo "Rotativo o "Fijo"
     * @param velocidad Velocidad a la que se mueve la serpiente.
     * @param nivel Indica que en escenario se juega.
     * @param objetivo Indica cuando alimento se requiere para cambiar de nivel
     */
    public Interfaz(Menu menu, boolean multijugador,boolean modoJuego, int velocidad, int nivel, int objetivo){
        
        this.velocidad=velocidad;
        
        this.nivel= nivel;
        
        this.objetivo=objetivo;
        
        this.menu=menu;
        
        
        this.multijugador=multijugador;
        
        this.modoJuego=modoJuego;
        
        modo=0;
        
        this.setLayout(new BorderLayout());

        panelPrincipal = new JPanel();
        
        boton1= new JPanel();
        
        boton2 = new JPanel();
        
        scorePanel = new JPanel();
        
        if(!multijugador){
            
            score = new JLabel("Puntaje: 0",JLabel.CENTER);
        }
        
        else{
            
            score1 = new JLabel("Jugador 1: 0", JLabel.LEFT);
            
            espacio = new JLabel("        |        ");
            
            score2 = new JLabel("Jugador 2: 0", JLabel.RIGHT);
        }
        
        panelPrincipal.setLayout(new GridLayout(1,3));
        
        this.add(panelPrincipal,BorderLayout.NORTH);
        
        panelPrincipal.add(boton1);
        
        panelPrincipal.add(scorePanel);
        
        panelPrincipal.add(boton2);
        
        inicio = new BotonInicio("Pausa");
        
        volverMenu = new BotonMenu("Volver al Menu");

        if(!multijugador){
            
            scorePanel.add(score);
        }
        
        else{
            
            scorePanel.add(score1);
            scorePanel.add(espacio);
            scorePanel.add(score2);
        }
        
        boton1.add(inicio);
        
        boton2.add(volverMenu);

        panelDibujo= new Panel(this, multijugador,modoJuego,velocidad,nivel,objetivo);

        this.add(panelDibujo,BorderLayout.CENTER);
         
        this.setResizable(false);
        this.setTitle("Grupo Dos: Snake v1.0");
        this.setSize(800,650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /**
     * Método para controlar el estado del juego.
     */
    public void jugar(){
        
        panelDibujo.jugar();
    }
    
    /**
     * Método para reiniciar el juego.
     */
    public void reinicio(){
        
        modo=2;
       
        inicio.setText("Reiniciar");
    }
    /**
     * Método para mostrar el puntaje.
     * 
     * @param puntos Variable que recibe los puntos obtenidos por el jugador.
     */
    public void puntaje(int puntos){

        score.setText("Puntaje: " +puntos);
    }
    
    
    public void puntosMultijugador(int puntos1, int puntos2){
        
        score1.setText("Jugador 1: " +puntos1);
        score2.setText("Jugador 2: " +puntos2);
    }
    /**
     * Clase privada para el botones de control en el panel de juego.
     */
    private class BotonInicio extends JButton implements ActionListener{
        
        /**
         * Método constructor del Botón de Inicio que recibe el nombre.
         * @param nombre Cadena de texto que corresponde al nombre del botón.
         */
        public BotonInicio(String nombre){

            super(nombre);
            this.setFocusable(false);
            this.addActionListener(this);
        }
        
        /**
         * Método par controlar como se usa el botón, para poner en pausa, reanudar o reiniciar el juego.
         * @param e Evento de Acción.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            
            panelDibujo.setFocusable(true);
            
            if(modo==0){

                panelDibujo.jugar();
                this.setText("Continuar");
                modo=1;
            }
            
            else if (modo==1){
                
                panelDibujo.jugar();
                this.setText("Pausa");
                modo=0;
            }
            
            else if (modo==2){
                
                
                if(!multijugador){
                    
                    panelDibujo.reinicio();
                
                    puntaje(0);
                     
                }
                
                else{
                    
                    panelDibujo.reinicioMultijugador();
                    puntosMultijugador(0,0);
                    
                }
                this.setText("Pausa");
                modo=0;
            }
        }
    }
    /**
     * 
     * Clase privada del Boton para regresar al menu.
     */
    private class BotonMenu extends JButton implements ActionListener{
        
        /**
         * Método constructor del Botón Menú que recibe el nombre.
         * 
         * @param nombre Cadena de texto que contiene el nombre del botón.
         */
        public BotonMenu(String nombre){
            
            super(nombre);
            this.setFocusable(false);
            this.addActionListener(this);
        }
        /**
         * Método para volver al menú principal.
         * 
         * @param e Evento de Acción.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
            menu.restaurar();
        }
    }
}
