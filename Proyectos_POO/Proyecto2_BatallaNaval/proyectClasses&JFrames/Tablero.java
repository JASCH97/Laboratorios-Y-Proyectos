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
//Biblioteca para el uso de arreglos
import java.util.ArrayList;

//Clase abstacta de un tablero que consta de una matriz[10][10]
public abstract class Tablero {
   //Atrubutos
    private String[][] casillas = new String[10][10];
   //Se crean dos arreglos donde se van a almacenar coordenadas para acceder a posiciones de la matriz 
    ArrayList<Integer> coordenadasI = new ArrayList<>();
    ArrayList<Integer> coordenadasJ = new ArrayList<>();

    //Constructor por defecto
    public Tablero(){
        llenarTablero();
    }

    public String getCasillas(int fila, int columna) {
        return casillas[fila][columna];
    }

    public void setCasillas(String casilla, int fila, int columna) {
        this.casillas[fila][columna] = casilla;
    }
    
    //Metodo que llena de " " la matriz que forma el tablero 
    public void llenarTablero(){
        int i = 0, j = 0;
        
        while(i < 10){
            j = 0;
            while(j < 10){
                casillas[i][j] = "";
                j++;
            }
          
            i++;
        }
       
    }

   
    
}
