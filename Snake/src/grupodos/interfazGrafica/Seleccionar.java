package grupodos.interfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Clase Seleccionar para mostrar un menú y seleccionar entre las dos formas de jugar en el Modo Individual, con sus respectivas opciones.
 * @author Leonardo Aravena Cuevas
 */
public class Seleccionar extends JFrame{
    /**
     * Variable para crear la interfaz que contiene al panel del juego.
     */
    private Interfaz interfaz;
    /**
     * Puntero al menu principal.
     */
    private Menu menu;
    /**
     * Panel principal que contiene los elementos de la ventana.
     */
    private JPanel panelPrincipal;
    
    private JPanel panel2;
    
    private JPanel panel3;
    
    private JPanel panel4;
    
    private JPanel panel5;
    
    private JPanel panel6;
    
    private JPanel panel7;
    
    private JPanel panelBoton1;
    
    private JPanel panelBoton2;
    
    private JPanel panelBoton3;
    
    private JPanel panelBoton4;
    
    private JPanel panelBoton5;
    
    private JPanel panelBoton6;
    
    private JLabel texto1;
    
    private JLabel texto2;
    
    private JLabel texto3;
    
    private JLabel texto4;
    
    private JLabel vel;
    
    private JLabel niv;
    
    private JLabel obj;
    
    private BotonVelocidad velocidadMas;
    
    private BotonVelocidad velocidadMenos;
    
    private BotonNivel nivelMas;
    
    private BotonNivel nivelMenos;
    
    private BotonObjetivo objetivoMas;
    
    private BotonObjetivo objetivoMenos;
    
    private BotonRadial rotativo;
    
    private BotonRadial fijo;
    
    private ButtonGroup botonesRadial;
    
    private BotonConfirmar aceptar;
    
    private BotonConfirmar volver;
    
    private boolean modo;
    
    private int velocidad;
    
    private int nivel;
    
    private int objetivo;
    
    /**
     * Método constructor que recibe el puntero del menú principal
     * @param menu Puntero al menú principal.
     */
    public Seleccionar(Menu menu){
        
        this.menu=menu;
       
        velocidad=1;
        
        nivel=1;
        
        objetivo=30;
        
        modo=true;
        
        panelPrincipal = new JPanel();
        
        this.add(panelPrincipal,BorderLayout.CENTER);
        
        panelPrincipal.setLayout(new GridLayout(6,1,5,0));
        
        panel2= new JPanel();
        
        texto1= new JLabel("Seleccione el Modo de Juego:",JLabel.CENTER);
        
        panel2.add(texto1);
        
        panel3= new JPanel();
        
        panel4= new JPanel();
        
        texto4= new JLabel("Seleccione el Objetivo:",JLabel.CENTER);
        
        obj= new JLabel("30",JLabel.CENTER);
        
        obj.setBackground(Color.WHITE);
        obj.setOpaque(true);
        
        panelBoton5 = new JPanel();
        
        panelBoton6 = new JPanel();
        
        objetivoMas = new BotonObjetivo("+",true);
        
        objetivoMenos = new BotonObjetivo("-",false);
        
        panelBoton5.add(objetivoMas);
        panelBoton6.add(objetivoMenos);
        
        panel4.add(panelBoton6);
        panel4.add(obj);
        panel4.add(panelBoton5);

        botonesRadial = new ButtonGroup();
        
        rotativo = new BotonRadial("Rotativo", true);
        
        fijo = new BotonRadial("Fijo", false);
        
        botonesRadial.add(rotativo);
        botonesRadial.add(fijo);
        rotativo.setSelected(true);
        
        panel3.add(rotativo);
        panel3.add(fijo);
        
        panelPrincipal.add(panel2);
        panelPrincipal.add(panel3);
        
        
        
        texto2= new JLabel("Seleccione Velocidad:",JLabel.CENTER);
        
        texto3= new JLabel("Seleccione Nivel:", JLabel.CENTER);
        
        vel = new JLabel("1",JLabel.CENTER);
        
        niv = new JLabel("1",JLabel.CENTER);
        
        vel.setBackground(Color.WHITE);
        vel.setOpaque(true);
        
        niv.setBackground(Color.WHITE);
        niv.setOpaque(true);
        
        panelBoton1= new JPanel();
        
        panelBoton2= new JPanel();
        
        panelBoton3= new JPanel();
        
        panelBoton4= new JPanel();

        velocidadMas = new BotonVelocidad("+", true);
        
        velocidadMenos = new BotonVelocidad("-",false);
        
        nivelMas = new BotonNivel("+", true);
        
        nivelMenos = new BotonNivel("-", false);
        
        panelBoton1.add(velocidadMas);
        panelBoton2.add(velocidadMenos);
        
        panelBoton3.add(nivelMas);
        panelBoton4.add(nivelMenos);
        
        panel6= new JPanel();
        
        panel6.add(panelBoton2);
        panel6.add(vel);
        panel6.add(panelBoton1);
        
        panel7= new JPanel();
        
        panel7.add(panelBoton4);
        panel7.add(niv);
        panel7.add(panelBoton3);
        
        panel5 = new JPanel();
        
        panel5.setLayout(new GridLayout(2,3));
        
        panel5.add(texto4);
        panel5.add(texto2);
        panel5.add(texto3);
        
        panel5.add(panel4);
        panel5.add(panel6);
        panel5.add(panel7);
        panelPrincipal.add(panel5);

        panel6= new JPanel();
        
        aceptar= new BotonConfirmar("Aceptar",true,velocidad,nivel,objetivo);
        volver= new BotonConfirmar("Volver",false,velocidad, nivel,objetivo);
        
        panel6.add(aceptar);
        panel6.add(volver);
        
        panelPrincipal.add(panel6);
        
        velocidadMenos.setEnabled(false);
        velocidadMas.setEnabled(false);
        
        nivelMenos.setEnabled(false);
        nivelMas.setEnabled(false);
    
        this.setResizable(false);
        this.setTitle("Grupo Dos: Snake v1.0");
        this.setSize(800,650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    /**
     * Clase privada para los botones para aumentar o disminuir la velocidad de la serpiente en el modo "Fijo".
     */
    private class BotonVelocidad extends JButton implements ActionListener{
        /**
         * Identifica si el botón es para aumentar o disminuir la velocidad de movimiento de la serpiente.
         */
        private boolean tipo;

        /**
         * Método constructor del botón que recibe el nombre y como se usa.
         * @param nombre Cadena de texto con el nombre del botón
         * @param tipo Indica si se usa para aumentar o disminuir la velocidad de movimiento de la serpiente.
         */
        public BotonVelocidad(String nombre, boolean tipo){
            
            super(nombre);

            this.tipo=tipo;

            this.addActionListener(this);
        }
        /**
         * Aumenta o disminuye la velocidad de movimiento de la serpiente cuando se pulsa el botón, 
         * mostrando el valor en la etiqueta de velocidad.
         * @param e Evento de Acción 
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(tipo){
                
                if(velocidad<5) velocidad++;
                
                else velocidad=1;
                
                vel.setText(""+velocidad);
            }
            
            else{
                
                if(velocidad>1) velocidad--;
                
                else velocidad=5;
                
                vel.setText(""+velocidad);
            }
        }
    }
    /**
     * Clase privada para los botones de selección de nivel en el modo "Fijo".
     */
    private class BotonNivel extends JButton implements ActionListener{
        /**
         * Identifica si el botón aumenta el número del nivel o lo disminuye.
         */
        private boolean tipo;
        /**
         * Método constructor del botón que recibe el nombre y como se usa
         * @param nombre Cadena de texto con el nombre del botón
         * @param tipo Indica si se usa para aumentar o disminuir el número del nivel.
         */
        public BotonNivel(String nombre, boolean tipo){
            
            super(nombre);
 
            this.tipo=tipo;

            this.addActionListener(this);
        }
        /**
         * Aumenta o disminuye el nñumero del nivel cuando se pulsa el botón, 
         * mostrando el valor en la etiqueta de nivel.
         * @param e Evento de Acción
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(tipo){
                
                if(nivel<5) nivel++;
                
                else nivel=1;
                
                niv.setText(""+nivel);
                
            }
            
            else{
                
                if(nivel>1) nivel--;
                
                else nivel=5;
                
                niv.setText(""+nivel);
            }
        }
    }
    
    /**
     * Clase privada para los botones que aumenta o disminuyen la cantidad de alimento 'objetivo' que se requiere para cambiar
     * de nivel en el modo "Rotativo".
     */
    private class BotonObjetivo extends JButton implements ActionListener{
        /**
         * Indica si el botón se usa para aumentar o disminuir la cantidad de alimento objetivo.
         */
        private boolean tipo;
        /**
         * 
         * @param nombre Cadena de texto con el nombre del botón
         * @param tipo Identifica si el botón se usa para aumentar o disminuir la cantidad de alimento objetivo.
         */
        public BotonObjetivo(String nombre, boolean tipo){
            
            super(nombre);
 
            this.tipo=tipo;

            this.addActionListener(this);
        }
        /**
         * Método que aumenta o disminuye la cantidad de alimento que se requiere para cambiar de nivel.
         * @param e Evento de Acción
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(tipo){
                
                if(objetivo<90) objetivo+=10;
                
                else objetivo=10;
                
                obj.setText(""+objetivo);
                
            }
            
            else{
                
                if(objetivo>10) objetivo-=10;
                
                else objetivo=90;
                
                obj.setText(""+objetivo);
            }
        }
    }
    
    /**
     * Clase privada para los botones de "Aceptar" o "Volver", que inician un nuevo juego individual con los parámetros configurados o 
     * vuelve al menú principal.
     */
    private class BotonConfirmar extends JButton implements ActionListener{
        /**
         * Identifica como se usa el botón.
         */
        private boolean tipo;
        /**
         * Método constructor.
         * 
         * @param nombre Cadena de texto para el nombre del botón
         * @param tipo Identifica como se usa el botón
         * @param velocidad Velocidad a la que se mueve la serpiente en el modo Fijo
         * @param nivel Nivel que se juega en el modo Fijo.
         * @param objetivo Cantidad de alimento requerido para cambiar de nivel en el modo Rotativo.
         */
        public BotonConfirmar(String nombre, boolean tipo, int velocidad, int nivel, int objetivo){
            
            super(nombre);
            this.tipo=tipo;
            
            this.addActionListener(this);
        }
        /**
         * Método que controla el comportamiento del botón. 
         * El botón "Aceptar" crea la interfaz con el panel de juego, el botón "Cancelar" vuelve al menú principal.
         * @param e Evento de Acción
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(tipo){
                
                interfaz = new Interfaz(menu,false,modo,velocidad,nivel,objetivo);
                interfaz.jugar();

                dispose();
            }
            
            else{
                
                dispose();
                menu.restaurar();
            }
        }
    }
    /**
     * Clase privada para los botones radiales que seleccionan el modo de juego individual.
     * El modo "Rotativo" permite ir avanzando por los cinco niveles a medida que se alcance la cantidad de alimento "objetivo".
     * El modo "Fijo" se juega en un sólo nivel y a una sóla la velocidad.
     */
    private class BotonRadial extends JRadioButton implements ActionListener{
        /**
         * Identifica el modo de juego Individual: "Rotativo" o "Fijo".
         */
        private boolean tipo;
        /**
         * Método contructor del botón radial.
         * @param nombre Cadena de texto con el nombre.
         * @param tipo Si es 'true' se juega en modo "Rotativo", en caso contrario se juega en modo "Fijo".
         */
        public BotonRadial(String nombre, boolean tipo){
            
            super(nombre);
            this.tipo=tipo;
            
            this.addActionListener(this);
        }
        /**
         * Método para configurar los modos de juego individual.
         * @param e Evento de Acción
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(tipo){
                
                velocidadMenos.setEnabled(false);
                velocidadMas.setEnabled(false);
                
                nivelMenos.setEnabled(false);
                nivelMas.setEnabled(false);
                
                objetivoMas.setEnabled(true);
                objetivoMenos.setEnabled(true);
                
                velocidad=1;
                nivel=1;
                
                modo=true;
            }
            
            else{
                velocidadMenos.setEnabled(true);
                velocidadMas.setEnabled(true);
                
                nivelMenos.setEnabled(true);
                nivelMas.setEnabled(true);
                
                objetivoMas.setEnabled(false);
                objetivoMenos.setEnabled(false);
                
                modo=false;
            }
        } 
    }
}
