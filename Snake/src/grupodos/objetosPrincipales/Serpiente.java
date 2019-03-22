package grupodos.objetosPrincipales;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
/**
 * 
 * Clase Serpiente que crea, permite mover, hacer crecer y mostrar en pantallala la Serpiente.
 * 
 * @author Leonardo Aravena Cuevas
 */
public class Serpiente {
    
    /**
     * Coordenada 'x' de la ubicación de la serpiente.
     */
    private int x;
    /**
     * Coordenada 'y' de la ubicación de la serpiente.
     */
    private int y;
    /**
     * Coordenada 'x' de la ubicación inicial de la serpiente.
     */
    private int xi;
     /**
     * Coordenada 'x' de la ubicación inicial de la serpiente.
     */
    private int yi;
    /**
     * Polígono para cada cuadrado que compone la serpiente.
     */
    private Polygon cuadrado;
    /**
     * Polígono auxiliar para mostrar en pantalla la serpiente.
     */
    private Polygon aux;
    /**
     * Tamaño de cada cuadrado que compone la serpiente.
     */
    private int tamano;
    /**
     * Arreglo que contiene todos los polígonos que componen la serpiente.
     */
    private ArrayList cuerpo;
    /**
     * Indica cuando el jugador pierde al chocar.
     */
    private boolean morir;  
    /**
     * Indica cuando la serpiente choca con su cuerpo con algún bloque del escenario.
     */
    private boolean choque;
    /**
     * Indica si la serpiente se mueve o crece.
     */
    private boolean mover;
    /**
     * Coordenada 'x' del primer punto correspondiente al cuadrado que forma la cabeza de la serpiente.
     */
    private int p1x;
    /**
     * Coordenada 'y' del primer punto correspondiente al cuadrado que forma la cabeza de la serpiente.
     */
    private int p1y;
    /**
     * Coordenada 'x' del segundo punto correspondiente al cuadrado que forma la cabeza de la serpiente.
     */
    private int p2x;
    /**
     * Coordenada 'y' del segundo punto correspondiente al cuadrado que forma la cabeza de la serpiente.
     */
    private int p2y;
    /**
     * Coordenada 'x' del tercer punto correspondiente al cuadrado que forma la cabeza de la serpiente.
     */
    private int p3x;
    /**
     * Coordenada 'y' del tercer punto correspondiente al cuadrado que forma la cabeza de la serpiente.
     */
    private int p3y;
    /**
     * Coordenada 'x' del cuarto punto correspondiente al cuadrado que forma la cabeza de la serpiente.
     */
    private int p4x;
    /**
     * Coordenada 'y' del cuarto punto correspondiente al cuadrado que forma la cabeza de la serpiente.
     */
    private int p4y;
    
    private boolean multijugador;
    
    /**
     * Método constructor que recibe las coordenadas iniciales de ubicación de la serpiente.
     * 
     * @param xi Coordenada 'x' de la ubicación inicial de la serpiente.
     * @param yi Coordenada 'y' de la ubicación inicial de la serpiente.
     */
    public Serpiente(int xi, int yi, boolean multijugador){
        
        this.multijugador=multijugador;
        
        tamano=10;
        
        cuerpo = new ArrayList();
        
        this.xi=xi;
        this.yi=yi;
        
        iniciar();
        
        morir=true;
    }
    
    /**
     * Método que crea los primeros tres cuadrados en fila que componen a la serpiente.
     */
    public void iniciar(){
        
        cuerpo.clear();
        
        x=xi;
        y=yi;
        
        cuadrado = new Polygon();
        
        cuadrado.addPoint(x,y);
        cuadrado.addPoint(x,y+tamano);
        cuadrado.addPoint(x+tamano,y+tamano);
        cuadrado.addPoint(x+tamano,y);
        
        cuerpo.add(cuadrado);
        
        cuadrado = new Polygon();

        cuadrado.addPoint(x+tamano,y);
        cuadrado.addPoint(x+tamano,y+tamano);
        cuadrado.addPoint(x+2*tamano,y+tamano);
        cuadrado.addPoint(x+2*tamano,y);
        
        cuerpo.add(cuadrado);
        
        cuadrado = new Polygon();

        cuadrado.addPoint(x+2*tamano,y);
        
        p1x=x+2*tamano;
        p1y=y;

        cuadrado.addPoint(x+2*tamano,y+tamano);
        
        p2x=x+2*tamano;
        p2y=y+tamano;
        
        cuadrado.addPoint(x+3*tamano,y+tamano);
        
        p3x=x+3*tamano;
        p3y=y+tamano;
        
        cuadrado.addPoint(x+3*tamano,y);
        
        p4x=x+3*tamano;
        p4y=y;
        
        cuerpo.add(cuadrado);
    }
    /**
     * Método para mover y hacer crecer la serpiente. 
     * El movimiento de la serpiente consiste en mover el primer polígono que compone la serpiente (la cola)
     * delante de la ubicación del último polígono (la cabeza). Para crecer es lo mismo, con la diferencia de que se copia, no se mueve,
     * el polígono, aumentando la cantidad.
     *
     * @param movimiento La dirección en la que se mueve la serpiente.
     * @param modo Indica si es un movimiento o crecimiento.
     * @return Devuelve 'true' si la serpiente creció para aumentar el puntaje.
     */
    public boolean moverCrecer(int movimiento, boolean modo){

        mover=true;
            
        switch(movimiento){
            
            case 1:
                p1y-=tamano;
                p2y-=tamano;
                p3y-=tamano;
                p4y-=tamano;
                break;
                
            case 2:
                p1y+=tamano;
                p2y+=tamano;
                p3y+=tamano;
                p4y+=tamano;
                break;
                
            case 3:
                
                p1x-=tamano;
                p2x-=tamano;
                p3x-=tamano;
                p4x-=tamano;
                break;
                
            case 4:
                p1x+=tamano;
                p2x+=tamano;
                p3x+=tamano;
                p4x+=tamano;
                break;
        }
        
        if (!modo){
            
            cuerpo.remove(0);
            mover=false;
        }
        
        if(p1x==0 && p2x==0){
            
            p1x=800;
            p2x=800;
            p3x=810;
            p4x=810;
        }
        
        else if(p1x==800 && p2x==800){
            
            p1x=0;
            p2x=0;
            p3x=-10;
            p4x=-10;
        }
        
        if(p1y==0 && p4y==0){
            
            p1y=590;
            p4y=590;
            p2y=600;
            p3y=600; 
        }
        
        else if(p1y==590 && p4y==590){
            
            p1y=0;
            p4y=0;
            p2y=-10;
            p3y=-10;
        }
        
        cuadrado=new Polygon();
        
        cuadrado.addPoint(p1x,p1y);
        cuadrado.addPoint(p2x,p2y);
        cuadrado.addPoint(p3x,p3y);
        cuadrado.addPoint(p4x,p4y);
        
        cuerpo.add(cuadrado);
        
        return(mover);
    }
    /**
     * Método que entrega el cuadrado correspondiente al polígono que forma la cabeza de la serpiente.
     * 
     * @return Devuelve el cuadrado correspondiente a la cabeza de la serpiente.
     */
    public Rectangle2D ubicacion(){

        return(cuadrado.getBounds2D());
    }
    
    /**
     * Método que comprueba si la cabeza de la serpiente choca con el resto de su cuerpo.
     * 
     * @param rectangulo Recibe el cuadrado que correspondiente a la cabeza de la serpiente.
     * @return Devuelve 'true' si el cuadrado que contiene la cabeza de la serpiente choca con su cuerpo.
     */
    
    public boolean chocaCuerpo(Rectangle2D rectangulo){
        
        choque= false;
        
        for(int i=0; i<cuerpo.size()-1; ++i){
            
            aux=(Polygon)cuerpo.get(i);
            
            if(aux.contains(rectangulo)){
                
                choque=true;
                break;
            }
        }
        
        return(choque);
    }
    
    /**
     * Método para cambiar el estado de la variable que indica si la serpiente muere.
     */
    public void morir(){
        
        morir = !morir;
    }
    /**
     * Método para mostrar la serpiente en pantalla, cambiando el color cuando esta muere.
     * @param g Clase Graphics.
     */
    public void paint(Graphics g){

        for(int i=0; i<cuerpo.size(); ++i){
            
            aux=(Polygon)cuerpo.get(i);
            
            //Color de la cabeza:
            if(i==cuerpo.size()-1 && morir && !multijugador){
                
                g.setColor(new Color(0,153,0));
            }
            
            else if(i==cuerpo.size()-1 && morir && multijugador){
                
                g.setColor(new Color(0,76,153));
            }
            
            //Color del cuerpo:
            else if (morir && !multijugador){
                
                g.setColor(new Color(0,204,0));
            }
            
            else if (morir && multijugador){
                
                g.setColor(new Color(0,128,255));
            }
            
            
            else if(i==cuerpo.size()-1 &&!multijugador) {
                
                g.setColor(new Color(51,51,0));
            }
            
            else if(i==cuerpo.size()-1 &&multijugador) {
                
                g.setColor(new Color(0,51,51));
            }
            
            else if(!multijugador){
                
                g.setColor(new Color(102,102,0));
            }
            
            else if(multijugador){
                
                g.setColor(new Color(0,102,102));
            }
            
            g.fillPolygon(aux);
        }
    }
}

