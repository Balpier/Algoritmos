package Ejercicio1;

import Actividad2.Node;
import Actividades.ExceptionIsEmpty;
import Actividades.Stack;

;

public class StackLink<E> implements Stack<E> {
    private Node<E> top;

    public StackLink() {
        this.top = null;
    }

    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        newNode.setNext(this.top);
        this.top = newNode;
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        E data = this.top.getData();
        this.top = this.top.getNext();
        return data;
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        return this.top.getData();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<E> current = this.top;
        while (current != null) {
            str.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return str.toString();
    }
}
