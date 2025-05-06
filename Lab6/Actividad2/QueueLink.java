package Actividad2;

import Actividades.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> { 
    private Node<E> first; 
    private Node<E> last; 

    public QueueLink() { 
        this.first = null; 
        this.last = null; 
    } 
    public void enqueue(E x) { 
        Node<E> aux = new Node<>(x); 
        if (this.isEmpty()) { 
            this.first = aux; 
        } else { 
            this.last.setNext(aux); 
        } 
        this.last = aux; 
    } 

    public E dequeue() throws ExceptionIsEmpty { 
    	//eliminar el elemnto que esta al final de la fila y devolver ese elemento 
    	E elm = null; 
    	if (isEmpty())  { 
    		throw new ExceptionIsEmpty( "Queue us empty...");   
    	} 
    	else if (first == last) { 
    			elm = first.getData(); 
    			first = null; 
    			last = null; 
    	} 
    	else { 
    		elm = first.getData(); 
    		first = first.getNext(); 
    	} 
    	return elm; 
    } 
    public E back() throws ExceptionIsEmpty { 
    	if (isEmpty()) { 
            throw new ExceptionIsEmpty("Queue us empty..."); 
        } 
        return this.last.getData(); 
    } 
    public E front() throws ExceptionIsEmpty { 
    	if (isEmpty()) { 
            throw new ExceptionIsEmpty("Queue us empty..."); 
        } 
        return this.first.getData(); 
    } 
    public boolean isEmpty() { 
        return this.first == null; 
    } 
    public String toString() { 
    	String str = " "; 
    	for (Node<E> i = this.first; i != null; i = i.getNext()) 
    		str += i.toString()+ ", "; 
    	return str;
    } 
} 