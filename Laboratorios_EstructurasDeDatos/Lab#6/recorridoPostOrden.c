/******************************************************************************

                            Laboratorio #6 Recorrido de Arboles
                                 Estructuras de Datos
                             Prof: MSc. Samanta Ramijan Carmiol
                                Joan Sanchez Chinchilla
                                  Carné: 2015123867

*******************************************************************************/

#include<stdio.h>
#include<stdlib.h>


struct nodo {                //Se crea la estructura nodo. Cada nodo va a tener un valor
    int valor;
    struct nodo *izq;       //Se crean punteros para moverse a la izquierda o derecha del arbol
    struct nodo *der;
};

struct nodo *raiz=NULL;     //Puntero a la raiz se establece NULL

//Metodo para insertar un nuevo nodo al arbol. Recibe como parametro un entero
void insertar_nodo(int entero)
{
    struct nodo *nuevo;                     //Se crea un puntero nuevo de struct nodo
    nuevo = malloc(sizeof(struct nodo));
    nuevo->valor = entero;                 //Se agrega el entero al valor del nodo
    nuevo->izq = NULL;                    //Se apunta izq y der a NULL
    nuevo->der = NULL;
    if (raiz == NULL) {                 //Si no hay nada en la raiz, el nuevo nodo sera la raiz
        raiz = nuevo;
    }

    else                               //En caso de que ya exista un nodo raiz
    {
        struct nodo *anterior, *pos;  //Se crean punteros al nodo anterior y a la posicion actual en el arbol
        anterior = NULL;              //Se apunta anterior a NULL y pos a raiz
        pos = raiz;

        //Se crea un ciclo para colocarse a la izquierda o derecha del nodo comparando los valores
        //Si el valor es menor, se mueve a la izquierda, de lo contrario a la derecha
        while (pos != NULL)
        {
            anterior = pos;
            if (entero < pos->valor)
                pos = pos->izq;
            else
                pos = pos->der;
        }

        if (entero < anterior->valor)
            anterior->izq = nuevo;
        else
            anterior->der = nuevo;
    }
}


//Metodo que imprime los nodos del arbol haciendo un recorrido post-orden
void imprimirPostOrden(struct nodo *pos)
{
    if (pos != NULL)
    {
        imprimirPostOrden(pos->izq);    //Llamadas recursivas para hacer el recorrido segun la posicion
        imprimirPostOrden(pos->der);
        printf("%i-",pos->valor);      //Se 'Visita' el valor, entonces se imprime
    }
}


void main()
{
    //Se insertan varios nodos al arbol. El primero en insertarse siempre va a ser la raiz,
    //los siguientes se acomodan a partir de dicha raiz.
    insertar_nodo(67);
    insertar_nodo(70);
    insertar_nodo(55);
    insertar_nodo(46);
    insertar_nodo(72);
    insertar_nodo(29);
    insertar_nodo(30);

    printf("Impresion postorden: ");
    imprimirPostOrden(raiz);

}
