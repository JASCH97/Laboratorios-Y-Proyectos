package laboratorio6;
import java.util.Scanner;

//Clase despertador extiende de la clase dispositivo inteligente
public class Despertador_Inteligente extends Dispositivo_Inteligente{
    //Atributos
    private int horas,minutos;
    //variable entrada que hace uso de la biblioteca scanner
    Scanner entrada = new Scanner(System.in);
    
    //Constructor de la clase que invoca al constructor de la clase abstracta y establece los atributos
    public Despertador_Inteligente(){
        super();
        setHoras(12);
        setMinutos(0);
    }
    
    //Metodos set y get para horas y minutos
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = (horas < 0 || horas > 24 ? 0 : horas);
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = (minutos < 0 || minutos > 59 ? 0 : minutos);
    }
    
    //Metodo que permite programar una alarma en el despertador
    public void programarAlarma(){
        if(getEstado() == true){
            System.out.println("Para programar la alarma ingrese primero la hora que desea, luego los minutos");
            System.out.print("Hora: ");
            int entradaHora = entrada.nextInt();
            System.out.print("Minutos: ");
            int entradaMinutos = entrada.nextInt();

            if(entradaMinutos < 10){
                System.out.printf("La alarma ha sido programada a las %d:0%d\n",entradaHora,entradaMinutos);
            }
            else{
                System.out.printf("La alarma ha sido programada a las %d:%d\n",entradaHora,entradaMinutos);
            }
        }
        else{
            System.out.println("El despertador se encuentra apagado");
                    
        }
        
        
    }
    
    //Metodos abstractos
    @Override
    public void encender() {
        setEstado(true);
        System.out.println("Despertador Encendido");
    }

    @Override
    public void apagar() {
        setEstado(false);
        System.out.println("Despertador Apagado");
    }
}
