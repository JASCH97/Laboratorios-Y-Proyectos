/**********************************************************************
    Instituto Tecnológico de Costa Rica
    Estructuras de Datos IC-2001
    II Semestre 2019
    Profesora: Samanta Ramijan Carmiol
    Ejemplos Prácticos: Lista de Estudiantes
    Estudiante: Joan Sanchez Chinchilla
**********************************************************************/

#include <stdio.h>
#include "main.h"
#include <stdlib.h>
#include <string.h>

lista_estudiantes *ref_lista = NULL;

nodo_estudiante* crear_nodo(){
	char *ref_nombre;
	size_t max_size;
	int carnet;
	printf("\n---------------------------------------------------------------------");
	printf("\nPara agregar un estudiante por favor ingrese los siguientes datos");
	printf("\n---------------------------------------------------------------------");
	ref_nombre = (char *) malloc (LONGITUD_MAXIMA_NOMBRE);
	printf("\n>> Nombre:");
	max_size = LONGITUD_MAXIMA_NOMBRE;
   ref_nombre = get_user_input(max_size);
   max_size = LONGITUD_MAXIMA_CARNET;
   printf(">> Carnet:");
   carnet = get_user_numerical_input(max_size);

	nodo_estudiante* nuevo;
	nuevo = malloc (sizeof (nodo_estudiante));
	nuevo->carnet = carnet;
	nuevo->nombre = ref_nombre;
	nuevo->ref_siguiente = NULL;
	return nuevo;
}

void inicializar_lista(){
	ref_lista = malloc(sizeof (lista_estudiantes));
	ref_lista->cantidad=0;
	ref_lista->ref_inicio = NULL;
	ref_lista->ref_final = NULL;
}

//metodo que retorna el ultimo de la lista
nodo_estudiante* ultimoLista(){
    nodo_estudiante*temp;
    int largo = 0;
	temp = ref_lista->ref_inicio;
	int cont = ref_lista->cantidad;
	while(cont != 0){
		temp = temp->ref_siguiente;
		cont--;
		largo++;
	}
	ref_lista->ref_final = temp;
	return temp;
	
}

//metodo que retorna el penultimo de la lista
nodo_estudiante* penultimoLista(){
    nodo_estudiante*temp;
    int largo = 0;
	temp = ref_lista->ref_inicio;
	int cont = (ref_lista->cantidad)-2;
	while(cont != 0){
		temp = temp->ref_siguiente;
		cont--;
		largo++;
	}
	ref_lista->ref_final = temp;
	return temp;
	
}

//Metodo que retorna el largo de la lista
int largoLista(){
    nodo_estudiante*temp;
    int largo = 0;
	temp = ref_lista->ref_inicio;
	int cont = ref_lista->cantidad;
	while(cont != 0){
		temp = temp->ref_siguiente;
		cont--;
		largo++;
	}
	return largo;
	
}

//metodo de debbugeo
void mostrar_final(){
    printf("%s",ref_lista->ref_final->nombre);
}
void insertar_inicio(nodo_estudiante* nuevo){ 
    if(ref_lista->cantidad == 0){
        nuevo->ref_siguiente = ref_lista->ref_inicio;
        ref_lista->ref_inicio = nuevo;
        ref_lista->ref_final = nuevo;  //se iguala el ultimo al primero
        ref_lista->ref_final->ref_siguiente = ref_lista->ref_inicio; //apunta ultimo a primero
        ref_lista->cantidad = ref_lista->cantidad+1;
        mostrar_final();//***********************
    }
    else{
        nuevo->ref_siguiente = ref_lista->ref_inicio;
        ref_lista->ref_inicio = nuevo;
        ref_lista->ref_final = ultimoLista();  //se obtiene el ultimo
        ref_lista->ref_final->ref_siguiente = ref_lista->ref_inicio; //apunta ultimo a primero
        ref_lista->cantidad = ref_lista->cantidad+1;
        mostrar_final(); //********************** Debuggeo
    }
}


void insertar_final(nodo_estudiante* nuevo){
	if (ref_lista->cantidad == 0){
	   insertar_inicio(nuevo);
	}
	else{
	    nodo_estudiante* temporal;
  		temporal = malloc (sizeof (nodo_estudiante));
  		temporal = ref_lista->ref_inicio;
		while (temporal->ref_siguiente != ultimoLista()){
			temporal = temporal->ref_siguiente;
		}
		temporal->ref_siguiente = nuevo;
		ref_lista->cantidad++;
		nuevo->ref_siguiente = ref_lista->ref_inicio; //ultimo apunta primero
		mostrar_final(); //********************** Debuggeo
 	}

}

void borrar_por_indice(int indice) {
	nodo_estudiante* temporal;
  	temporal = malloc (sizeof (nodo_estudiante));
  	temporal = NULL;

	int cont = 0;

	if (ref_lista->ref_inicio == NULL){
		printf("\nLa lista está vacía");
		return;
	}else{
		if (indice >= ref_lista->cantidad){
			printf("\nEl índice ingresado no es valido");
			return;
		}
		else{
			nodo_estudiante* temporal;
  			temporal = malloc (sizeof (nodo_estudiante));
  			temporal = ref_lista->ref_inicio;
  			if (indice == 0){
				ref_lista->ref_inicio = temporal->ref_siguiente;
				ref_lista->cantidad--;
				ref_lista->ref_final->ref_siguiente = ref_lista->ref_inicio; //que el ultimo apunte al nuevo primero
				free(temporal);
				return;
  			}
  			if (indice == ref_lista->cantidad){   //si el que se borra es el ultimo
  			    ref_lista->ref_final = penultimoLista();
  			    ref_lista->cantidad--;
  			    ref_lista->ref_final->ref_siguiente = ref_lista->ref_inicio; //el nuevo ultimo apunta al primero
  			    //no se libera el temporal debido a que no se usa en este if
  			}
  			else{
  			    while(cont!=indice){
  			        cont++;
					if (cont == indice){
						temporal->ref_siguiente = temporal->ref_siguiente->ref_siguiente;
						ref_lista->cantidad--;
						return;
					}
					temporal = temporal->ref_siguiente;
  			    }
  			    
  			    
  			}
		}
	}
}



void imprimir(){
	printf("\n---------------------------------------------------------------------");
	printf("\n Lista de estudiantes");
	printf("\n---------------------------------------------------------------------");
	int cont = 0;
	int cont2 = largoLista()-1;
	if (ref_lista == NULL || ref_lista->cantidad==0){
		printf("\n No hay estudiantes registrados");
		return;
	}else{
  		nodo_estudiante* temporal;
  		temporal = malloc (sizeof (nodo_estudiante));
  		temporal = ref_lista->ref_inicio;
		while (cont2!=0){ //se cambia la condicion
			printf("\n   [%i] %i %s",cont,temporal->carnet,temporal->nombre);
			temporal = temporal->ref_siguiente;
			cont++;
			cont2--;
		}
		printf("\n   [%i] %i %s",cont,temporal->carnet,temporal->nombre);
	}
	printf("\n---------------------------------------------------------------------");
	printf("\n    %i Estudiantes registrados", ref_lista->cantidad);
	printf("\n---------------------------------------------------------------------");
}

nodo_estudiante* buscar_por_indice(int indice) {
	nodo_estudiante* temporal;
  	temporal = malloc (sizeof (nodo_estudiante));
  	temporal = NULL;
	if (ref_lista->ref_inicio == NULL || ref_lista->cantidad ==0){
		printf("\nLa lista está vacía");
		return temporal;
	}else{
		if (indice >= ref_lista->cantidad){
			printf("\nEl índice ingresado no es valido");
			return temporal;
		} else{
			int cont = 0;
			nodo_estudiante* temporal;
  			temporal = malloc (sizeof (nodo_estudiante));
  			temporal = ref_lista->ref_inicio;
			while (temporal->ref_siguiente != ref_lista->ref_final){
				if (cont == indice){
					return temporal;
				}
				temporal = temporal->ref_siguiente;
				cont++;
			}
			return temporal;
		}
	}
}

void validar_carnets(int carnet_almacenado, int carnet_ingresado){
	if(carnet_almacenado == carnet_ingresado){
		printf("\n El carnet ingresado es correcto");
	}else{
		printf("\n El carnet ingresado es incorrecto");
	}
}


void menu() {
	size_t max_size;
    int opcion,indice,carnet;
    nodo_estudiante* temporal;
	do{
		printf("\n\n\n\n\n");
		imprimir();
		printf("\n---------------------------------------------------------------------");
		printf("\n(0) Salir");
		printf("\n(1) Agregar estudiante al final");
		printf("\n(2) Agregar estudiante al inicio");
		printf("\n(3) Validar carnet de estudiante en posicion dada");
		printf("\n(4) Borrar un estudiante en posicion dada");
		printf("\n---------------------------------------------------------------------");
		printf("\n>> Opcion deseada: ");
		max_size = 1;
		opcion = get_user_numerical_input(max_size);
		switch(opcion){
			case 0:
				break;
			case 1:
    			temporal = crear_nodo();
    			insertar_final(temporal);
				break;
			case 2:
				temporal = crear_nodo();
    			insertar_inicio(temporal);
				break;
			case 3:
				printf("\n---------------------------------------------------------------------");
				printf("\n>> ¿Qué posición de carnet desea validar? ");
				indice = get_user_numerical_input(1);
				temporal = buscar_por_indice(indice);
				if(temporal != NULL){
					printf("\n>> ¿Cuál es el carnet del estudiante en la posición indice? ");
					carnet = get_user_numerical_input(1);
					validar_carnets(temporal->carnet, carnet);

				}
				printf("\n---------------------------------------------------------------------");
				break;
			case 4:
				printf("\n---------------------------------------------------------------------");
				printf("\n>> ¿Qué posición de carnet desea borrar? ");
				indice = get_user_numerical_input(1);
				borrar_por_indice(indice);
				break;
		}
	}while(opcion != 0);
}

int main() {
	inicializar_lista();  //se inicializa la lista desde el main, se optimiza el programa
	menu();
	return 0;
}

char* get_user_input(size_t max_size){

    char *buffer;
    size_t characters;

    buffer = (char *)malloc(max_size * sizeof(char));
    if(buffer == NULL){
        perror("ERROR No fue posible reservar memoria para el buffer");
        exit(1);
    }
    characters = getline(&buffer,&max_size,stdin);
    buffer[strlen(buffer)-1]= 0;
    return buffer;
}

int get_user_numerical_input(size_t max_size){
	int numerical_input = atoi(get_user_input(max_size));
	return numerical_input;
}
