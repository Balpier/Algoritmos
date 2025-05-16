package Ejercicio;

import bstreeInterface.BinarySearchTree;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import Exceptions.ExceptionIsEmpty;
import java.util.LinkedList;
import java.util.Queue;

class Node<E extends Comparable<E>> {
    E data;
    Node<E> left, right;

    public Node(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    private Node<E> root;

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void destroy() {
        root = null;
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insertRecursive(root, data);
    }

    private Node<E> insertRecursive(Node<E> node, E data) throws ItemDuplicated {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insertRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRecursive(node.right, data);
        } else {
            throw new ItemDuplicated("El elemento '" + data + "' ya existe en el BST.");
        }
        return node;
    }

    @Override
    public void delete(E data) throws ItemNoFound, ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El BST está vacío.");
        }
        root = deleteRecursive(root, data);
    }

    private Node<E> deleteRecursive(Node<E> node, E data) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("El elemento '" + data + "' no se encuentra en el BST.");
        }
        if (data.compareTo(node.data) < 0) {
            node.left = deleteRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = deleteRecursive(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node<E> minRight = findMinNode(node.right);
            node.data = minRight.data;
            node.right = deleteRecursive(node.right, minRight.data);
        }
        return node;
    }
	 // Método para encontrar el nodo con el valor mínimo en un subárbol
	    private Node<E> findMinNode(Node<E> node) throws ItemNoFound {
	        if (node == null) {
	            throw new ItemNoFound("El subárbol está vacío. No se puede encontrar el mínimo.");
	        }
	        while (node.left != null) {
	            node = node.left;
	        }
	        return node;
	    }


    @Override
    public boolean search(E data) throws ItemNoFound, ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El BST está vacío.");
        }
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node<E> node, E data) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("El elemento '" + data + "' no se encuentra en el BST.");
        }
        if (data.compareTo(node.data) == 0) {
            return true;
        }
        return data.compareTo(node.data) < 0 ? searchRecursive(node.left, data) : searchRecursive(node.right, data);
    }

    @Override
    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node<E> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.data + " ");
            inOrderRecursive(node.right);
        }
    }

    @Override
    public void preOrder() {
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Node<E> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    @Override
    public void postOrder() {
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(Node<E> node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }

    
    
    // Método para destruir todos los nodos del árbol
    public void destroyNodes() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El BST está vacío.");
        }
        root = null;
        System.out.println("Todos los nodos han sido eliminados.");
    }

    // Método para contar nodos no-hoja
    public int countAllNodes() {
        return countAllNodesRecursive(root);
    }

    private int countAllNodesRecursive(Node<E> node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        return 1 + countAllNodesRecursive(node.left) + countAllNodesRecursive(node.right);
    }

    // Método para contar todos los nodos
    public int countNodes() {
        return countNodesRecursive(root);
    }

    private int countNodesRecursive(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodesRecursive(node.left) + countNodesRecursive(node.right);
    }

    // Método iterativo para calcular la altura de un subárbol dado
    public int height(E data) throws ItemNoFound, ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El BST está vacío.");
        }
        Node<E> current = root;
        int height = 0;
        while (current != null) {
            if (data.compareTo(current.data) == 0) {
                return height(current);
            }
            current = data.compareTo(current.data) < 0 ? current.left : current.right;
            height++;
        }
        return -1;
    }

    private int height(Node<E> node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Método para calcular la amplitud de un nivel
    public int amplitude(int level) throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El BST está vacío.");
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentLevel == level) {
                return size;
            }
            for (int i = 0; i < size; i++) {
                Node<E> node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            currentLevel++;
        }
        return 0;
    }
}
