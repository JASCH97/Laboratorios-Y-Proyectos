/******************************************************************************

                            Joan Sanchez Chinchilla
                              carnet: 2015123867
                     Instituto Tecnologico de Costa Rica
                     Laboratorio #1 : Arreglos y Structs

*******************************************************************************/

/*Este programa le permite al usuario ingresar el nombre y el numero de carnet de
  10 estudiantes. Los datos se van a almacenar dentro de un arreglo que forma parte
  de una estructura tipo "estudiante".
  Para efectos del programa deberá saber que una vez ingresados todos los datos, 
  se procedera a preguntarle al usuario 10 veces, por los datos de un estudiante 
  en especifico. Si coloca mal los datos se le va a corregir.
*/

#include <stdio.h>

struct estudiante {             //Se crea una estructura de nombre estudiante,
        char nombre[20];        //posee 2 tipos de datos en su interior: int y char.
        int carnet;            //Ademas posee una variable que es un arreglo de 10 espacios.
    } arreglo[9];
    
        
    
int main()                     //funcion main del programa
{
    int i;                    //variable entera que se utiliza como contador
                
    for(i=0; i<10;i++){       //se crea un ciclo para consultarle al usuario y almacenar
                             //los nombres y numeros de carnet de cada estudiante
        printf("Ingrese el nombre del estudiante %d: ",i+1);
        scanf("%s", &arreglo[i].nombre);
        printf("Ingrese el numero de carnet del estudiante %d: ",i+1);
        scanf("%d", &arreglo[i].carnet);
    }
    
    printf("\n");
    int carnet,j;           //variable j que funciona como contador. 
    char nombre[20];        //varible carnet guardara un numero de carnet para comparar
                            //variable nombre guardara un nombre de estudiante para comparar
    
    
    for(i=0;i<10;i++){      //Se crea un ciclo donde se le consulta 10 veces al usuario por
                            //un estudiante en especifico de la lista. Luego se le pregunta por
                            //los datos que ingreso previamente y se comparan.
        
        printf("De cual numero de estudiante desea verificar los datos ingresados recientemente?\n---> ");
        scanf("%d", &j);  //se guarda el numero de estudiante a verificar

        printf("Ingrese cual numero de carnet deberia tener el estudiante %d: ",j);
        scanf("%d", &carnet); //se guarda el numero de carnet a verificar
        
        if(carnet == arreglo[j-1].carnet){   //en caso de que el carnet sea correcto se notifica
            printf("El numero de carnet es CORRECTO.\n");  
        }
        else{                               //en caso de que el carnet sea incorrecto se notifica y se corrige
            printf("El numero de carnet es INCORRECTO. El ingresado fue: %d\n",arreglo[j-1].carnet);
        }
        
        printf("Ingrese cual nombre deberia tener el estudiante %d: ",j);
        scanf("%s", &nombre);    //se guarda el nombre del estudiante para verificar
        
        if(strcmp(nombre,arreglo[j-1].nombre) == 0 ){            //en caso de que el nombre sea correcto se notifica
            printf("El nombre del estudiante es CORRECTO.\n");
        }
        else{                                               //en caso de que el nombre sea incorrecto se notifica y se corrige
            printf("El nombre del estudiante es INCORRECTO. El ingresado fue: %s\n",arreglo[j-1].nombre);
        }
     
    }
    
    return 0;
}
