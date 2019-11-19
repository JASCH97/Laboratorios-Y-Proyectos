# Laboratorio3-POO

IC-2101 Programación Orientada a Objetos
Prof: MSc. Samanta Ramijan Carmiol
Laboratorio 3

El siguiente código es la implementación de una pila en Java:

import java.util.ArrayList;

public class Pila {

    private ArrayList<Object> list = new ArrayList<>();
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int getSize() {
       return list.size();
    }
    
   public Object peek() {
      return list.get(getSize() - 1);
   }
   
   public Object pop() {
       Object o = list.get(getSize() - 1); list.remove(getSize() - 1);
       return o;
   }
   
   public void push(Object o) {
      list.add(o);
   }
   
   @Override
   public String toString() {
      return "pila: " + list.toString();
   }



1. Defina una nueva clase de PilaTEC que extienda a ArrayList y dibuje el diagrama
UML para las clases.

2. Implemente la solución en código.

3. Escriba además un programa de prueba que le solicite al usuario 5 enteros y
después los muestre del último al primero.


Aspectos Administrativos
1. Límite para la entrega de la asignación: Martes 3 de septiembre a las 3pm.

2. Plataforma de revisión: Repositorio de código git

3. Cada archivo debe estar debidamente documentado con la información personal del
estudiante que lo escriba, además de explicar su código e indicar cualquier
referencia a código de terceros

4. Se debe incluir un archivo README que contenga el enunciado de los ejercicios.
