package grupodos.objetosPrincipales;

import java.awt.*;
import java.awt.geom.*;

/**
 * 
 * Clase Obstaculo que crea los bloques que componen los escenarios del juego.
 * 
 * @author Leonardo Aravena Cuevas
 */

public class Obstaculo {
    
    /**
     * Coordenada 'x' de la ubicación del bloque.
     */
    private int x;
    /**
     * Coordenada 'y' de la ubicación del bloque.
     */
    private int y;
    /**
     * Tamaño del ancho del bloque.
     */
    private int ancho;
    /**
     * Tamaño del largo del bloque.
     */
    private int largo;
    /**
     * Polígono del bloque.
     */
    private Polygon bloque;
    
    /**
     * Método Constructor que recibe las coordenadas de ubicación y las dimensiones del bloque.
     * 
     * @param x Coordenada 'x' de la ubicación del bloque.
     * @param y Coordenada 'y' de la ubicación del bloque.
     * @param ancho Tamaño del ancho del bloque.
     * @param largo Tamaño del largo del bloque.
     */
    public Obstaculo(int x, int y, int ancho, int largo){
        
        this.x=x;
        this.y=y;
        this.ancho=ancho;
        this.largo=largo;
        
        bloque= new Polygon();
        
        bloque.addPoint(x, y);
        
        bloque.addPoint(x, y+largo);
        
        bloque.addPoint(x+ancho, y+largo);
        
        bloque.addPoint(x+ancho, y);
    }
    /**
     *  Método para comprobar si la serpiente choca con el bloque.
     * 
     * @param rectangulo Recibe el rectangulo correspondiente a la cabeza de la serpiente.
     * @return Devuelve 'true' si el rectangulo recibido está contenido en el bloque.
     */
    public boolean choque(Rectangle2D rectangulo){
        
        return(bloque.contains(rectangulo));
    }
    /**
     * Método para mostrar el bloque en pantalla.
     * @param g Clase Graphics.
     */
    public void paint(Graphics g){
        
        g.setColor(new Color(128,128,128));
        g.fillPolygon(bloque);
    } 
}

