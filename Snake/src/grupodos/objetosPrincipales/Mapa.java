package grupodos.objetosPrincipales;

import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.*;

/**
 * 
 * Clase Mapa que crea los escenarios de juego de acuerdo al nivel correspondiente.
 * 
 * @author Leonardo Aravena Cuevas
 */

public class Mapa {
    /**
     * Bloques que constituyen el escenario.
     */
    private Obstaculo bloque;
    /**
     * Arreglo para contener todos los bloques.
     */
    private ArrayList mapa;
    /**
     * Variable para verificar si choca con algun bloque.
     */
    private boolean choque;
    
    /**
     * Método para seleccionar y mostrar en pantalla los distintos niveles.
     * 
     * @param nivel Recibe el número correspondiente al nivel a mostrar en pantalla.
     */
    public Mapa(int nivel){

        mapa= new ArrayList();
        
        switch (nivel) {
            
            case 0:
                
                bloque = new Obstaculo (130,70,30,440);
                mapa.add(bloque);
                
                bloque = new Obstaculo(650,70,30,440);
                mapa.add(bloque);
                
                bloque = new Obstaculo(210,150,390,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo(210,410,390,30);
                mapa.add(bloque);
                break;
                
            case 1:
                
                bloque = new Obstaculo (70,70,200,100);
                mapa.add(bloque);
                
                bloque = new Obstaculo (530,70,200,100);
                mapa.add(bloque);
                
                bloque = new Obstaculo (70,410,200,100);
                mapa.add(bloque);
                
                bloque = new Obstaculo (530,410,200,100);
                mapa.add(bloque);
                
                bloque = new Obstaculo (530,410,200,100);
                mapa.add(bloque);
                
                bloque = new Obstaculo (380,70,50,200);
                mapa.add(bloque);
                
                bloque = new Obstaculo (380,320,50,190);
                mapa.add(bloque);
                
                bloque = new Obstaculo (0,0,30,600);
                mapa.add(bloque);
                
                bloque = new Obstaculo (770,0,30,600);
                mapa.add(bloque);
                break;
                
            case 2:
                
                bloque = new Obstaculo (100,150,30,280);
                mapa.add(bloque);
                
                bloque = new Obstaculo (130,150,150,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo (130,400,150,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo (660,150,30,280);
                mapa.add(bloque);
                
                bloque = new Obstaculo (510,150,150,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo (510,400,150,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo (210,270,370,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo (220,60,370,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo (220,490,370,30);
                mapa.add(bloque);
                break;
                
            case 3:
                
                bloque = new Obstaculo (100,150,30,280);
                mapa.add(bloque);
                
                bloque = new Obstaculo (180,150,30,280);
                mapa.add(bloque);
                
                bloque = new Obstaculo (260,150,30,280);
                mapa.add(bloque);
                
                bloque = new Obstaculo (340,150,30,280);
                mapa.add(bloque);
                
                bloque = new Obstaculo (100,430,270,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo (370,150,320,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo (660,180,30,280);
                mapa.add(bloque);
                
                bloque = new Obstaculo (580,180,30,280);
                mapa.add(bloque);
                
                bloque = new Obstaculo (500,180,30,280);
                mapa.add(bloque);
                
                bloque = new Obstaculo (0,0,800,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo (0,560,800,30);
                mapa.add(bloque);
                break;
                
            case 4:
                
                bloque = new Obstaculo(0,0,800,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo(0,560,800,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo(0,30,30,530);
                mapa.add(bloque);
                
                bloque = new Obstaculo(770,30,30,530);
                mapa.add(bloque);
                
                bloque = new Obstaculo(380,60,30,470);
                mapa.add(bloque);
                
                bloque = new Obstaculo(60,280,680,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo(200,180,30,230);
                mapa.add(bloque);
                
                bloque = new Obstaculo(580,180,30,230);
                mapa.add(bloque);
                
                break;
            
            //Mapa Multijugador
            case 5:
                
                bloque = new Obstaculo(0,0,200,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo(0,560,200,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo(0,30,30,200);
                mapa.add(bloque);
                
                bloque = new Obstaculo(0,360,30,200);
                mapa.add(bloque);
                
                bloque = new Obstaculo(600,0,200,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo(600,560,200,30);
                mapa.add(bloque);
                
                bloque = new Obstaculo(770,30,30,200);
                mapa.add(bloque);
                
                bloque = new Obstaculo(770,360,30,200);
                mapa.add(bloque);
                
                break;
                
        }
    }
    
    /**
     * Método para comprobar si la serpiente choca con algún bloque del escenario.
     * 
     * @param rectangulo Recibe el rectangulo correspondiente a la cabeza de la serpiente.
     * @return Devuelve 'true' si el rectangulo recibido está contenido en algún bloque del escenario.
     */
    public boolean choqueMapa(Rectangle2D rectangulo){
        
        choque=false;
        
        if (mapa!=null){
            
            for(int i=0; i<mapa.size(); i++){
            
                bloque=(Obstaculo)mapa.get(i);
            
                choque = bloque.choque(rectangulo);
                if(choque) break;
            }
        }
        
        return(choque);
    }
    /**
     * Método para mostrar el escenario en pantalla.
     * @param g Clase Graphics.
     */
    public void paint(Graphics g){
        
        if(mapa!=null){
            
            for(int i=0; i<mapa.size(); i++){
            
                bloque=(Obstaculo)mapa.get(i);
            
                bloque.paint(g);
            }
        }
    }

}
