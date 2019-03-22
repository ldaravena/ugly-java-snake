package grupodos.interfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase Menu para elegir las opciones del juego Snake
 * 
 * @author Leonardo Aravena Cuevas
 */
public class Menu extends JFrame{
    /**
     * Ventana principal del juego.
     */
    private Interfaz interfaz;
    /**
     * Menú de selección para las opciones del juego individual.
     */
    private Seleccionar seleccionar;
    /**
     * Menú que muestra las instrucciones del juego.
     */
    private Ayuda menuAyuda;
     /**
     * Panel que contiene los botones del menú.
     */
    private JPanel menu;
    /**
     * Botón para iniciar el juego en modo individual.
     */
    private Boton inicioSingle;
    /**
     * Botón para iniciar el juego en modo multijugador.
     */
    private Boton inicioMulti;
    /**
     * Botón para ver los mejores puntajes del modo individual.
     */
    private Boton verPuntajes;
    /**
     * Botón para entrar en el modo de creación y edición de escenarios.
     */
    private Boton editarMapas;
    /**
     * Botón para entrar al menú de ayuda con las instrucciones de uso del juego.
     */
    private Boton ayuda;
    /**
     * Botón para salir del juego.
     */
    private Boton salir;
    /**
     * Método constructor del Menú.
     */
    public Menu(){
        
        restaurar();
    }
    
    /**
     * Esta clase restaura la ventana del menú cuando se elige la opción de "volver al menú" en el juego.
     */
    
    public void restaurar(){
        
        menu = new JPanel();

        this.add(menu,BorderLayout.CENTER);
        
        menu.setLayout(new GridLayout(6,1,0,10));
              
        inicioSingle = new Boton("Juego Individual",0,this);
        
        inicioMulti = new Boton("Juego Multijugador",1,this);
        
        verPuntajes = new Boton("Ver Mejores Puntajes",2,this);
        
        editarMapas = new Boton("Crear Mapas",3,this);
        
        ayuda = new Boton("Ayuda",4,this);
        
        salir = new Boton("Salir",5,this);

        menu.add(inicioSingle);
        
        menu.add(inicioMulti);
        
        menu.add(verPuntajes);
        
        menu.add(editarMapas);
        
        menu.add(ayuda);
        
        menu.add(salir);

        this.setResizable(false);
        this.setTitle("Grupo Dos: Snake v1.0");
        this.setSize(800,650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /**
     * Clase privada para los botones de la interfaz del menu.
     * 
     */
    
    private class Boton extends JButton implements ActionListener{
        /**
         * Variable para seleccionar la forma en que se utilizará el botón.
         */
        private int opcion;
        /**
         * Puntero al Menú.
         */
        private Menu menu;
        /**
         * Método constructor para los botones.
         * 
         * @param nombre Cadena de texto con el nombre del botón.
         * @param opcion Variable para seleccionar la forma en que se utilizará el botón.
         * @param menu Puntero al Menú.
         */
        public Boton(String nombre, int opcion, Menu menu){

            super(nombre);
            
            this.menu=menu;
            this.opcion=opcion;

            this.addActionListener(this);
        }
        /**
         * Método que controla las distintas acciones que realizan los botones.
         * 
         * @param e Evento de Acción.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            
            switch(opcion){
                
                case 0:

                    seleccionar = new Seleccionar(menu);
                    
                    dispose();
                    break;
                    
                case 1:
                    
                    interfaz = new Interfaz(menu,true,false,4,5,0);
                    interfaz.jugar();
                    
                    dispose();
                    break;
                    
                case 2:
                    
                    //No implementado aún
                    
                    break;
                    
                case 3:
                    
                    //No implementado aún
                    
                    break;
                    
                case 4:
                    
                    menuAyuda = new Ayuda(menu);
                    
                    dispose();
                    
                    break;
                
                case 5:
                    
                    System.exit(0);
                    break;
            }
        }
    }
}