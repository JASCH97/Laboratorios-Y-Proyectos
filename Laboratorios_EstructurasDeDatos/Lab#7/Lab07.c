/**********************************************************************
    Instituto Tecnológico de Costa Rica
    Estructuras de Datos IC-2001
    II Semestre 2019
    Profesora: Samanta Ramijan Carmiol
    Representacion de un grafo con listas adyacentes
    Estudiante: Joan Sanchez Chinchilla
**********************************************************************/

#include <stdio.h>
#include <stdlib.h>
 
//Definicion de la estructura nodo (en este programa los nodos cumplen como vertices, personas)
struct nodo
{
    int vertice;
    struct nodo* sig;
};

//Definicion de la estructura grafo
struct Grafo
{
    int numVertices;
    struct nodo** listasAdy;
};


//metodo que crea un nodo y le agrega el vertice correspondiente
struct nodo* crearNodo(int v)
{
    struct nodo* nuevoNodo = malloc(sizeof(struct nodo));
    nuevoNodo->vertice = v;
    nuevoNodo->sig = NULL;
    return nuevoNodo;
}

//metodo que crea un grafo rellenando los espacios de las listas de adyacencia con NULL
struct Grafo* crearGrafo(int vertices)
{
    struct Grafo* grafo = malloc(sizeof(struct Grafo));
    grafo->numVertices = vertices;
 
    grafo->listasAdy = malloc(vertices * sizeof(struct nodo*));
 
    int i;
    for (i = 0; i < vertices; i++)
        grafo->listasAdy[i] = NULL;
 
    return grafo;
}
 
 //metodo que crea relacion bilateral entre dos nodos (vertices)
void agregarRelacion(struct Grafo* grafo, int inicio,int destino)
{
    
    // se agrega una arista del inicio al destino
    struct nodo* nuevoNodo = crearNodo(destino);
    nuevoNodo->sig = grafo->listasAdy[inicio];
    grafo->listasAdy[inicio] = nuevoNodo;
 
    // se agrega una arista del destino al inicio 
    nuevoNodo = crearNodo(inicio);
    nuevoNodo->sig = grafo->listasAdy[destino];
    grafo->listasAdy[destino] = nuevoNodo;
}

//metodo que imrpime el grafo (las listas de adyacencia)
void imprimirGrafo(struct Grafo* grafo)
{
    int v;
    for (v = 0; v < grafo->numVertices; v++)
    {
        struct nodo* temp = grafo->listasAdy[v];
        
        printf("\n Lista de adyacencia de la persona %d\n ", v);
        while (temp)
        {
            printf("%d -> ", temp->vertice);
            temp = temp->sig;
        }
        printf("\n");
    }
}

int main()
{
    printf("El siguiente grafo por medio de listas de adyacencia es en base a mis familiares\n");
    
    struct Grafo* grafo = crearGrafo(10);  //Se crea un grafo con 10 vertices (10 personas)
    
    agregarRelacion(grafo,0, 2);       //Se agregan las relaciones entre los vertices
    agregarRelacion(grafo,0, 3);
    agregarRelacion(grafo,0, 4);
    agregarRelacion(grafo,0, 5);
    agregarRelacion(grafo,0, 7);
    agregarRelacion(grafo,0, 8);
    agregarRelacion(grafo,0, 9);
    
    agregarRelacion(grafo,1, 5);
    agregarRelacion(grafo,1, 3);
    
    agregarRelacion(grafo,2,3);
    agregarRelacion(grafo,2,4);
    agregarRelacion(grafo,2,5);
    agregarRelacion(grafo,2,6);
    agregarRelacion(grafo,2,8);
    
    agregarRelacion(grafo,3,4);
    agregarRelacion(grafo,3,5);
    agregarRelacion(grafo,3,9);
    
    agregarRelacion(grafo,4,0);
    agregarRelacion(grafo,4,5);
    agregarRelacion(grafo,4,7);
    agregarRelacion(grafo,4,9);
    
    agregarRelacion(grafo,5,7);
    agregarRelacion(grafo,5,8);
    agregarRelacion(grafo,5,9);
    
    agregarRelacion(grafo,7,9);
    agregarRelacion(grafo,7,8);
    
    agregarRelacion(grafo,8,9);



    imprimirGrafo(grafo);
 
    printf("\nLa persona 0 es: Jenny\n");
    printf("La persona 1 es: Eco\n");
    printf("La persona 2 es: Faustino\n");
    printf("La persona 3 es: Roger\n");
    printf("La persona 4 es: Rocio\n");
    printf("La persona 5 es: Analia\n");
    printf("La persona 6 es: Adis\n");
    printf("La persona 7 es: Noris\n");
    printf("La persona 8 es: Julio\n");
    printf("La persona 9 es: Aida\n");
    
    return 0;
}