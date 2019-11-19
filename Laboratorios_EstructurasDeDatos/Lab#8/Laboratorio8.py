# Clase que contiene el objeto nodo y sus caracteristicas
class Nodo:
	#Se definen atributos
    def __init__(self, valor = None, next = None):
        self.valor = valor
        self.next = next
        
    # Método para actualizar el atributo valor   
    def actualizarValor(self,nuevoValor):
        self.valor = nuevoValor
        
	# Método para actualizar el atributo siguiente
    def actualizarSiguiente(self,nuevoSiguiente):
        self.next = nuevoSiguiente 	

# Clase lista donde se opera una lista enlazada de diferentes maneras
class Lista: 
	#Se define el atributo cabeza
    def __init__(self):
        self.cabeza = None
    
    # Método para agregar elementos al inicio de la lista
    def agregarAlInicio(self, nuevoValor):
        self.cabeza = Nodo(valor=nuevoValor, next=self.cabeza)  

    # Método para agregar elementos al final de la lista
    def agregarAlFinal(self, nuevoValor):
        if not self.cabeza:
            self.cabeza = Nodo(valor=nuevoValor)
            return
            
        actual = self.cabeza
        while actual.next:
            actual = actual.next
            
        actual.next = Nodo(valor=nuevoValor)
    
    # Método para imprimir un elemento de la lista segun el indice
    def indice(self,indice):
        actual = self.cabeza
        if indice == 0:
            print(actual.valor)
			
        else:
            while indice != 0:
                actual = actual.next
                indice = indice -1
			
            print("El nodo de la lista segun el indice es: ",actual.valor)

    # Método para imprimir la lista de nodos
    def imprimirContenido( self ):
        Nodo = self.cabeza
        while Nodo != None:
            print(Nodo.valor,end = " -> ")
            Nodo = Nodo.next
    
    # Método que retorna el tamano de la lista      
    def tamanoLista(self):
        temp = self.cabeza
        cont = 0
        while temp != None:
            temp = temp.next
            cont = cont +1
            
        return cont
	
	# Método que genera un cliclo para limpiar la lista usando otra funcion
    def limpiar(self):
        cont = Lista.tamanoLista(self)
        while cont != -1:
            Lista.limpiarAux(self,cont)
            cont = cont -1
    # Método auxiliar para limpiar la lista
    def limpiarAux(self,indice):
        actual = self.cabeza
        anterior = None
		
        while indice != 0:
            anterior = actual
            actual = actual.next
            indice = indice -1
			
        if anterior is None:
            self.cabeza = actual.next
				
        elif actual:
            anterior.next = actual.next
            actual.next = None
            
	# Método para revertir la lista, que el primero sea el ultimo y el ultimo el primero 
    def reverse(self):
        cont = Lista.tamanoLista(self)
        cont2 = 1
        primero = self.cabeza
        ultimo = self.cabeza
        while cont2 != cont:
            ultimo = ultimo.next
            cont2 = cont2 +1
			
        Lista.limpiarAux(self,0)
        Lista.agregarAlInicio(self,ultimo.valor)
        Lista.limpiarAux(self,cont-1)
        Lista.agregarAlFinal(self,primero.valor)
		 

#-----Pruebas del programa-----#

#Se crea el objeto lista
l = Lista()

#Se agregan nodos
l.agregarAlInicio(3)
l.agregarAlFinal(4)
l.agregarAlFinal(5)

#Si se quiere limpiar la lista
#l.limpiar()

#Para aplicar reverse
#l.reverse()

#Para obtener un nodo segun el indice
#l.indice(1)

#Se imprime el contenido
l.imprimirContenido()






