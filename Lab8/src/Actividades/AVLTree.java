	package Actividades;
	
	
	public class AVLTree<E extends Comparable<E>> extends BSTree<E> {
	
	    @Override
	    public void insert(E data) throws TreeException {
	        root = insertAVL((NodeAVL<E>) root, data);
	    }
	
	    private NodeAVL<E> insertAVL(NodeAVL<E> node, E data) throws TreeException {
	        if (node == null)
	            return new NodeAVL<>(data);
	
	        int cmp = data.compareTo(node.data);
	
	        if (cmp < 0) {
	            node.left = insertAVL((NodeAVL<E>) node.left, data);
	            node = balanceToRight(node);
	        } else if (cmp > 0) {
	            node.right = insertAVL((NodeAVL<E>) node.right, data);
	            node = balanceToLeft(node);
	        } else {
	            throw new TreeException("Elemento duplicado: " + data);
	        }
	        return node;
	    }
	
	    private NodeAVL<E> balanceToLeft(NodeAVL<E> node) {
	        NodeAVL<E> child = (NodeAVL<E>) node.right;
	        if (child == null) return node;
	
	        switch (child.bf) {
	            case 1:
	                node.bf = 0;
	                child.bf = 0;
	                return rotateSL(node);
	            case -1:
	                NodeAVL<E> grandchild = (NodeAVL<E>) child.left;
	                switch (grandchild.bf) {
	                    case -1:
	                        node.bf = 0;
	                        child.bf = 1;
	                        break;
	                    case 0:
	                        node.bf = 0;
	                        child.bf = 0;
	                        break;
	                    case 1:
	                        node.bf = 1;
	                        child.bf = 0;
	                        break;
	                }
	                grandchild.bf = 0;
	                node.right = rotateSR(child);
	                return rotateSL(node);
	        }
	        return node;
	    }
	
	    private NodeAVL<E> balanceToRight(NodeAVL<E> node) {
	        NodeAVL<E> child = (NodeAVL<E>) node.left;
	        if (child == null) return node;
	
	        switch (child.bf) {
	            case -1:
	                node.bf = 0;
	                child.bf = 0;
	                return rotateSR(node);
	            case 1:
	                NodeAVL<E> grandchild = (NodeAVL<E>) child.right;
	                switch (grandchild.bf) {
	                    case 1:
	                        node.bf = 0;
	                        child.bf = -1;
	                        break;
	                    case 0:
	                        node.bf = 0;
	                        child.bf = 0;
	                        break;
	                    case -1:
	                        node.bf = -1;
	                        child.bf = 0;
	                        break;
	                }
	                grandchild.bf = 0;
	                node.left = rotateSL(child);
	                return rotateSR(node);
	        }
	        return node;
	    }
	
	    private NodeAVL<E> rotateSL(NodeAVL<E> k1) {
	        NodeAVL<E> k2 = (NodeAVL<E>) k1.right;
	        k1.right = k2.left;
	        k2.left = k1;
	        return k2;
	    }
	
	    private NodeAVL<E> rotateSR(NodeAVL<E> k2) {
	        NodeAVL<E> k1 = (NodeAVL<E>) k2.left;
	        k2.left = k1.right;
	        k1.right = k2;
	        return k1;
	    }
	    private NodeAVL<E> findMin(NodeAVL<E> node) {
	        while (node.left != null)
	            node = (NodeAVL<E>) node.left;
	        return node;
	    }

	    
	    public void delete(E data) throws TreeException {
	        root = deleteAVL((NodeAVL<E>) root, data);
	    }
	    private NodeAVL<E> deleteAVL(NodeAVL<E> node, E data) throws TreeException {
	        if (node == null) throw new TreeException("Elemento no encontrado: " + data);

	        int cmp = data.compareTo(node.data);

	        if (cmp < 0) {
	            node.left = deleteAVL((NodeAVL<E>) node.left, data);
	            node = balanceToLeft(node); 
	        } else if (cmp > 0) {
	            node.right = deleteAVL((NodeAVL<E>) node.right, data);
	            node = balanceToRight(node); 
	        } else {
	            if (node.left == null && node.right == null)
	                return null;

	            else if (node.left == null)
	                return (NodeAVL<E>) node.right;
	            else if (node.right == null)
	                return (NodeAVL<E>) node.left;

	            NodeAVL<E> successor = findMin((NodeAVL<E>) node.right);
	            node.data = successor.data;
	            node.right = deleteAVL((NodeAVL<E>) node.right, successor.data);
	            node = balanceToRight(node); 
	        }

	        return node;
	    }
	    public void printLevelOrder() {
	        int h = height((Node<E>) root);
	        for (int i = 0; i < h; i++) {
	            printLevel((Node<E>) root, i);
	        }
	        System.out.println();
	    }

	    private void printLevel(Node<E> node, int level) {
	        if (node == null) return;
	        if (level == 0) {
	            System.out.print(node.data + " ");
	        } else {
	            printLevel(node.left, level - 1);
	            printLevel(node.right, level - 1);
	        }
	    }

	    private int height(Node<E> node) {
	        if (node == null) return 0;
	        return 1 + Math.max(height(node.left), height(node.right));
	    }
	    
	    public void printPreOrder() {
	        printPreOrder((Node<E>) root);
	        System.out.println();
	    }

	    private void printPreOrder(Node<E> node) {
	        if (node == null) return;
	        System.out.print(node.data + " ");
	        printPreOrder(node.left);
	        printPreOrder(node.right);
	    }




	}
