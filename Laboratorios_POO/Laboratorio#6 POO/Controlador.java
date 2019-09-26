
package laboratorio6;
import java.util.Scanner;  //Se importa la clase Scanner para las entradas del usuario

/*La clase controlador crea 10 objetos y hace uso de ellos mediante una serie
de menus con los cuales el usuario puede acceder a diversas funciones dentro de 
las habitaciones de la casa o los objetos mismos.
*/
public class Controlador {
    //Se crean los objetos que son dispositivos inteligentes
    Televisor_Inteligente Tele = new Televisor_Inteligente();
    Abanico_Inteligente Abanico = new Abanico_Inteligente();
    CoffeMaker_Inteligente CoffeMaker = new CoffeMaker_Inteligente();
    Despertador_Inteligente Despertador = new Despertador_Inteligente();
    Lampara_Inteligente Lampara = new Lampara_Inteligente();
    Lavadora_Inteligente Lavadora = new Lavadora_Inteligente();
    Radio_Inteligente Radio = new Radio_Inteligente();
    Sarten_Inteligente Sarten = new Sarten_Inteligente();
    Secadora_Inteligente Secadora = new Secadora_Inteligente();
    Computadora_Inteligente Compu = new Computadora_Inteligente();
    
    Scanner entrada = new Scanner(System.in);
    
    //Metodo que contiene el meniu principal o inicial del controlador.
    //Aqui se selecciona una habitacion especifica de la casa
    public void menu(){
        
        System.out.println("-----Controlador de Dispositivos-----\n");
        System.out.println("Seleccione una habitacion\n1.Dormitorio\n2.Sala\n3.Cocina\n4.Cuarto de lavado");
        System.out.print("5.Apagar controlador\n---> ");
        int opcion = entrada.nextInt();
        
        switch(opcion){
            case 1:
                dormitorio();
                break;
            
            case 2:
                sala();
                break;
                
            case 3:
                cocina();
                break;
                
            case 4:
                cuarto_lavado();
                break;
                
            case 5:
                System.exit(0);
                
            default:
                System.out.println("Seleccion invalida. Intente de nuevo");
                menu();
        }
    }
    
    //Metodo que contiene el menu de la habitacion dormitorio
    public void dormitorio(){
        System.out.println("Ingrese 1 para encender todos los dispositivos");
        System.out.println("Ingrese 2 para apagar todos los dispositivos");
        System.out.println("Ingrese 3 para contolar un dispositivo especifico");
        System.out.println("Ingrese 4 para seleccionar otra habitacion");
        System.out.print("---> ");
        int opcion_dormitorio = entrada.nextInt();
        
        //Se usa un switch para las opciones y se usan los objetos
        switch(opcion_dormitorio){
            //Se encienden los objetos del dormitorio
            case 1:
                Compu.encender();
                Lampara.encender();
                Despertador.encender();
                System.out.println("Dispositivos del dormitorio encendidos\n");
                dormitorio();
                break;
                
            //Se apagan los objetos del dormitorio   
            case 2:
                Compu.apagar();
                Lampara.apagar();
                Despertador.apagar();
                System.out.println("Dispositivos del dormitorio apagados\n");
                dormitorio();
                break;
                
            case 3:
                dispositivos_dormitorio();
                break;
                
            case 4:
                menu();
                break;
                
            default:
                System.out.println("Opcion Invalida. Intente nuevamente");
                dormitorio();
                break;
        }
        
    }
    
    //Metodo que contiene el menu donde se selecciona un dispositivo del dormitorio especifico
    public void dispositivos_dormitorio(){
        System.out.println("Seleccione el dispositivo\n1.Computadora\n2.Lampara\n3.Despertador\n4.Volver a dormitorio");
        System.out.print("---> ");
        
        int opcion = entrada.nextInt();
        
        if(opcion == 1){
            menu_compu();
        }
        
        if(opcion == 2){
            menu_lampara();
        }
        
        if(opcion == 3){
            menu_despertador();
        }
        
        if(opcion == 4){
            dormitorio();
        }
        else{
            System.out.println("Dispositivo invalido. Intente de nuevo");
            dispositivos_dormitorio();
        }
    }
    
    //Metodo que contiene el menu interactivo de la computadora
    public void menu_compu(){
        System.out.println("\nSi desea encender la computadora, presione 1");
        System.out.println("Si desea apagar la computadora, presione 2");
        System.out.println("Si desea reiniciar la computadora, presione 3");
        System.out.println("Si desea seleccionar otro dispositivo, presione 4");
        System.out.print("---> ");
        
        int opcion_compu = entrada.nextInt();
            
        switch(opcion_compu){
            case 1:
                Compu.encender();
                menu_compu();
                break;
                    
            case 2:
                Compu.apagar();
                menu_compu();
                break;
                   
            case 3:
                Compu.reiniciar_computadora();
                menu_compu();
                break;
                    
            case 4:
                dispositivos_dormitorio();
                break;
                    
            default:
                System.out.println("Entrada invalida, intente de nuevo");
                menu_compu();
                break;
        }
    }
    
    //Metodo que contiene el menu interactivo de la lampara
    public void menu_lampara(){
        System.out.println("\nSi desea encender la lampara, presione 1");
        System.out.println("Si desea apagar la lampara, presione 2");
        System.out.println("Si desea seleccionar otro dispositivo, presione 3");
        System.out.print("---> ");
        
        int opcion_lamp = entrada.nextInt();
            
        switch(opcion_lamp){
            case 1:
                Lampara.encender();
                menu_compu();
                break;
                    
            case 2:
                Lampara.apagar();
                menu_compu();
                break;
                   
            case 3:
                dispositivos_dormitorio();
                break;
                    
            default:
                System.out.println("Entrada invalida, intente de nuevo");
                menu_compu();
                break;
        }
    }
    
    //Metodo que contiene el menu interactivo del despertador
    public void menu_despertador(){
        System.out.println("\nSi desea encender el despertador, presione 1");
        System.out.println("Si desea apagar el despertador, presione 2");
        System.out.println("Si desea programar una alarma, presione 3");
        System.out.println("Si desea seleccionar otro dispositivo, presione 4");
        System.out.print("---> ");
        
        int opcion_despertador = entrada.nextInt();
            
        switch(opcion_despertador){
            case 1:
                Despertador.encender();
                menu_despertador();
                break;
                    
            case 2:
                Despertador.apagar();
                menu_despertador();
                break;
                   
            case 3:
                Despertador.programarAlarma();
                menu_despertador();
                break;
                
            case 4:
                dispositivos_dormitorio();
                break;
                    
            default:
                System.out.println("Entrada invalida, intente de nuevo");
                menu_despertador();
                break;
        }
    }
    
    //Metodo que contiene el menu de la habitacion sala
    public void sala(){
        System.out.println("Ingrese 1 para encender todos los dispositivos");
        System.out.println("Ingrese 2 para apagar todos los dispositivos");
        System.out.println("Ingrese 3 controlar un dispositivo especifico");
        System.out.println("Ingrese 4 para seleccionar otra habitacion");
        System.out.print("---> ");
        int opcion_sala = entrada.nextInt();
        
        switch(opcion_sala){
            case 1:
                Tele.encender();
                Radio.encender();
                Abanico.encender();
                System.out.println("Dispositivos de la sala encendidos\n");
                sala();
                break;
            
            case 2:
                Tele.apagar();
                Radio.apagar();
                Abanico.apagar();
                System.out.println("Dispositivos de la sala apagados\n");
                sala();
                break;
            
            case 3:
                dispositivos_sala();
                break;
                
            case 4:
                menu();
                break;
                
            default:
                System.out.println("Opcion Invalida. Intente nuevamente");
                sala();
                break;
        }
        
    }
    
    //Metodo que contiene un menu donde se seleccionan los dispositivos de la sala de manera especifica
    public void dispositivos_sala(){
        System.out.println("Seleccione el dispositivo\n1.Televisor\n2.Radio\n3.Abanico\n4.Volver a sala");
        System.out.print("---> ");
        
        int opcion = entrada.nextInt();
        
        if(opcion == 1){
            menu_tv();
        }
        
        if(opcion == 2){
            menu_radio();
        }
        
        if(opcion == 3){
            menu_abanico();
        }
        
        if(opcion == 4){
            sala();
        }
        else{
            System.out.println("Dispositivo invalido. Intente de nuevo");
            dispositivos_sala();
        }
    }
    
    //Metodo que contiene un menu interactuvo de la television
    public void menu_tv(){
        System.out.println("\nSi desea encender el televisor, presione 1");
        System.out.println("Si desea apagar el televisor, presione 2");
        System.out.println("Si desea subir el volumen, presione 3");
        System.out.println("Si desea bajar el volumen, presione 4");
        System.out.println("Si desea pasar al siguiente canal, presione 5");
        System.out.println("Si desea pasar al canal anterior, presione 6");
        System.out.println("Si desea seleccionar otro dispositivo, presione 7");
        System.out.print("---> ");
            
        int opcion_tv = entrada.nextInt();
            
        switch(opcion_tv){
            case 1:
                Tele.encender();
                menu_tv();
                break;
                    
            case 2:
                Tele.apagar();
                menu_tv();
                break;
                   
            case 3:
                Tele.subir_volumen();
                menu_tv();
                break;
                    
            case 4:
                Tele.bajar_volumen();
                menu_tv();
                break;
                    
            case 5:
                Tele.siguiente_canal();
                menu_tv();
                break;
                    
            case 6:
                Tele.anterior_canal();
                menu_tv();
                break;
                    
            case 7:
                dispositivos_sala();
                break;
                    
            default:
                System.out.println("Entrada invalida, intente de nuevo");
                menu_tv();
                break;
            }
    }
    
    //Metodo que contiene un menu interactivo del radio
    public void menu_radio(){
        System.out.println("\nSi desea encender el radio, presione 1");
        System.out.println("Si desea apagar el radio, presione 2");
        System.out.println("Si desea subir el volumen, presione 3");
        System.out.println("Si desea bajar el volumen, presione 4");
        System.out.println("Si desea pasar a la siguiente emisora, presione 5");
        System.out.println("Si desea pasar a la emisora anterior, presione 6");
        System.out.println("Si desea seleccionar otro dispositivo, presione 7");
        System.out.print("---> ");
        
        int opcion_radio = entrada.nextInt();
            
        switch(opcion_radio){
            case 1:
                Radio.encender();
                menu_radio();
                break;
                    
            case 2:
                Radio.apagar();
                menu_radio();
                break;
                   
            case 3:
                Radio.subir_volumen();
                menu_radio();
                break;
                    
            case 4:
                Radio.bajar_volumen();
                menu_radio();
                break;
                    
            case 5:
                Radio.siguiente_estacion();
                menu_radio();
                break;
                    
            case 6:
                Radio.anterior_estacion();
                menu_radio();
                break;
                    
            case 7:
                dispositivos_sala();
                break;
                    
            default:
                System.out.println("Entrada invalida, intente de nuevo");
                menu_radio();
                break;
            }
        
        
    }
    
    //Metodo que contiene un menu interactivo del abanico
    public void menu_abanico(){
        System.out.println("\nSi desea encender el abanico, presione 1");
        System.out.println("Si desea apagar el apanico, presione 2");
        System.out.println("Si desea seleccionar la potencia, presione 3");
        System.out.println("Si desea seleccionar otro dispositivo, presione 4");
        System.out.print("---> ");
        
        int opcion_abanico = entrada.nextInt();
            
        switch(opcion_abanico){
            case 1:
                Abanico.encender();
                menu_abanico();
                break;
                    
            case 2:
                Abanico.apagar();
                menu_abanico();
                break;
                   
            case 3:
                Abanico.seleccionar_potencia();
                menu_abanico();
                break;
                    
            case 4:
                dispositivos_sala();
                break;
                    
            default:
                System.out.println("Entrada invalida, intente de nuevo");
                menu_abanico();
                break;
        }
        
    }
    
    //Metodo que contiene un menu de la habitacion cocina
    public void cocina(){
        System.out.println("Ingrese 1 para encender todos los dispositivos");
        System.out.println("Ingrese 2 para apagar todos los dispositivos");
        System.out.println("Ingrese 3 para controlar un dispositivo especifico");
        System.out.println("Ingrese 4 para seleccionar otra habitacion");
        System.out.print("---> ");
        int opcion_cocina = entrada.nextInt();
        
        switch(opcion_cocina){
            case 1:
                CoffeMaker.encender();
                Sarten.encender();
                System.out.println("Dispositivos de la cocina encendidos\n");
                cocina();
                break;
                
            case 2:
                CoffeMaker.apagar();
                Sarten.apagar();
                System.out.println("Dispositivos de la cocina apagados\n");
                cocina();
                break;
                
            case 3:
                dispositivos_cocina();
                break;
                
            case 4:
                menu();
                break;
                
            default:
                System.out.println("Opcion Invalida. Intente nuevamente");
                cocina();
                break;
        }
    }
    
    //Metodo que contiene un menu donde se seleccionan los dispositivos especificos de la cocina
    public void dispositivos_cocina(){
        System.out.println("Seleccione el dispositivo\n1.Coffe Maker\n2.Sarten\n3.Volver a cocina");
        System.out.print("---> ");
        
        int opcion = entrada.nextInt();
        
        if(opcion == 1){
            menu_coffemaker();
        }
        
        if(opcion == 2){
            menu_sarten();
        }
        
        if(opcion == 3){
            cocina();
        }
        else{
            System.out.println("Dispositivo invalido. Intente de nuevo");
            dispositivos_cocina();
        }
    }
    
    //Metodo que contiene un menu interactivo del coffe maker
    public void menu_coffemaker(){
        System.out.println("\nSi desea encender el Coffe Maker, presione 1");
        System.out.println("Si desea apagar el Coffe Maker, presione 2");
        System.out.println("Si desea preparar cafe, presione 3");
        System.out.println("Si desea seleccionar otro dispositivo, presione 4");
        System.out.print("---> ");
        
        int opcion_coffemaker = entrada.nextInt();
            
        switch(opcion_coffemaker){
            case 1:
                CoffeMaker.encender();
                menu_coffemaker();
                break;
                    
            case 2:
                CoffeMaker.apagar();
                menu_coffemaker();
                break;
                   
            case 3:
                CoffeMaker.prepararCafe();
                menu_coffemaker();
                break;
                    
            case 4:
                dispositivos_cocina();
                break;
                    
            default:
                System.out.println("Entrada invalida, intente de nuevo");
                menu_coffemaker();
                break;
        }
    }
    
    //Metodo que contiene un menu interactivo del sarten
    public void menu_sarten(){
        System.out.println("\nSi desea encender el Sarten, presione 1");
        System.out.println("Si desea apagar el Sarten, presione 2");
        System.out.println("Si desea seleccionar la temperatura del sarten, presione 3");
        System.out.println("Si desea seleccionar otro dispositivo, presione 4");
        System.out.print("---> ");
        
        int opcion_sarten = entrada.nextInt();
            
        switch(opcion_sarten){
            case 1:
                Sarten.encender();
                menu_sarten();
                break;
                    
            case 2:
                Sarten.apagar();
                menu_sarten();
                break;
                   
            case 3:
                Sarten.seleccionar_temperatura();
                menu_sarten();
                break;
                    
            case 4:
                dispositivos_cocina();
                break;
                    
            default:
                System.out.println("Entrada invalida, intente de nuevo");
                menu_sarten();
                break;
        }
    }
    
    //Metodo que contiene un menu de la habitacion cuarto de lavado
    public void cuarto_lavado(){
        System.out.println("Ingrese 1 para encender todos los dispositivos");
        System.out.println("Ingrese 2 para apagar todos los dispositivos");
        System.out.println("Ingrese 3 para controlar un dispositivo especifico");
        System.out.println("Ingrese 4 para seleccionar otra habitacion");
        System.out.print("---> ");
        int opcion_cuartoLavado = entrada.nextInt();
        
        switch(opcion_cuartoLavado){
            case 1:
                Lavadora.encender();
                Secadora.encender();
                System.out.println("Dispositivos del cuarto de lavado encendidos\n");
                cuarto_lavado();
                break;
                
            case 2:
                Lavadora.apagar();
                Secadora.apagar();
                System.out.println("Dispositivos del cuarto de lavado apagados\n");
                cuarto_lavado();
                break;
                
            case 3:
                dispositivos_cuartoLavado();
                break;
                
            case 4:
                menu();
                break;
                
            default:
                System.out.println("Opcion Invalida. Intente nuevamente");
                cuarto_lavado();
                break;
        }
    }
    
    //Metodo que contiene un menu donde se selecciona un objeto del cuarto de lavado especificamente
    public void dispositivos_cuartoLavado(){
        System.out.println("Seleccione el dispositivo\n1.Lavadora\n2.Secadora\n3.Volver a cuarto de lavado");
        System.out.print("---> ");
        
        int opcion = entrada.nextInt();
        
        if(opcion == 1){
            menu_lavadora();
        }
        
        if(opcion == 2){
            menu_secadora();
        }
        
        if(opcion == 4){
            cuarto_lavado();
        }
        else{
            System.out.println("Dispositivo invalido. Intente de nuevo");
            dispositivos_cuartoLavado();
        }
    }
    
    //Metodo que contiene un menu interactivo de la lavadora
    public void menu_lavadora(){
        System.out.println("\nSi desea encender la Lavadora, presione 1");
        System.out.println("Si desea apagar la Lavadora, presione 2");
        System.out.println("Si desea seleccionar un ciclo de lavado, presione 3");
        System.out.println("Si desea seleccionar otro dispositivo, presione 4");
        System.out.print("---> ");
        
        int opcion_lavadora = entrada.nextInt();
            
        switch(opcion_lavadora){
            case 1:
                Lavadora.encender();
                menu_lavadora();
                break;
                    
            case 2:
                Lavadora.apagar();
                menu_lavadora();
                break;
                   
            case 3:
                Lavadora.seleccionar_ciclo();
                menu_lavadora();
                break;
                    
            case 4:
                dispositivos_cuartoLavado();
                break;
                    
            default:
                System.out.println("Entrada invalida, intente de nuevo");
                menu_lavadora();
                break;
        }
    }
    
    //Metodo que contiene un menu interactivo de la secadora
    public void menu_secadora(){
        System.out.println("\nSi desea encender la Secadora, presione 1");
        System.out.println("Si desea apagar la Secadora, presione 2");
        System.out.println("Si desea seleccionar la cantidad de ropa a secar, presione 3");
        System.out.println("Si desea seleccionar otro dispositivo, presione 4");
        System.out.print("---> ");
        
        int opcion_secadora = entrada.nextInt();
            
        switch(opcion_secadora){
            case 1:
                Secadora.encender();
                menu_secadora();
                break;
                    
            case 2:
                Secadora.apagar();
                menu_secadora();
                break;
                   
            case 3:
                Secadora.seleccionar_cantidadRopa();
                menu_secadora();
                break;
                    
            case 4:
                dispositivos_cuartoLavado();
                break;
                    
            default:
                System.out.println("Entrada invalida, intente de nuevo");
                menu_secadora();
                break;
        }
    }
    
}    
