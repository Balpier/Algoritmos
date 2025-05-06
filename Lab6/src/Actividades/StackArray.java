package Actividades;

public class StackArray<E> implements Stack<E> { 
   private E[] array; 
   private int tope; 

   @SuppressWarnings("unchecked") 
   public StackArray(int n) { 
       this.array = (E[]) new Object[n]; 
       tope = -1; 
   } 
   public void push(E x) { 
       if (!isFull()) { 
           array[++tope] = x; 
       } 
   } 
   public E pop() throws ExceptionIsEmpty { 
       if (!isEmpty()) { 
           return array[tope--]; 
       } 
       throw new ExceptionIsEmpty("La pila está vacía"); 
   } 
   public E top() throws ExceptionIsEmpty { 
       if (!isEmpty()) { 
           return array[tope]; 
       } 
       throw new ExceptionIsEmpty("La pila está vacía"); 
   } 
   public boolean isEmpty() { 
     return tope == -1; 
   } 
   public boolean isFull() { 
    return tope == array.length - 1; 
   } 
   
   @Override 
   public String toString() { 
       StringBuilder str = new StringBuilder(); 
       for (int i = 0; i <= tope; i++) { 
           str.append(array[i]).append(" "); 
       } 
       return str.toString(); 
   } 
} 