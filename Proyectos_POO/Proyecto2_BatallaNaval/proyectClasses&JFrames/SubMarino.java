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

import static java.awt.Color.green;

//Esta clase representa un submarino que extiende de la clase barco
public class SubMarino extends Barco {
    
    public SubMarino(){
        super(3,green);    //Se invoca el constructor de la superclase
    }
}
