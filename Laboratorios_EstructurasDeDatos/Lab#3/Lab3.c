/******************************************************************************
                            Joan Sanchez Chinchilla
                              carnet: 2015123867
                     Instituto Tecnologico de Costa Rica
                     Laboratorio #3 : Listas enlazadas simples
*******************************************************************************/

/*
Este programa se encarga de permitirle al usuario ingresar a una lista enlazada 
simple la cantidad de estudiantes que este desee. Al mismo tiempo, podra ir 
eliminando estudiantes dada una posicion, comparando sus numeros de carnet y 
agregar dichos estudiantes al inicio o final de la lista.
Las posiciones de la lista para el usuario van a partir de 1. Para ellos no se 
habilita la posicion 0, ya que eso es mas para el programador.
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct student{      //Estructura de tipo estudiante.
    char name[20];          //Tiene dos variables de tipo char e int
    int student_card;
}student;

typedef struct Node {      //Estuctura de nodos con estudiantes como variable
    student new_student;
    struct Node *next;
}Node;

Node *first = NULL;       //Se declaran los punteros de primer y ultimo 
Node *lastOne = NULL;    //elemento de la lista enlazada como NULL
  

//Funcion donde se inserta un nuevo estudiante al final de la lista
void insertEndOfTheList(){
    
    Node *new = (Node*)malloc(sizeof(Node));    //Se crea un nuevo nodo
    printf("Enter the student name: ");        //Se pide el nombre y carnet del estudiante
    scanf("%s",&new->new_student.name);
    printf("Enter the student card: ");
    scanf("%d",&new->new_student.student_card);
    
    //Validaciones
    if(first==NULL){              //En caso de que la lista esté vacia
        first = new;
        first->next = NULL;
        lastOne = new;
    }
    else{                        //En caso de que la lista no esté vaia
        lastOne->next = new;    //se agrega al final de la lista
        new->next = NULL;
        lastOne = new;
    }
}

//Funcion donde se inserta un nuevo estudiante al inicio de la lista
void insertBeginningOfTheList(){
    
    Node *new = (Node*)malloc(sizeof(Node));    //Se crea un nuevo nodo
    printf("Enter the student name: ");        //Se pide el nombre y carnet del estudiante
    scanf("%s",&new->new_student.name);
    printf("Enter the student card: ");
    scanf("%d",&new->new_student.student_card);
    
    //Validaciones
    if(first==NULL){              //En caso de que la lista esté vacia
        first = new;
        first->next = NULL;
        lastOne = new;
    }
    else{                        //En caso de que la lista no esté vacia
        new->next = first;      //se agrega al inicio de la lista
        first = new;
    }
}


/*
Esta funcion se utilizó para llevar un control visual de la lista enlazada.
Asi podia ver literalmente si se eliminaban los elementos o si se colocaban bien
al inicio o final de la lista. 
Queda comentada ya que esto no es del interes del usuario.
Dicha funcion fue tomada y modificada de : 
https://www.geeksforgeeks.org/linked-list-set-1-introduction/

void printList(struct Node* n) { 
    while (n != NULL) { 
        printf("%s %d -", n->new_student.name,n->new_student.student_card); 
        n = n->next; 
    } 
} 
*/


//Funcion que compara el carnet del estudiante con el de la lista enlazada 
//en una posicion especifica
void compareStudentCard(int cardVerify,int cont){
    Node *actual = (Node*)malloc(sizeof(Node));   
    actual = first;
    
    //Se usa un ciclo para encontrar un nodo en una posicion especifica de la lista
    while(cont != 0){
            actual = actual->next;
            cont--;
    }
    
    //Validaciones
    if(actual->new_student.student_card == cardVerify){
        printf("\nThe student card is correct.\n");
        textMenu();
    }
    else{
        printf("\nThe studend card no match.The correct is: %d\n",actual->new_student.student_card);
        textMenu();
    }
    
}

//Funcion que se encarga de eliminar un estudiante de la lista dada una posicion
void deleteStudent(int cont){
    Node *previous = (Node*)malloc(sizeof(Node));    //Nodos para recorrer lista
    Node *removeAux = (Node*)malloc(sizeof(Node));
    removeAux = first;
    previous = NULL;
    
    //Este ciclo lleva directo al elemento que se desea eliminar
    while(cont != 0){ 
        previous = removeAux;          //Se modifican los nodos que recorren la lista
        removeAux = removeAux->next;
        cont--;
    }
    
    //En caso de que el estudiante a borrar sea el primero
    if(removeAux == first){
        first = first->next;
        free(removeAux);            //Se libera la memoria dinamica
    }
    //En cualquier otro caso
    else{
        previous->next = removeAux->next;
        free(removeAux);           //Se libera la memoria dinamica
    }
    
    
}

//Funcion que contiene el menu principal del programa, es recursivo. 
void textMenu(){
    int option,position,cardVerify;
    printf("\nProgram Menu\n1.Insert a student at the end of the list\n");
    printf("2.Insert a student at the beginning of the list\n3.Verify student card\n");
    printf("4.Remove a student in a specific position in the list\n5.Exit\n---> ");
    scanf("%d",&option);
    
    if(option == 1){
        insertEndOfTheList();
        printList(first);
        textMenu();
    }
    
     if(option == 2){
        insertBeginningOfTheList();
        printList(first);
        textMenu();
    }
    
    if(option == 3){
        printf("\nInsert the position of the list where you want to verify the student card: ");
        scanf("%d",&position);
        printf("What is the student card in the position %d ? ",position);
        scanf("%d",&cardVerify);
        
        compareStudentCard(cardVerify,position-1);  //Se llama la funcion que 
                                                    //compara los carnets
        printList(first);
    }
    
    if(option == 4){
        printf("\nInsert the position of the list where you want to delete the student: ");
        scanf("%d",&position);
        deleteStudent(position-1);
        printList(first);
        textMenu();
    }
    
    else{
        exit(0);
    }
}  

//Funcion main del programa
int main()                    
{
    textMenu();        //Se llama la funcion de menu 
    return 0;
}
