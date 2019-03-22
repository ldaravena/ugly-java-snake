package grupodos.interfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase Ayuda para mostrar el menú de Ayuda con las instrucciones del juego.
 * @author Leonardo Aravena Cuevas
 */
public class Ayuda extends JFrame{
    /**
     * Puntero al Menu.
     */
    private Menu menu;
    /**
     * Panel que contiene la etiqueta de texto y el panel del botón 'volver'.
     */
    private JPanel panelPrincipal;
    /**
     * Etiqueta de texto que contiene las instrucciones.
     */
    private JLabel textoAyuda;
    /**
     * Panel que contiene al botón 'volver'.
     */
    private JPanel panelBoton;
    /**
     * Botón para volver al menú principal.
     */
    private BotonVolver volver;
    /**
     * Cadena de texto con las instrucciones.
     */
    private String texto;
    /**
     * Método constructor del menu de ayuda que recibe el puntero del Menú del juego.
     * @param menu Menu que contiene a esta clase.
     */
    public Ayuda(Menu menu){
        
        texto= "<html><body>CONCEPTOS BÁSICOS<br>En el juego usted controla una serpiente que tiene como objetivo recoger"
                + " el alimento (de color rojo) que se encuentra en el escenario y así crecer, evitando chocar con los obstaculos del escenario (de color gris) o con la cola.<br>Los movientos de la serpiente se controlan usando las flechas direccionales.<br><br>"
                + " JUEGO INDIVIDUAL<br>En este modo puede elegir entre dos opciones: 'Rotativo' o 'Fijo'<br>"
                + "En el modo 'Rotativo' la serpiente se mueve a una velocidad inicial y cada vez que come la cantidad de alimento 'objetivo' se avanza al siguiente nivel. Cuando recorre"
                + " los 5 niveles aumenta la velocidad de movimiento. Puede usar los botones '+' y '-' para cambiar "
                + "la cantidad de alimento que se requiere para avanzar al siguiente nivel. Por defecto el objetivo es 30.<br> "
                + "En el modo 'Fijo' se juega en un sólo nivel y a una sóla velocidad que puede seleccionar usando los botones'+' y '-' correspondientes.<br><br>"
                + "JUEGO MULTIJUGADOR<br>En este modo compiten dos jugadores por el alimento. El jugador 1 mueve la serpiente de color verde con las flechas direccionales y el jugador 2 mueve la serpiente"
                + " azul con las teclas 'w','a','s' y 'd.'<br><br>"
                + "Las opciones de 'Ver Mejores Puntajes' y 'Crear Mapas' no están habilitadas en esta versión.<br><br></body></html>";
        
        
        this.menu= menu;
        
        panelPrincipal= new JPanel();
        
        this.add(panelPrincipal,BorderLayout.CENTER);
        
        panelPrincipal.setLayout(new GridLayout(2,1));
        
        
        textoAyuda=new JLabel(texto);
        
        panelBoton= new JPanel();
        
        volver=new BotonVolver("Aceptar");
        
        panelPrincipal.add(textoAyuda);
        panelBoton.add(volver);
        
        panelPrincipal.add(panelBoton);
        
        this.setResizable(false);
        this.setTitle("Grupo Dos: Snake v1.0");
        this.setSize(800,650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    /**
     * Clase privada para el botón de regreso al menú principal.
     */
    private class BotonVolver extends JButton implements ActionListener{
        /**
         * Método constructor del Boton que recibe el nombre.
         * @param nombre Cadena de texto que corresponde al nombre del botón.
         */
        public BotonVolver(String nombre){
            
            super(nombre);
            this.addActionListener(this);
        }
        /**
         * Método para volver al menú principal.-
         * @param e Evento de Acción.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
            menu.restaurar();
            
            
        }

    }
}
