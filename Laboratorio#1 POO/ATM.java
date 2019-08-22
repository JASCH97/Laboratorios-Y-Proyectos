/*
Clase ATM o cajero automatico
En esta clase se crean 10 cuentas bancarias con un balance de 100000 colones c/u
El id de las cuentas corresponden a los numeros del 0 al 9.
La clase cuenta con un menu interactivo con el usuario y recursivo de manera infinita,
de esta forma el usuario podra verficiar el estado de las cuentas, depositarles o
retirar dinero de ellas.
 */

package laboratorio1;

import java.util.Scanner;  //Se hace uso de la biblioteca Scanner para lo que ingrese el usuario

public class ATM {
    //Se crea el arreglo para las cuentas
    Cuenta[] cuentas = new Cuenta[10];
    Scanner entrada = new Scanner(System.in); //Se utiliza scanner para lo que ingrese el usuario por consola
    
    // Metodo que se encarga de agregar las 10 cuentas al arreglo por medio de un ciclo
    public void crearCuentas(){
        
        for(int i = 0 ; i<10 ; i++){
            Cuenta cuenta  = new Cuenta(i,100000);
            cuentas[i] = cuenta;           
        }
    }
    
    //Metodo que solicita al usuario un id y lo verifica
    public void solicitarId(){
        System.out.print("Ingrese su id: ");
        int id = entrada.nextInt();     //Se almacena lo que el usuario ingresa
        
        if(id < 0 || id > 9){     //Validacion del id
            System.out.println("Ha ingresado un id incorrecto...");
            solicitarId();
        }
        
        else{
            menuDeConsola(id);  //Si el id es correcto se llama al metodo menuDeConsola
        }
    }
    
    //Metodo que contiene el menu interactivo recursivo. Recibe como parametro el id verificado.
    public void menuDeConsola(int id){
        
        //Variable de tipo String que se usa como menu
        String menu = "\nMenu Principal\n1.Ver el balance actual\n" +
                "2.Retirar Dinero\n3.DepositarDinero\n4.Salir\n---> ";
        System.out.print(menu);
        int opcion = entrada.nextInt();  //Se almacena la opcion que elija el usuario
        
        //Si la opcion es 1, se imprime el balance la cuenta en colones
        if(opcion == 1){  
            System.out.println("El balance es de: " + "₡" + cuentas[id].getBalance());
            menuDeConsola(id); //Llamada recursiva
        }
        
        //Si la opcion es 2, se retira dinero de la cuenta
        if(opcion == 2){
            System.out.print("Ingrese el monto a retirar: ");
            double monto = entrada.nextDouble();
            cuentas[id].retirarDinero(monto);
            menuDeConsola(id); //Llamada recursiva
        }
        
        //Si la opcion es 3, se deposita dinero a la cuenta
        if(opcion == 3){
            System.out.print("Ingrese el monto a depositar: ");
            double monto = entrada.nextDouble();
            cuentas[id].depositarDinero(monto);
            menuDeConsola(id); //Llamada recursiva
        }
        
        //Si la opcion es 4, se solicita otro id
        if(opcion == 4){
            System.out.println("");
            solicitarId();
        }
        
        //Validacion por si el usuario no ingresa los valores indicados por el menu
        else{
            System.out.println("Ha ingresado una opcion invalida. Intente de nuevo...");
            menuDeConsola(id); //Llamada recursiva
        }       
        
    }
}
