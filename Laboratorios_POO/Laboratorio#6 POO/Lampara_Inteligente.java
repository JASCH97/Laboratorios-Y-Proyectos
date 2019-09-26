
package laboratorio6;

//Clase lampara que extiende de dispositivo inteligente
public class Lampara_Inteligente extends Dispositivo_Inteligente{
    
    //Constructor que invoca al constructor de la clase abstracta
    public Lampara_Inteligente(){
        super();
    }
    
    //Metodos abstractos
    @Override
    public void encender() {
        setEstado(true);
        System.out.println("Lampara Encendida");
    }

    @Override
    public void apagar() {
       setEstado(false);
       System.out.println("Lampara Apagada");
    }
    
}
