
package laboratorio6;
import java.util.Scanner;

//Clase abanico extiende de la clase abstracta dispositivo inteligente
public class Abanico_Inteligente extends Dispositivo_Inteligente{
    //Atributo
    private int potencia;
    //Variable entrada hace uso de la biblioteca scanner
    Scanner entrada = new Scanner(System.in);
    
    //Constructor de la clase que invoca al constructor de la clase abstracta y establece la potencia
    public Abanico_Inteligente(){
        super();
        setPotencia(1);
    }
    
    //Metodos set y get para el atributo potencia
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        if(potencia < 1 || potencia > 3){
            System.out.println("Potencia no valida, se asignara 1");
            this.potencia = 1;
        }
        else{
            this.potencia = potencia;
        }
        
    }
    
    //Metodo que permite seleccionar una potencia para el abanico mediante un menu
    public void seleccionar_potencia(){
        if(getEstado() == true){
            System.out.printf("Actualmente la potencia es: %d\n",getPotencia());
            System.out.println("Seleccione una nueva potencia. Puede ser 1,2 o 3");
            System.out.print("---> ");
            int opcion = entrada.nextInt();
            setPotencia(opcion);
            System.out.printf("Potencia modificada. Ahora es %d\n",getPotencia());
        }
        else{
            System.out.println("El abanico se encuentra apagado");
        }
        
        
    }
    
    //Metodos abstractos
    @Override
    public void encender() {
        setEstado(true);
        System.out.println("Abanico Encendido");
    }

    @Override
    public void apagar() {
        setEstado(false);
        System.out.println("Abanico Apagado");
    }
    
}
