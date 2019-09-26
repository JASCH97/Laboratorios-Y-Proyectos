
package laboratorio6;
import java.util.Scanner;

//Secadora extiende de la clase abstracta dispositivo inteligente
public class Secadora_Inteligente extends Dispositivo_Inteligente{
    //variable entrada hace uso de la biblioteca scanner
    Scanner entrada = new Scanner(System.in);
    
    //Constructor de la clase que invoca al constructor de la clase abstracta
    public Secadora_Inteligente(){
        super();
    }
    
    //Metodo que permite seleccionar la cantidad de ropa a secar mediante un menu
    public void seleccionar_cantidadRopa(){
        if(getEstado() == true){
            System.out.println("Seleccione la cantidad de ropa que desea secar");
            System.out.print("1.Poca\n2.Media\n3.Mucha\n---> ");
            int opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("La ropa estara lista en 10 minutos");
                    break;
                    
                case 2:
                    System.out.println("La ropa estara lista en 20 minutos");
                    break;
                    
                case 3:
                    System.out.println("La ropa estara lista en 30 minutos");
                    break;
                    
                default:
                    System.out.println("Cantidad de ropa incorrecta");
                    break;
            }
        }
        
        else{
            System.out.println("La secadora se encuentra apagada");
        }
    }
    
    //Metodos abstractos
    @Override
    public void encender() {
        setEstado(true);
        System.out.println("Secadora Encendida");
    }

    @Override
    public void apagar() {
        setEstado(false);
        System.out.println("Secadora Apagada");
    }
    
}
