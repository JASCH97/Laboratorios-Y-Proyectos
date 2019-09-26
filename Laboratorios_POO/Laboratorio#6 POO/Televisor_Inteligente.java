package laboratorio6;

//Clase Televisor que extiende de Dispositivo Inteligente
public class Televisor_Inteligente extends Dispositivo_Inteligente {
    
    //atributos
    private int volumen,canal;
    
    //Constructor de la clase
    public Televisor_Inteligente(){
        super();    //Se invoca el constructor de la clase abstracta
        setVolumen(0);
        setCanal(0);
    }
    
    //Metodos set y get para volumen y Canal
    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }
    
    //Metodo con el que se pasa al siguiente canal, los canales son del 0 al 100
    public void siguiente_canal(){
        if(getEstado() == false){
            System.out.println("El televisor se encuentra apagado");
        }
        else{
            setCanal((getCanal() + 1) > 100 ? 0 : ((getCanal() +1)));
            System.out.printf("El canal es: %d\n",getCanal());
        }
    }
    
    //Metodo con el que se pasa al canal anterior, los canales son del 0 al 100
    public void anterior_canal(){
        if(getEstado() == false){
            System.out.println("El televisor se encuentra apagado");
        }
        else{
            //Si el canal es cero, y presiona canal anterior se ira al ultimo canal
            //osea, el canal 100. Si no es 0, actua normal.
            setCanal((getCanal() - 1) < 0 ? 100 : ((getCanal()-1)));
            System.out.printf("El canal es: %d\n",getCanal());
        }
    }
    
    //Metodo para subir el volumen del televisor. El volumen va de 0 a 100
    public void subir_volumen(){
        if(getEstado() == false){
            System.out.println("El televisor se encuentra apagado");
        }
        else{
            setVolumen((this.volumen + 1) > 100 ? 100 : (this.volumen +1));
            System.out.printf("El volumen es: %d\n",getVolumen());
        }
    }
    
    //Metodo para bajar el volumen del televisor. El volumen va de 0 a 100
    public void bajar_volumen(){
        if(getEstado() == false){
            System.out.println("El televisor se encuentra apagado");
        }
        else{
            setVolumen((this.volumen - 1) < 0 ? 0 : (this.volumen -1));
            System.out.printf("El volumen es: %d\n",getVolumen());
        }
    }
    
    //Metodos abstracto 
    @Override
    public void encender() {
        setEstado(true);
        System.out.println("Televisor Encendido");
    }

    @Override
    public void apagar() {
        setEstado(false);
        System.out.println("Televisor Apagado");
    }
       
}
