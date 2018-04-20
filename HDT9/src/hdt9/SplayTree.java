/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt9;

/**
 *
 * @author JUMPSTONIK
 * @author Sergio Marchena
 */
public class SplayTree<E> implements InterArboles {
    
    public Node root;
    int i = 0;
    /** Constructor **/
    public SplayTree(){}
    
    @Override
    public boolean contains(String key){
        return get(key) != null;
    }
    @Override
    public String get(String key){
        root = doSplay(root, key);
        int cmp = key.compareTo(root.getKey());
        if (cmp == 0) return root.getValue().getValue().toString();
        else {
            return null;
        }  
    }  
    @Override
    public void put(String key, String value){
        if (root == null) {
            root = new Node(key, value);
            return;
        } 
        root = doSplay(root, key);
        int compara = key.compareTo(root.getKey());
        if (compara < 0) {
            Node nodo = new Node(key, value);
            nodo.setLeft(root.getLeft());
            nodo.setRight(root);
            root.setLeft(null);
            root = nodo;
        }
        else if (compara > 0){
            Node n = new Node(key, value);
            n.setRight(root.getRight());
            n.setLeft(root);
            root.setRight(null);
            root = n;
        }
    }
    public void remove(String key){
        if (root == null) return;
        root = doSplay(root, key);
        int compara = key.compareTo(root.getKey());
        if (compara == 0) {
            if (root.getLeft() == null) {
                root = root.getRight();
            } 
            else {
                Node x = root.getRight();
                root = root.getLeft();
                doSplay(root, key);
                root.setRight(x);
            }
        }
    }
    private Node doSplay(Node nodo, String key){
        if (nodo == null){
            return null;
        }
        int compara = key.compareTo(nodo.getKey());
        if (compara < 0) {
            if (nodo.getLeft() == null){
                return nodo;
            }
            int compara1 = key.compareTo(nodo.getLeft().getKey());
            if (compara1 < 0) {
                nodo.getLeft().setLeft(doSplay(nodo.getLeft().getLeft(), key));
                nodo = rotateRight(nodo);
            }
            else if (compara1 > 0) {
                nodo.getLeft().setRight(doSplay(nodo.getLeft().getRight(), key));
                if (nodo.getLeft().getRight() != null){
                    nodo.setLeft(rotateLeft(nodo.getLeft()));
                }
            }
            
            if (nodo.getLeft() == null){
                return nodo;
            }
            else{     
                return rotateRight(nodo);
            }
        }
        else if (compara > 0) {
            if (nodo.getRight() == null) {
                return nodo;
            }
            int compara1 = key.compareTo(nodo.getRight().getKey());
            if (compara1 < 0) {
                nodo.getRight().setLeft(doSplay(nodo.getRight().getLeft(), key));
                if (nodo.getRight().getLeft() != null)
                    nodo.setRight(rotateRight(nodo.getRight()));
            }
            else if (compara1 > 0) {
                nodo.getRight().setRight(doSplay(nodo.getRight().getRight(), key));
                nodo = rotateLeft(nodo);
            }
            if (nodo.getRight() == null) return nodo;
            else{                 
                return rotateLeft(nodo);
            }
        }
        else{ 
            return nodo;
        }
    }
    public int height() {
        return height(root);
    }
    private int height(Node n) {
        if (n == null) return -1;
        return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
    }   
    public int size() {
        return size(root);
    }
    private int size(Node n) {
        if (n == null) return 0;
        else return 1 + size(n.getLeft()) + size(n.getRight());
    }
    private Node rotateLeft(Node n) {
        Node nodo = n.getRight();
        n.setRight(nodo.getLeft());
        nodo.setLeft(n);
        return nodo;
    }
    private Node rotateRight(Node n) {
        Node nodo = n.getLeft();
        n.setLeft(n.getRight());
        nodo.setRight(n);
        return nodo;
    }
}
