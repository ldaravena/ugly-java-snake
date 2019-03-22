package grupodos.objetosPrincipales;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Clase Alimento que crea y controla el Alimento para la Serpiente.
 * 
 * @author Leonardo Aravena Cuevas
 */

public class Alimento {
    /**
     * Coordenada 'x' de ubicación del alimento.
     */
    private int x;
    /**
     * Coordenada 'y' de ubicación del alimento.
     */
    private int y;
    /**
     * Tamaño del alimento.
     */
    private int tamano;
    /**
     * Polígono que representa el alimento.
     */
    private Polygon alimento;
    /**
     * Número aleatorio usado para ubicar el alimento.
     */
    private Random azar;
    /**
     * Coordenada x obtenida según el número aleatorio.
     */
    private int xNuevo;
    /**
     * Coordenada y obtenida según el número aleatorio.
     */
    private int yNuevo;
    /**
     * Indica si el alimento fue comido por la serpiente.
     */
    private boolean comido;
    
    /**
     * Método constructor que recibe las coordendas de ubicación del alimento.
     * 
     * @param x Coordenada 'x' de la ubicación del alimento.
     * @param y Coordenada 'y' de la ubicación del alimento.
     */
    public Alimento(int x, int y){
        
        this.x=x;
        this.y=y;

        tamano=10;
        
        alimento= new Polygon();
        
        alimento.addPoint(x,y);
        alimento.addPoint(x, y+tamano);
        alimento.addPoint(x+tamano,y+tamano);
        alimento.addPoint(x+tamano, y); 
    }
    
    /**
     * Método que ubica en una posición aleatoria el nuevo alimento una vez comido.
     */
    public void reinicio(){
        
        azar=new Random();
            
        xNuevo=azar.nextInt(760);
        while(xNuevo%10!=0 || xNuevo <29){
                
            xNuevo++;
        }
            
        yNuevo=azar.nextInt(540);
            
        while(yNuevo%10!=0 || yNuevo <29){
                
            yNuevo++;
        }
            
        alimento.reset();
                    
        alimento.addPoint(xNuevo,yNuevo);
        alimento.addPoint(xNuevo,yNuevo+tamano);
        alimento.addPoint(xNuevo+tamano,yNuevo+tamano);
        alimento.addPoint(xNuevo+tamano,yNuevo); 
    }
    /**
     * Método que comprueba si el alimento es comido por la serpiente. 
     * 
     * @param rectangulo Recibe el rectangulo correspondiente a la cabeza de la serpiente.
     * @return comido - Devuelve 'true' si el rectangulo recibido está contenido en el alimento.
     */
    public boolean comido(Rectangle2D rectangulo){
        
        comido=false;
        
        if(alimento.contains(rectangulo)){
            
            comido=true;
            reinicio();      
        }
        
        return(comido);
    }
   /**
    * Método que entrega el rectangulo que contiene el polígono del alimento.
    * 
    * @return  Devuelve el rectangulo que contiene el polígono del alimento.
    */
    public Rectangle2D ubicacion(){

        return(alimento.getBounds2D());
    }
    
    /**
     * Método para mostrar el alimento en pantalla.
     * @param g Clase Graphics.
     */
    public void paint(Graphics g){
        
        g.setColor(new Color(153,0,0));
        g.fillPolygon(alimento);
    }  
}
