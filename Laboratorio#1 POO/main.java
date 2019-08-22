/*
Joan Sanchez Chinchilla
carnet: 2015123867

Laboratorio #1 de Programacion Orientada a Objetos
*/
package laboratorio1;

//Clase main del programa donde se prueban las demas clases.
public class main {   
  
    public static void main(String[] args) {
        //Se crean los objetos cuenta y Atm
        Cuenta cuenta1 = new Cuenta(1122,500000);    //Se agregan valores al constructor
        Cuenta cuenta2 = new Cuenta(1234,1980350);
        ATM cajero = new ATM();
        
        System.out.println("Laboratorio#1\n\nEjercicio 2, prueba de la clase Cuenta.\n");
        
        //Se deposita,se retira y se solicita informacion de la cuenta 1
        cuenta1.depositarDinero(150000);
        cuenta1.retirarDinero(200000);
        cuenta1.informacionDeLaCuenta();
        
        //Se imprime la informacion de la cuenta 2
        cuenta2.informacionDeLaCuenta();
        
        System.out.println("Ejercicio 3, prueba de la clase ATM.\n");
        
        //Se llama a los metodos de la clase ATM para iniciar correctamente el cajero automatico
        cajero.crearCuentas();
        cajero.solicitarId();
    }
    
}
