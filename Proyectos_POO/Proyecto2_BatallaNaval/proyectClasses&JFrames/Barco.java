/*
PROYECTO #2 - BATALLA NAVAL
INGENIERIA EN COMPUTACION
INSTITUTO TECNOLOGICO DE COSTA RICA
PROGRAMACION ORIENTADA A OBJETOS
II SEMESTRE 2019
INTEGRANTES: 
            -ALEXANDER ARTAVIA QUESADA
            -JOAN SANCHEZ CHINCHILLA
            -ARMANDO CASTRO RUIZ
PROFESORA:
            -SAMANTA RAMIJAN
*/


package proyecto2_batallanaval;

//Se importan bibliotecas para el uso de colores 
import java.awt.Color;
import static java.awt.Color.white;

//Clase abstracta simple de un barco 
public abstract class Barco {
    //Atributos
    private int tamano;
    private Color color;

    
    //Constructor por defecto
    public Barco(){
        setTamano(0);
        setColor(white);   
    }
    
    //Constructor con parametros
    public Barco(int tamano, Color color){
        setTamano(tamano);
        setColor(color);
        
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
