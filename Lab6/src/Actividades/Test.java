package Actividades;

public class Test { 

    public static void main(String[] args) { 
        testStack(new StackArray<>(1));  
        testStack(new StackArray<>(3));  
        testStack(new StackArray<>(4));  
    } 
    public static <E> void testStack(Stack<E> stack) { 
        try {         
            stack.push((E) "Primer elemento"); 
            stack.push((E) "Segundo elemento"); 
            System.out.println("Pila antes del pop: " + stack); 
            System.out.println("Top: " + stack.top()); 
            System.out.println("Pop: " + stack.pop()); 
            System.out.println("Top después del pop: " + stack); 
            System.out.println(); 
        } catch (Exception e) { 
            System.out.println(e.getMessage()); 
        } 
    } 
} 