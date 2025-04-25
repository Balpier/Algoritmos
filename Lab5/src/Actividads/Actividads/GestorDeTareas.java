package Actividads;

import java.util.ArrayList;
import java.util.List;

public class GestorDeTareas {
	private Node<T> head;
	private List<T> tareasCompletadas;
	
	public GestorDeTareas() {
		this.head = null;
		this.tareasCompletadas = new ArrayList<>();
	}
	public void agregarTareas(T tarea) {
		Node<T> nuevo = new Node<>(tarea);
		if (head == null) {
			head = nuevo;
		}
		else {
			Node<T> actual = head;
			while (actual.next != null) {
				actual = actual.next;
			}
			actual.next = nuevo;
		}
	}
	

}
