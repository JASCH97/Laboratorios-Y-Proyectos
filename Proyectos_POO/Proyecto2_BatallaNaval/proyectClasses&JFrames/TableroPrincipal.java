/*
PROYECTO #2 - BATALLA NAVAL
INGENIERIA EN COMPUTACION
INSTITUTO TECNOLOGICO DE COSTA RICA
PROGRAMACION ORIENTADA A OBJETOS
II SEMESTRE 2019
INTEGRANTES: 
            -ALEXANDER ARTAVIA QUESADA
            -JOAN SANCHEZ CHINCHILLA
            -ARMANDO CASTRO RUIZ
PROFESORA:
            -SAMANTA RAMIJAN
*/

package proyecto2_batallanaval;
//Biblioteca Scanner para las entradas del usuario
import java.util.Scanner;

//Tablero donde se realizan los disparos al enemigo
public class TableroPrincipal extends Tablero{
    //Atributos
    private int cantDisparos;   //para llevar conteo de disparos
    //Se crea un tablero de posicion para tomar como referencia al disparar
    TableroDePosicion TDP;

    public int getCantDisparos() {
        return cantDisparos;
    }

    public void setCantDisparos(int cantDisparos) {
        this.cantDisparos = cantDisparos;
    }
    Scanner entrada = new Scanner(System.in);
    
    
    //Metodo que establece el tablero de posicion
    public void setTDP(TableroDePosicion TDP) {
        this.TDP = TDP;
        setCantDisparos(0);
    }
    
    //Constructor por defecto
    public TableroPrincipal(){
        super();
    }
    
    //Meodo que indica si el porta aviones es destruido
    public boolean estadoPortaAviones(){
        if(TDP.P.getTamano() == 0){
            System.out.println("Porta Aviones destruido");
            return true;
        }
        else{
            return false;
        }
    }
    
    //Metodo que indica si las fragatas se destruyeron
    public boolean estadoFragatas(){
        if(TDP.F1.getTamano() == -1){
            System.out.println("Fragatas destruidas");
            return true;
        }
        else{
            return false;
                    
        }
    }
    
    //Metodo que indica si los Submarinos se destruyeron
    public boolean estadoSubmarinos(){
        if(TDP.S1.getTamano() == -6){
            System.out.println("Submarinos destruidos");
            return true;
        }
        else{
            return false;
                    
        }
    }
    
    //Metodo que indica si los Destructores se destruyeron
    public boolean estadoDestructores(){
        if(TDP.D1.getTamano() == -4){
            System.out.println("Destructores destruidos");
            return true;
        }
        else{
            return false;
        
        }
    }

    //El siguiente metodo no se usa debido a la implementacion grafica
    /*
    //METODO DONDE EL USUARIO SELECCIONA LAS COORDENADAS DEL DISPARO
    public void seleccionarCoordenadas(){
        int x,y;
        System.out.print("Ingrese las coordenadas del disparo\nFila: ");
        x = entrada.nextInt();
        
        System.out.print("Columna: ");
        y = entrada.nextInt();
        registrarDisparo(x,y);
        
    }*/
    
    //Metodo que registra el disparo y lo valida en caso de realizarse en el mismo lugar
    public boolean registrarDisparo(int x, int y){
        int cont = cantDisparos;
        
        while(cont!=0){
            if(coordenadasI.get(cont-1) == x && coordenadasJ.get(cont-1) == y){
                System.out.println("Disparo efectuado anteriormente");
                return false;
            }
            cont--;
        }
        
        if(coordenadasI.isEmpty()){
            //dentro de las coordenadas de guarda un registro de los disparos efectuados
            coordenadasI.add(x);
            coordenadasJ.add(y);
            cantDisparos++;
            setCantDisparos(cantDisparos);
            System.out.printf("Primer disparo.Impactó en las coordenadas (%d,%d\n)",x,y);
            return true;
        }
        else{
            coordenadasI.add(x);
            coordenadasJ.add(y);
            cantDisparos++;
            setCantDisparos(cantDisparos);
            System.out.printf("Disparo efectuado con las coordenadas (%d,%d)\n",x,y);
            return true;

        }
        
    
    }
    
    //Metodo que realiza el disparo modificando los tableros (matriz)
    public void disparar(int i, int j){
        String casilla = TDP.getCasillas(i, j);
        
        switch(casilla){
            case "":
                System.out.println("Disparo al AGUA");
                TDP.setCasillas("X",i,j);
                break;
                
            case "P":
                System.out.println("Disparo al Porta Aviones");
                TDP.P.setTamano(TDP.P.getTamano()-1);
               // TDP.setCasillas("Burned",i,j);
                estadoPortaAviones();
                break;
                
            case "F":
                System.out.println("Disparo a Fragata");
                TDP.F1.setTamano(TDP.F1.getTamano()-1);
                //TDP.setCasillas("Burned",i,j);
                estadoFragatas();
                break;
                
            case "D":
                System.out.println("Disparo al Destructor");
                TDP.D1.setTamano(TDP.D1.getTamano()-1);
                //TDP.setCasillas("Burned",i,j);
                estadoDestructores();
                break;
                
            case "S":
                System.out.println("Disparo a Submarino");
                TDP.S1.setTamano(TDP.S1.getTamano()-1);
                //TDP.setCasillas("Burned",i,j);
                estadoSubmarinos();
                break;
        }
        
        
                
    }     
}
