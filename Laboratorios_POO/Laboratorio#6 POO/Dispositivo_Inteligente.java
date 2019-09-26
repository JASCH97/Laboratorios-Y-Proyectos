package laboratorio6;

//Clase abstracto de un dispositivo inteligente que implemente la interfaz Aparato
public abstract class Dispositivo_Inteligente implements Aparato {
    private boolean estado;
    
    public Dispositivo_Inteligente(){
        setEstado(false);
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
