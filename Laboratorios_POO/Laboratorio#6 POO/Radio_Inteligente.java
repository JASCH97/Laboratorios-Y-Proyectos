
package laboratorio6;
import java.util.Scanner;

//Clase radio extiende de la clase dispositivo inteligente
public class Radio_Inteligente extends Dispositivo_Inteligente{
    //Atributos
    private int volumen,estacion;
    //Variable que hace uso de la biblioteca scanner
    Scanner entrada = new Scanner(System.in);
    
    //Constructor de la clase que invoca al constructor de la clase abstracta y establece los atributos
    public Radio_Inteligente(){
        super();
        setVolumen(0);
        setEstacion(0);
    }
    
    //Metodos get y set de los atributos
    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getEstacion() {
        return estacion;
    }

    public void setEstacion(int estacion) {
        this.estacion = estacion;
    }
    
    //Metodo para subir el volumen del radio. El volumen va de 0 a 100
    public void subir_volumen(){
        if(getEstado() == false){
            System.out.println("El radio se encuentra apagado");
        }
        else{
            setVolumen((this.volumen + 1) > 100 ? 100 : (this.volumen +1));
            System.out.printf("El volumen es: %d\n",getVolumen());
        }
    }
    //Metodo para bajar el volumen del radio. El volumen va de 0 a 100
    public void bajar_volumen(){
        if(getEstado() == false){
            System.out.println("El radio se encuentra apagado");
        }
        else{
            setVolumen((this.volumen - 1) < 0 ? 0 : (this.volumen -1));
            System.out.printf("El volumen es: %d\n",getVolumen());
        }
    }
    
    //Metodo para cambiar a la siguiente estacion del radio. Cuenta con 100 estaciones
    public void siguiente_estacion(){
        if(getEstado() == false){
            System.out.println("El radio se encuentra apagado");
        }
        else{
            setEstacion((getEstacion() + 1) > 100 ? 0 : ((getEstacion() +1)));
            System.out.printf("Suena la estacion: %d\n",getEstacion());
        }
    }
    
    //Metodo para cambiar a la estacion anterior del radio. Cuenta con 100 estaciones
    public void anterior_estacion(){
        if(getEstado() == false){
            System.out.println("El radio se encuentra apagado");
        }
        else{
            
            setEstacion((getEstacion() - 1) < 0 ? 100 : ((getEstacion()-1)));
            System.out.printf("Suena la estacion: %d\n",getEstacion());
        }
    }
    
    
    //Metodos abstractos
    @Override
    public void encender() {
       setEstado(true);
       System.out.println("Radio Encendido");
    }

    @Override
    public void apagar() {
        setEstado(false);
        System.out.println("Radio Apagado");
    }
    
}
