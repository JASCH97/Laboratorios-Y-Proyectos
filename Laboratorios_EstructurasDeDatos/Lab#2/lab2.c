/******************************************************************************
                            Joan Sanchez Chinchilla
                              carnet: 2015123867
                     Instituto Tecnologico de Costa Rica
                     Laboratorio #2 : Listas enlazadas simples y Punteros
*******************************************************************************/

/*
Este programa le permite al usuario crear una lista enlazada simple, que hace uso de
punteros, donde va a ir guardando los datos de los estudiantes que desee.
Tambien tendrá la opcion de verificar el carnet del estudiante en una posicion
especifica de la lista enlazada.
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
  

//Funcion donde se inserta un nuevo nodo con los datos del estudiante
void insertNode(){
    Node *new = (Node*)malloc(sizeof(Node));    //Se crea un nuevo nodo
    printf("Enter the student name: ");        //Se pide el nombre y carnet del estudiante
    scanf("%s",&new->new_student.name);
    printf("Enter the student card: ");
    scanf("%d",&new->new_student.student_card);
    
    //Validaciones
    if(first==NULL){
        first = new;
        first->next = NULL;
        lastOne = new;
    }
    else{
        lastOne->next = new;
        new->next = NULL;
        lastOne = new;
    }
}


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

//Funcion que contiene el menu principal del programa, es recursivo. 
void textMenu(){
    int option,position,cardVerify;
    printf("\nProgram Menu\n1.Insert student data\n2.Verify student card\n3.Exit\n---> ");
    scanf("%d",&option);
    
    if(option == 1){
        insertNode();
        textMenu();
    }
    
    if(option == 2){
        printf("\nInsert the position of the list where you want to verify the student card: ");
        scanf("%d",&position);
        printf("What is the student card in the position %d ? ",position);
        scanf("%d",&cardVerify);
        
        compareStudentCard(cardVerify,position-1);  //Se llama la funcion que 
                                                    //compara los carnets
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

