
package laboratorio6;

//Clase computadora extiende de la clase dispositivo inteligente
public class Computadora_Inteligente extends Dispositivo_Inteligente {
    
    //Constructor de la clase que invoca al constructor de la clase abstracta
    public Computadora_Inteligente(){
        super();
    }
    
    //Metodo que reinicia la computadora
    public void reiniciar_computadora(){
        if(getEstado() == false){
            System.out.println("No se puede reiniciar la computadora porque esta apagada.");
        }
        else{
            System.out.println("Reiniciando computadora...");
            apagar();
            encender();
            System.out.println("Computadora reiniciada\n");
                    
        }   
    }
    
    //Metodos abstractos
    @Override
    public void encender() {
        setEstado(true);
        System.out.println("Computadora Encendida");
    }

    @Override
    public void apagar() {
        setEstado(false);
        System.out.println("Computadora Apagada");
    }
    
}
