package laboratorio6;
import java.util.Scanner;

//Clase lavadora extiende de la clase dispositivo inteligente
public class Lavadora_Inteligente extends Dispositivo_Inteligente {
    //atributos
    private int ciclos;
    Scanner entrada = new Scanner(System.in);
    
    //Constructor de la clase.Invoca al constructor de la clase abstracta y establece ciclos en 1
    public Lavadora_Inteligente(){
        super();
        setCiclos(1);           
    }

    //Metodos set y get para el atributo ciclos
    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        if(ciclos < 1 || ciclos > 3){
            System.out.println("Ciclo invalido");
        }
        else{
            this.ciclos = ciclos;
        }
        
    }
    
    //Metodo que permite seleccionar un ciclo de lavado con un menu
    public void seleccionar_ciclo(){
        if(getEstado() == true){
            System.out.println("Seleccione el ciclo que desee\n1.Lavado Normal");
            System.out.print("2.Lavado Lento\n3.Lavado Rapido\n---> ");
            int opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    setCiclos(1);
                    System.out.println("Iniciando Lavado Normal");
                    break;
                case 2:
                    setCiclos(2);
                    System.out.println("Iniciando Lavado Lento");
                    break;
                case 3:
                    setCiclos(3);
                    System.out.println("Iniciando Lavado Rapido");
                    break;    
            }
            
        }
        else{
            System.out.println("La lavadora se encuentra apagada");
        }
    }
    
    //Metodos abstractos
    @Override
    public void encender() {
        setEstado(true);
        System.out.println("Lavadora Encendida");
    }

    @Override
    public void apagar() {
        setEstado(false);
        System.out.println("Lavadora Apagada");
    }
    
}
