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

//Esta clase es donde se colocan los barcos
public class TableroDePosicion extends Tablero{
    //Atributos
    private int cantCoordenadas;  //LLeva un conteo de las coordenadas ingresadas
    private int cantBarcosColocados; //LLeva un conteo de cuantos barcos se ingresaron correctamente
    
    //Se crean los objetos correspondientes a los barcos
    PortaAvion P = new PortaAvion();
    Fragata F1 = new Fragata();
    SubMarino S1 = new SubMarino();
    Destructor D1 = new Destructor();


    public int getCantCoordenadas() {
        return cantCoordenadas;
    }

    public void setCantCoordenadas(int cantCoordenadas) {
        this.cantCoordenadas = cantCoordenadas;
    }

    public int getCantBarcosColocados() {
        return cantBarcosColocados;
    }

    public void setCantBarcosColocados(int cantBarcosColocados) {
        this.cantBarcosColocados = cantBarcosColocados;
    }
    
    //Constructor por defecto
    public TableroDePosicion(){
        super();
        setCantBarcosColocados(0);
        setCantCoordenadas(0);
    }
    
    /*Metodo que valida si las coordenadas donde se quiere ingresar la fragata son correctas
    Entradas: dos enteros
    Salida: true o false
    Restricciones: las entradas deben ser enteros
    */
    public boolean validarCoordenadasFragata(int fila,int columna){
        if(coordenadasI.isEmpty()){
            coordenadasI.add(fila);
            coordenadasJ.add(columna);
            cantCoordenadas++;
            setCantCoordenadas(cantCoordenadas);
            System.out.printf("Primeras coordenadas en ingresar (%d,%d))\n",fila,columna);
            return true;
        }
        else{
            if(verificarCoordenadasAnteriores(fila,columna) == true){
                coordenadasI.add(fila);
                coordenadasJ.add(columna);
                cantCoordenadas++;
                setCantCoordenadas(cantCoordenadas);
                System.out.printf("Nuevas coordenadas agregadas (%d,%d)\n",fila,columna);
                return true; 
            }
            else{
                System.out.println("Coordenadas ya usadas");
                return false;
            }
        }
    }
    
    /*Metodo que ingresa un barco fragata al tablero de posicion
    Entradas: dos enteros
    Salida: true o false
    Restricciones: las entradas deben ser enteros
    */
    public boolean ingresarFragata(int fila1,int columna1){
        //Se lavidan las coordenadas. De ser correctas se hacen cambios usando set
        if(validarCoordenadasFragata(fila1,columna1) == true){
            setCasillas("F",fila1,columna1);
            cantBarcosColocados++;
            setCantBarcosColocados(cantBarcosColocados);
            return true;
        }
        else{
            System.out.println("Coordenadas invalidas");
            return false;
        }
    }
    
    /*Metodo que ingresa un porta aviones en la matriz o tablero
    Entradas: 8 enteros
    Salida: true o false
    Restricciones: las entradas deben ser enteros
    */
    public boolean ingresarPortaAviones(int fila1, int columna1, int fila2, int columna2, int fila3, int columna3, int fila4, int columna4){
        //Se lavidan las coordenadas. De ser correctas se hacen cambios usando set
        if(validarCoordenadasPortaAviones(fila1,columna1,fila2,columna2,fila3,columna3,fila4,columna4) == true){
            setCasillas("P",fila1,columna1);
            setCasillas("P",fila2,columna2);
            setCasillas("P",fila3,columna3);
            setCasillas("P",fila4,columna4);
            cantBarcosColocados++;
            setCantBarcosColocados(cantBarcosColocados);
            return true;
        }
        else{
            System.out.println("Coordenadas invalidas");
            return false;
        }
        
        
    }
    
    
    /*Verifica si hay coordenadas ya usadas previamente
    Entradas: dos enteros
    Salida: true o false
    Restricciones: las entradas deben ser enteros
    */
    public boolean verificarCoordenadasAnteriores(int fila, int columna){
        int cont = cantCoordenadas;         //Con este contador se recorren los arreglos coordenadasI y coordenadasJ                   
        while(cont!=0){
            if(coordenadasI.get(cont-1) == fila && coordenadasJ.get(cont-1) == columna){
                return false;
            }
            
            cont--;
            
        }
        return true;
        

    }
    
    /*Valida que al colocar el porta aviones las coordenadas sean validas y las posiciones correctas
    Entradas: 8 enteros
    Salida: true o false
    Restricciones: las entradas deben ser enteros
    */
    public boolean validarCoordenadasPortaAviones(int fila1,int columna1,int fila2,int columna2,int fila3,int columna3,int fila4,int columna4){
         //Se valida que se pueda ingresar el porta aviones de derecha a izquierda o viceversa en orden  de coordenadas
        if(fila1 == fila2 && fila2 == fila3 && fila3 == fila4){  //Todas las filas iguales
            if((columna1-1 == columna2 && columna2-1 == columna3 && columna3-1 == columna4) || (columna1+1 == columna2 && columna2+1 == columna3 && columna3+1 == columna4)){
                System.out.println("Posiciones correctas");
                if(coordenadasI.isEmpty()){
                    coordenadasI.add(fila1);
                    coordenadasI.add(fila2);
                    coordenadasI.add(fila3);
                    coordenadasI.add(fila4);
                    coordenadasJ.add(columna1);
                    coordenadasJ.add(columna2);
                    coordenadasJ.add(columna3);
                    coordenadasJ.add(columna4);
                    cantCoordenadas+=4;
                    setCantCoordenadas(cantCoordenadas);
                    System.out.printf("Primeras coordenadas en ingresar (%d,%d) (%d,%d) (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2,fila3,columna3,fila4,columna4);
                    return true;
                }
                else{
                    if(verificarCoordenadasAnteriores(fila1,columna1) == true){
                        if(verificarCoordenadasAnteriores(fila2,columna2) == true){
                            if(verificarCoordenadasAnteriores(fila3,columna3) == true){
                                if(verificarCoordenadasAnteriores(fila4,columna4) == true){
                                    coordenadasI.add(fila1);
                                    coordenadasI.add(fila2);
                                    coordenadasI.add(fila3);
                                    coordenadasI.add(fila4);
                                    coordenadasJ.add(columna1);
                                    coordenadasJ.add(columna2);
                                    coordenadasJ.add(columna3);
                                    coordenadasJ.add(columna4);
                                    cantCoordenadas+=4;
                                    setCantCoordenadas(cantCoordenadas);
                                    System.out.printf("Coordenadas agregadas (%d,%d) (%d,%d) (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2,fila3,columna3,fila4,columna4);
                                    return true;
                                }
                                else{
                                    System.out.println("Coordenadas ya usadas");
                                    return false;
                                }
                            }
                            else{
                                System.out.println("Coordenadas ya usadas");
                                return false;
                            }

                        }
                        else{
                            System.out.println("Coordenadas ya usadas");
                            return false;
                        }
                    }
                    else{
                        System.out.println("Coordenadas ya usadas");
                        return false;
                    }
                }
            }
            else{
                System.out.println("posiciones incorrectas");
                return false;
            }
        }
        if(columna1 == columna2 && columna1 == columna3 && columna1 == columna4){ //Columnas iguales
            if((fila1+1 == fila2 && fila2+1 == fila3 && fila3+1 == fila4) || (fila1-1 == fila2 && fila2-1 == fila3 && fila3-1 == fila4)){
                System.out.println("Posiciones correctas");
                if(coordenadasI.isEmpty()){
                    coordenadasI.add(fila1);
                    coordenadasI.add(fila2);
                    coordenadasI.add(fila3);
                    coordenadasI.add(fila4);
                    coordenadasJ.add(columna1);
                    coordenadasJ.add(columna2);
                    coordenadasJ.add(columna3);
                    coordenadasJ.add(columna4);
                    cantCoordenadas+=4;
                    setCantCoordenadas(cantCoordenadas);
                    System.out.printf("Primeras coordenadas en ingresar (%d,%d) (%d,%d) (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2,fila3,columna3,fila4,columna4);
                    return true;
                }
                else{
                    if(verificarCoordenadasAnteriores(fila1,columna1) == true){
                        if(verificarCoordenadasAnteriores(fila2,columna2) == true){
                            if(verificarCoordenadasAnteriores(fila3,columna3) == true){
                                if(verificarCoordenadasAnteriores(fila4,columna4) == true){
                                    coordenadasI.add(fila1);
                                    coordenadasI.add(fila2);
                                    coordenadasI.add(fila3);
                                    coordenadasI.add(fila4);
                                    coordenadasJ.add(columna1);
                                    coordenadasJ.add(columna2);
                                    coordenadasJ.add(columna3);
                                    coordenadasJ.add(columna4);
                                    cantCoordenadas+=4;
                                    setCantCoordenadas(cantCoordenadas);
                                    System.out.printf("Nuevas coordenadas agregadas (%d,%d) (%d,%d) (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2,fila3,columna3,fila4,columna4);
                                    return true;
                                }
                                else{
                                    System.out.println("Coordenadas ya usadas");
                                    return false;
                                }
                            }
                            else{
                                System.out.println("Coordenadas ya usadas");
                                return false;
                            }

                        }
                        else{
                            System.out.println("Coordenadas ya usadas");
                            return false;
                        }
                    }
                    else{
                        System.out.println("Coordenadas ya usadas");
                        return false;
                    }

                }
            }
            else{
                System.out.println("Error en posiciones");
                return false;
            }
                
            
        }
        else{
            System.out.println("Error en posiciones");
            return false;
        }
    }
    /*Metodo que ingresa un barco destructor al tablero de posicion
    Entradas: 4 enteros
    Salida: true o false
    Restricciones: las entradas deben ser enteros
    */
    public boolean ingresarDestructor(int fila1,int columna1,int fila2, int columna2){
        //Se validan las coordenadas. De ser correctas se hacen cambios usando set
        if(validarCoordenadasDestructor(fila1,columna1,fila2,columna2) == true){
            setCasillas("D",fila1,columna1);
            setCasillas("D",fila2,columna2);
            cantBarcosColocados++;
            setCantBarcosColocados(cantBarcosColocados);
            return true;
        }
        else{
            System.out.println("Coordenadas invalidas");
            return false;
        }
        
    }
    
    /*Se valida que se pueda ingresar el destructor de derecha a izquierda o viceversa en orden  de coordenadas
    Entradas: 4 enteros
    Salida: true o false
    Restricciones: las entradas deben ser enteros
    */
    public boolean validarCoordenadasDestructor(int fila1,int columna1, int fila2, int columna2){
        if(fila1 == fila2){  //Todas las filas iguales
            if((columna1+1 == columna2)|| (columna1-1 == columna2)){
                System.out.println("Posiciones correctas");
                if(coordenadasI.isEmpty()){
                        coordenadasI.add(fila1);
                        coordenadasI.add(fila2);
                        coordenadasJ.add(columna1);
                        coordenadasJ.add(columna2);
                        cantCoordenadas+=2;
                        setCantCoordenadas(cantCoordenadas);
                        System.out.printf("Primeras coordenadas en ingresar (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2);
                        return true;
                }
                else{
                    if(verificarCoordenadasAnteriores(fila1,columna1) == true){
                        if(verificarCoordenadasAnteriores(fila2,columna2) == true){
                            coordenadasI.add(fila1);
                            coordenadasI.add(fila2);
                            coordenadasJ.add(columna1);
                            coordenadasJ.add(columna2);
                            cantCoordenadas+=2;
                            setCantCoordenadas(cantCoordenadas);
                            System.out.printf("Nuevas coordenadas agregadas (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2);
                            return true;
                        }
                        else{
                            System.out.println("Coordenadas ya usadas");
                            return false;
                        }
                    }
                    else{
                        System.out.println("Coordenadas ya usadas");
                        return false;
                    }

                }
        
            }
            else{
                System.out.println("Error en posiciones");
                return false;
            }
            
            
        }
        if(columna1 == columna2){ //Columnas iguales
            if((fila1+1 == fila2) || (fila1-1 == fila2)){
                System.out.println("Posiciones correctas");
                if(coordenadasI.isEmpty()){
                    coordenadasI.add(fila1);
                    coordenadasI.add(fila2);
                    coordenadasJ.add(columna1);
                    coordenadasJ.add(columna2);
                    cantCoordenadas+=2;
                    setCantCoordenadas(cantCoordenadas);
                    System.out.printf("Primeras coordenadas en ingresar (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2);
                    return true;
                }
                else{
                    if(verificarCoordenadasAnteriores(fila1,columna1) == true){
                        if(verificarCoordenadasAnteriores(fila2,columna2) == true){
                            coordenadasI.add(fila1);
                            coordenadasI.add(fila2);
                            coordenadasJ.add(columna1);
                            coordenadasJ.add(columna2);
                            cantCoordenadas+=2;
                            setCantCoordenadas(cantCoordenadas);
                            System.out.printf("Nuevas coordenadas agregadas (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2);
                            return true;
                        }
                        else{
                            System.out.println("Coordenadas ya usadas");
                            return false;
                        }
                    }
                    else{
                        System.out.println("Coordenadas ya usadas");
                        return false;
                    }
                }
            }
            else{
                System.out.println("Error en posiciones");
                return false;
            }

        }
        else{
            return false;
        }
    }

        
    
    /*Metodo que ingresa un SubMarino en la matriz o tablero
    Entradas: 6 enteros
    Salida: true o false
    Restricciones: las entradas deben ser enteros
    */
    public boolean ingresarSubMarino(int fila1,int columna1,int fila2,int columna2,int fila3,int columna3){
        //Se validan las coordenadas. De ser correctas se hacen cambios usando set
        if(validarCoordenadasSubMarino(fila1,columna1,fila2,columna2,fila3,columna3) == true){
            setCasillas("S",fila1,columna1);
            setCasillas("S",fila2,columna2);
            setCasillas("S",fila3,columna3);
            cantBarcosColocados++;
            setCantBarcosColocados(cantBarcosColocados);

            return true;
        }
        else{
            System.out.println("Coordenadas invalidas");
            return false;
        }
    }
    
    /*Valida que al colocar el porta aviones las coordenadas sean validas y las posiciones correctas
    Entradas: 6 enteros
    Salida: true o false
    Restricciones: las entradas deben ser enteros
    */
    public boolean validarCoordenadasSubMarino(int fila1,int columna1,int fila2,int columna2,int fila3,int columna3){
     
        //Se valida que se pueda ingresar el porta aviones de derecha a izquierda o viceversa en orden  de coordenadas
        if(fila1 == fila2 && fila2 == fila3){  //Todas las filas iguales
            if((columna1-1 == columna2 && columna2-1 == columna3) || (columna1+1 == columna2 && columna2+1 == columna3)){
                System.out.println("Posiciones correctas");
                if(coordenadasI.isEmpty()){
                    coordenadasI.add(fila1);
                    coordenadasI.add(fila2);
                    coordenadasI.add(fila3);
                    coordenadasJ.add(columna1);
                    coordenadasJ.add(columna2);
                    coordenadasJ.add(columna3);
                    cantCoordenadas+=3;
                    setCantCoordenadas(cantCoordenadas);
                    System.out.printf("Primeras coordenadas en ingresar (%d,%d) (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2,fila3,columna3);
                    return true;    
                }
                else{
                    if(verificarCoordenadasAnteriores(fila1,columna1) == true){
                        if(verificarCoordenadasAnteriores(fila2,columna2) == true){
                            if(verificarCoordenadasAnteriores(fila3,columna3) == true){
                                    coordenadasI.add(fila1);
                                    coordenadasI.add(fila2);
                                    coordenadasI.add(fila3);
                                    coordenadasJ.add(columna1);
                                    coordenadasJ.add(columna2);
                                    coordenadasJ.add(columna3);
                                    cantCoordenadas+=3;
                                    setCantCoordenadas(cantCoordenadas);
                                    System.out.printf("Nuevas coordenadas agregadas (%d,%d) (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2,fila3,columna3);
                                    return true;
                            }
                            else{
                                System.out.println("Coordenadas ya usadas");
                                return false;
                            }
                        }
                        else{
                            System.out.println("Coordenadas ya usadas");
                            return false;
                        }

                    }
                    else{
                        System.out.println("Coordenadas ya usadas");
                        return false;
                    }

                }
            }
            else{
                System.out.println("Error en posiciones");
                return false;
            }
            
        }
        if(columna1 == columna2 && columna1 == columna3){ //Columnas iguales
            if((fila1+1 == fila2 && fila2+1 == fila3) || (fila1-1 == fila2 && fila2-1 == fila3)){
                System.out.println("Posiciones correctas");
                if(coordenadasI.isEmpty()){
                    coordenadasI.add(fila1);
                    coordenadasI.add(fila2);
                    coordenadasI.add(fila3);
                    coordenadasJ.add(columna1);
                    coordenadasJ.add(columna2);
                    coordenadasJ.add(columna3);
                    cantCoordenadas+=3;
                    setCantCoordenadas(cantCoordenadas);
                    System.out.printf("Primeras coordenadas en ingresar (%d,%d) (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2,fila3,columna3);
                    return true;           
                }
                else{
                    if(verificarCoordenadasAnteriores(fila1,columna1) == true){
                        if(verificarCoordenadasAnteriores(fila2,columna2) == true){
                            if(verificarCoordenadasAnteriores(fila3,columna3) == true){
                                coordenadasI.add(fila1);
                                coordenadasI.add(fila2);
                                coordenadasI.add(fila3);
                                coordenadasJ.add(columna1);
                                coordenadasJ.add(columna2);
                                coordenadasJ.add(columna3);
                                cantCoordenadas+=3;
                                setCantCoordenadas(cantCoordenadas);
                                System.out.printf("Nuevas coordenadas agregadas (%d,%d) (%d,%d) (%d,%d)\n",fila1,columna1,fila2,columna2,fila3,columna3);
                                return true;
                            }
                            else{
                                System.out.println("Coordenadas ya usadas");
                                return false;
                            }
                        }
                        else{
                            System.out.println("Coordenadas ya usadas");
                            return false;
                        }

                    }
                    else{
                        System.out.println("Coordenadas ya usadas");
                        return false;
                    }
                    
                }
            }
            else{
                System.out.println("Error en posiciones");
                return false;
            }
            
        }
        else{
            return false;
        }
        
    }

    
}

        