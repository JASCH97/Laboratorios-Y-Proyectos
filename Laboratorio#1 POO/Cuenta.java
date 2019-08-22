/*
 Clase Cuenta
 Se encarga de crear una cuenta bancaria con datos importantes como:
 El "id" o numero de identificacion, "balance" o dinero y una tasa de interes mensual
 La clase tambien permite retirar o depositar dinero a la cuenta
 */
package laboratorio1;

import java.util.Date; //libreria utilizada para obtener la fecha y hora actual
                       //tomada de https://docs.oracle.com/javase/6/docs/api/java/util/Date.html


public class Cuenta {
    //Atributos
    private int id;
    private double balance,tasaDeInteresAnual;
    private Date fechaDeCreacion;
    
    //De la linea 20 a la 44 se encuentran los metodos set y get de los atibutos.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTasaDeInteresAnual() {
        return tasaDeInteresAnual;
    }

    public void setTasaDeInteresAnual(double tasaDeInteresAnual) {
        this.tasaDeInteresAnual = tasaDeInteresAnual;
    }
    
    public Date getFechaDeCreacion() {
        java.util.Date fechaDeCreacion = new Date();  //Se hace uso de la biblioteca para
        return fechaDeCreacion;                       //obtener la fecha y hora
    }
    
    //Constructor predeterminado 
    public Cuenta(){
        setId(0);
        setBalance(0);
        setTasaDeInteresAnual(0);
    }
    
    //Constructor con parametros id y balance
    public Cuenta(int id, double balance){
        setId(id);
        setBalance(balance);
        setTasaDeInteresAnual(4.5);  //se asume el mismo porcentaje de interes para las cuentas
    }
    
    //Metodo para obtener la Tasa de Interes Mensual
    public double obtenerTasaDeInteresMensual(){
        return calcularInteresMensual();
        
    }
    //Metodo que se encarga de calcular la Tasa de interes Mensual
    public double calcularInteresMensual(){
        return ( balance * tasaDeInteresAnual ) /10;
    
    }
    
    //Metodo que se encarga de retirar dinero de la cuenta bancaria
    public void retirarDinero(double dinero){
        if(balance == 0 || dinero > balance){
            System.out.println("No cuenta con suficientes fondos para retirar...");
        }
        else{
        setBalance(balance - dinero);
        }
    }
    
    //Metodo que se encarga de depositar dinero en la cuenta bancaria
    public void depositarDinero(double dinero){
        setBalance(balance + dinero);
    
    }
    
    //Metodo que se encarga de imprimir en pantalla la informacion de la cuenta:
    //El balance,La tasa de interes mensual y la fecha de creacion de la cuenta
    public void informacionDeLaCuenta(){
        System.out.println("El balance de la cuenta es: " + getBalance() );
        System.out.println("El interes mensual es: " + obtenerTasaDeInteresMensual() );
        System.out.println("La fecha de creacion de la cuenta es: " + getFechaDeCreacion() + "\n");
        
        
    }
    
    
}
