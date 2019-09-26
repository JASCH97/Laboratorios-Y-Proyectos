
package laboratorio6;
import java.util.Scanner;

//Clase sarten extiende de la clase abstracta dispositivo inteligente
public class Sarten_Inteligente extends Dispositivo_Inteligente{
    //Atributos
    private int temperatura;
    //Variable entrada que hace uso de la biblioteca scanner
    Scanner entrada = new Scanner(System.in);
    
    //Constructor de la clase que invoca al constructor de la clase abstracta y establece temperatura
    public Sarten_Inteligente(){
        super();
        setTemperatura(1);
    }
    
    //Set y get para el atributo temperatura 
    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
    
    //Metodo que permite seleccionar una temperatura para el sarten mediante un menu
    public void seleccionar_temperatura(){
        if(getEstado() == true){
            System.out.println("Seleccione la temperatura del sarten\n1.Baja\n2.Media\n3.Alta");
            System.out.print("---> ");
            int opcion = entrada.nextInt();
            if(opcion == 1){
                setTemperatura(1);
                System.out.println("Ahora la temperatura del sarten es Baja");
            }
            if(opcion == 2){
                setTemperatura(2);
                System.out.println("Ahora la temperatura del sarten es Media");
            }
            if(opcion == 3){
                setTemperatura(3);
                System.out.println("Ahora la temperatura del sarten es Alta");
            }
            else{
                System.out.println("Temperatura no valida");
            }
        }
        
        else{
            System.out.println("El sarten se encuentra apagado");
        }
    }

    //Metodos abstractos
    @Override
    public void encender() {
        setEstado(true);
        System.out.println("Sarten Encendido");
    }

    @Override
    public void apagar() {
        setEstado(false);
        System.out.println("Sarten Apagado");
    }
    
}
