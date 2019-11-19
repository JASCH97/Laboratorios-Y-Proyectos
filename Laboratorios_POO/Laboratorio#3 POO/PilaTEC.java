
package lab3poo;

import java.util.Scanner;
import java.util.ArrayList;

public class PilaTEC extends ArrayList {
    //Atributos que representan 5 numeros
    private int N1,N2,N3,N4,N5;
    
    //Getters & Setters
    public int getN1() {
        return N1;
    }

    public void setN1(int N1) {
        this.N1 = N1;
    }

    public int getN2() {
        return N2;
    }

    public void setN2(int N2) {
        this.N2 = N2;
    }

    public int getN3() {
        return N3;
    }

    public void setN3(int N3) {
        this.N3 = N3;
    }

    public int getN4() {
        return N4;
    }

    public void setN4(int N4) {
        this.N4 = N4;
    }
    
    public int getN5() {
        return N5;
    }

    public void setN5(int N5) {
        this.N5 = N5;
    }
    
    //Metodo que solicita los 5 numeros al usuario y los agrega a la lista
    public void solicitarNumeros(){
        Scanner ingreso = new Scanner(System.in);  //Uso de scanner para las entradas del usuario

        System.out.print("Ingrese el primer número: ");
        setN1(ingreso.nextInt());
        add(getN1()); //Se agrega el numero ingresado a la lista
        
        System.out.print("Ingrese el segundo número: ");
        setN2(ingreso.nextInt());
        add(getN2());
        
        System.out.print("Ingrese el tercer número: ");
        setN3(ingreso.nextInt());
        add(getN3());
        
        System.out.print("Ingrese el cuarto número: ");
        setN4(ingreso.nextInt());
        add(getN4());
        
        System.out.print("Ingrese el quinto número: ");
        setN5(ingreso.nextInt());
        add(getN5());
        System.out.printf("Los numeros ingresados son: %d - %d - %d - %d - %d\n",getN1(),getN2(),getN3(),getN4(),getN5());

    }
    
    //Metodo que invierte la lista y la muestra
    public void invertirLista(){
        System.out.println("\n...Actualizando los valores...\n");
        //Se remueven los elementos de la lista
        remove(size()-1);
        remove(size()-1);
        remove(size()-1);
        remove(size()-1);
        remove(size()-1);
        //Se agregan los elementos a la lista con el nuevo orden inverso
        add(getN5());
        add(getN4());
        add(getN3());
        add(getN2());
        add(getN1());
        System.out.println("La lista invertida es: " + toString()); //Uso de toString para mostrar la pila
    }
} 
