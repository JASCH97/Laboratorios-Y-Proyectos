package laboratorio6;

//Clase coffe maker extiende de la clase dispositivo inteligente
public class CoffeMaker_Inteligente extends Dispositivo_Inteligente{

    //Constructor de la clase que invoca al constructor de la clase abstracta
    public CoffeMaker_Inteligente(){
        super();
    }
    
    //Metodo para preparar cafe
    public void prepararCafe(){
        if(getEstado() == false){
            System.out.println("El Coffe Maker se encuentra apagado");
        }
        else{
            System.out.println("El cafe estara listo en 8 minutos y la maquina se apagara");
            setEstado(false);
        }
          
    }
    
    //Metodos abstractos
    @Override
    public void encender() {
        setEstado(true);
        System.out.println("Coffe Maker Encendido");
    }

    @Override
    public void apagar() {
        setEstado(false);
        System.out.println("Coffe Maker Apagado");
    }
    
}
