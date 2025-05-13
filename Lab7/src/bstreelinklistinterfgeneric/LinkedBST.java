package bstreelinklistinterfgeneric;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import bstreeInterface.BinarySearchTree;

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

    private Node<E> findMinNode(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public void inOrder() {
        System.out.print("In-Order: ");
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
        System.out.print("Pre-Order: ");
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
        System.out.print("Post-Order: ");
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
}

