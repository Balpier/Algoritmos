package bstreeInterface;

public interface BinarySearchTree<E extends Comparable<E>> {
    //verifica árbol está vacío
    boolean isEmpty();
    
    // Elimina todo
    void destroy();
    
    
    void insert(E data) throws Exceptions.ItemDuplicated;
    
    void delete(E data) throws Exceptions.ItemNoFound, Exceptions.ExceptionIsEmpty;

    boolean search(E data) throws Exceptions.ItemNoFound, Exceptions.ExceptionIsEmpty;
    

    void inOrder();
    void preOrder();
    void postOrder();
}
