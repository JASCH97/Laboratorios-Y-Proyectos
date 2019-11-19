/**********************************************************************
    Instituto Tecnológico de Costa Rica
    Estructuras de Datos IC-2001
    II Semestre 2019
    Profesora: Samanta Ramijan Carmiol
    Ejemplos Prácticos: Lista de Estudiantes
    Estudiante: Joan Sanchez Chinchilla
**********************************************************************/
//Definición de Macros
#define LONGITUD_MAXIMA_NOMBRE 50
#define LONGITUD_MAXIMA_CARNET 12

//Definición de Estructuras
typedef struct nodo_estudiante
{
	int carnet;
	char *nombre;
	struct nodo_estudiante *ref_siguiente;

}nodo_estudiante;

typedef struct lista_estudiantes
{
	nodo_estudiante* ref_final;
	nodo_estudiante *ref_inicio;
	int cantidad;

}lista_estudiantes;

//Definición de Funciones
/*-----------------------------------------------------------------------
	crear_nodo
	Entradas: No recibe parámetros
	Salidas: Retorna un puntero de tipo nodo_estudiante al nodo creado
	Funcionamiento:
		- Solicita al usuario ingresar Nombre y Carnet.
		- Crea un puntero de tipo nodo_estudiante
		- Le asigna al nodo el nombre y carnet ingresados.
		- El nodo apunta a NULL.
		- retorna el puntero al nuevo nodo.
-----------------------------------------------------------------------*/
nodo_estudiante* crear_nodo();
/*-----------------------------------------------------------------------
	inicializar_lista
	Entradas: No recibe parametros
	Salidas: No retorna ningun valor
	Funcionamiento: Inicia una lista, coloca la cantidad en cero y el puntero de
	inicio de la lista lo apunta a NULL
-----------------------------------------------------------------------*/
void inicializar_lista();
/*-----------------------------------------------------------------------
	insertar_inicio
	Entradas: Puntero a un nodo_estudiante "nuevo"
	Salidas: No retorna ningun valor
	Funcionamiento: Si el puntero de la lista indica NULL invoca inicializar_lista y luego
	actualiza el puntero siguiente del nuevo estudiante para que apunte al estudiante en el inicio,
	ademas suma uno a la variable de cantidad. Si la lista no se encuentra vacia
	simplemente realiza el procedimiento anterior.
-----------------------------------------------------------------------*/
void insertar_inicio(nodo_estudiante* nuevo);
/*-----------------------------------------------------------------------
	insertar_final
	Entradas: Puntero a un nodo_estudiante "nuevo"
	Salidas: No retorna ningun valor
	Funcionamiento: Si el puntero de la lista indica NULL invoca inicializar_lista,
	si la cantidad de estudiantes es cero, entonces invoca insertar_inicio de lo contrario
	crea un puntero temporal para recorrer la lista de estudiantes desde el inicio hasta llegar a
	NULL (final de la lista) y poder asi agregar el nuevo estudiante.
-----------------------------------------------------------------------*/
void insertar_final(nodo_estudiante* nuevo);
/*-----------------------------------------------------------------------
	borrar_por_indice
	Entradas: Un entero (int) llamado indice
	Salidas: No retorna ningun valor
	Funcionamiento: Primero crea un puntero llamado temporal de tipo nodo_estudiante
	y lo establece como NULL para luego usarlo como pivote dentro de la lista. Se define
	un contador en cero que se usa luego para saber cuando se llega al nodo que se quiere borrar.
	Si el puntero de la lista apunta a null imprime que la lista se encuentra vacia; valida el indice.
	Se apunta temporal al inicio de la lista, si el indice es 0 es porque se debe borrar el primero
	de la lista, se ajustan los punteros, se suma uno a cantidad y se libera el temporal. Si el indice
	es diferente de 0, se usa un ciclo usando el contador y el indice para llegar al estudiante de la lista
	deseado. Una vez ahi, se ajustan los punteros para borrar el estudiante.
-----------------------------------------------------------------------*/
void borrar_por_indice(int indice);
 /*-----------------------------------------------------------------------
	buscar_por_indice
	Entradas: Un entero (int) llamado indice
	Salidas: retorna un nodo_estudiante
	Funcionamiento:  Se crea un puntero llamado temporal a un nodo_estudiante y se
	establece como NULL. Si la lista apunta a NULL o la el puntero cantidad es cero
	informa que la lista se encuentra vacia. Se procede a validar el indice ingresado.
	SI el indice es correcto, se apunta temporal al inicio de la lista y se crea un contador.
	Con un ciclo usando el contador y el indice se llega al estudiante deseado para asi luego
	poder retornarlo.
-----------------------------------------------------------------------*/
nodo_estudiante* buscar_por_indice(int indice);

 /*-----------------------------------------------------------------------
	validar_carnets
	Entradas: Numero entero (int) llamado carnet_almacenado y
						Numero entero (int) llamado carnet_ingresado
	Salidas: No tiene valor de retorno
	Funcionamiento: Compara el carnet_almacenado con el carnet_ingresado, si son
	iguales, se imprime en pantalla que los carnets son correctos. De lo contrario,
	se imprime que los carnets son incorrectos.
-----------------------------------------------------------------------*/
void validar_carnets(int carnet_almacenado, int carnet_ingresado);
 /*-----------------------------------------------------------------------
	menu
	Entradas:	No recibe parametros
	Salidas: No tiene valor de retorno
	Funcionamiento: Crea las variables de tipo entero opcion,indice y carnet ademas de
	un puntero llamado temporal de tipo nodo_estudiante. Se imprime
	en pantalla un menu recursivo para el usuario.Dada la opcion que elija el usuario se procede a
	llamar las diferentes funciones creadas anteriormente.Si el usuario elije la opcion
	0, el programa finaliza. Si elije 1 se iguala el puntero temporal a la funcion crear_nodo
	y se llama la funcion insertar_inicio. Si elije 2 se iguala el puntero temporal a la funcion crear_nodo
	y se llama la funcion insertar_final. Si elije 3, se le consulta al usuario una posicion, se almacena y
	se iguala el puntero temporal al retorno de la funcion buscar_por_indice. Si existe el estudiante en
	la posicion consultada se procede a consultarle al usuario un carnet para validarlo, se almacena y se
	invica la funcion validar_carnets. Si elije 4 se le consulta al usuario una posicion especifica y se invoca
	la funcion borrar_por_indice con dicha posicion.
-----------------------------------------------------------------------*/
void menu();
 /*-----------------------------------------------------------------------
	main
	Entradas: No requiere parametros
	Salidas: Numero entero (int)
	Funcionamiento: invoca la funcion menu() y retorna 0
-----------------------------------------------------------------------*/
int main();
/*-----------------------------------------------------------------------
 get_user_input
 Entradas: Variable size_t llamada max_size
 Salidas: retorna un puntero de tipo char
 Funcionamiento: Toma lo que ingrese el usuario desde el teclado y lo almacena
 dentro de un puntero llamado buffer. Valida el espacio de memoria usado por el buffer,
 si se presenta un error se notifica.
-----------------------------------------------------------------------*/
char* get_user_input(size_t max_size);
/*-----------------------------------------------------------------------
  get_user_numerical_input
  Entradas: Variable size_t llamada max_size
  Salidas: retorna un int
  Funcionamiento: Convierte una serie de "chars" o cadena de texto a su valor numerico
	y lo retorna.
-----------------------------------------------------------------------*/
int get_user_numerical_input(size_t max_size);

//--METODOS AGREGADOS AL PROGRAMA-------//

/*-----------------------------------------------------------------------
  ultimoLista
  Entradas: No requiere parametros
  Salidas: un nodo_estudiante
  Funcionamiento: Recorre la lista para obtener el ultimo estudiante
-----------------------------------------------------------------------*/
nodo_estudiante* ultimoLista(){

/*-----------------------------------------------------------------------
  peultimoLista
  Entradas: No requiere parametros
  Salidas: un nodo_estudiante
  Funcionamiento: Recorre la lista para obtener el penultimo estudiante
-----------------------------------------------------------------------*/  
nodo_estudiante* penultimoLista()

/*-----------------------------------------------------------------------
  largoLista
  Entradas: No requiere parametros
  Salidas: un entero
  Funcionamiento: Recorre la lista y va sumando 1 a un contador por cada 
  estudiante encontrado. Dicho contador es lo que se retorna.
-----------------------------------------------------------------------*/
int largoLista()


    