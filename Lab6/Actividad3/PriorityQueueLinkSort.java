package Actividad3;

import Actividad2.Node;
import Actividades.ExceptionIsEmpty;

class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {
    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }

        public String toString() {
            return "(" + data + ", " + priority + ")";
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x, N pr) {
        EntryNode newEntry = new EntryNode(x, pr);
        Node<EntryNode> newNode = new Node<>(newEntry);

        if (isEmpty()) {
            this.first = this.last = newNode;
        } else if (pr.compareTo(this.first.getData().priority) > 0) {
            // Insertar al inicio si tiene mayor prioridad
            newNode.setNext(this.first);
            this.first = newNode;
        } else {
            Node<EntryNode> current = this.first;
            Node<EntryNode> prev = null;

            while (current != null && pr.compareTo(current.getData().priority) <= 0) {
                prev = current;
                current = current.getNext();
            }

            newNode.setNext(current);
            prev.setNext(newNode);

            if (current == null) {
                this.last = newNode;
            }
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cannot remove from an empty queue");

        E aux = this.first.getData().data;
        this.first = this.first.getNext();
        if (this.first == null)
            this.last = null;
        return aux;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Queue is empty");
        return this.first.getData().data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Queue is empty");
        return this.last.getData().data;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<EntryNode> i = this.first; i != null; i = i.getNext()) {
            sb.append(i.getData()).append(" -> ");
        }
        sb.append("null");
        return sb.toString();
    }
}
