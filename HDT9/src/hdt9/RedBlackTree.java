/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// https://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html
package hdt9;

import java.util.NoSuchElementException;

/**
 *
 * @author SergioMarchena
 */
public class RedBlackTree<E> implements InterArboles {
    private Node root;
    boolean RED   = true;
    boolean BLACK = false;
    
    public RedBlackTree() {
    }
    /**
     * verifica el contenido del nodo y hacerlo rojo
     * @param nodo
     * @return 
     */
    private boolean isRed(Node nodo) {
        if (nodo == null){ 
            return false;
        }
        return nodo.color == RED;
    }
    private int size(Node nodo) {
        if (nodo == null){ 
            return 0;
        }
        return nodo.tamano;
    } 
    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String get(String key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }
    private String get(Node nodo, String key) {
        while (nodo != null) {
            int compara = key.compareTo(nodo.getKey());
            if      (compara < 0) {
                nodo = nodo.getLeft();
            }
            else if (compara > 0) {
                nodo = nodo.getRight();
                }
            else {            
                return nodo.getValue().getValue().toString();
            }
        }
        return null;
    }
    public boolean contains(String key) {
        return get(key) != null;
    }
    public void put(String key, String val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            return;
        }
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node nodo, String key, String val) { 
        if (nodo == null) {
            return new Node(key, val, RED, 1);
        }
        int compara = key.compareTo(nodo.getKey());
        if      (compara < 0) {
            nodo.setLeft(put(nodo.getLeft(),  key, val)); 
        }
        else if (compara > 0) {
            nodo.setRight(put(nodo.getRight(), key, val)); 
        }
        else {     
            nodo.setVal(val);
        }
        if (isRed(nodo.getRight()) && !isRed(nodo.getLeft())){  
            nodo = rotateLeft(nodo);
        }
        if (isRed(nodo.getLeft())  &&  isRed(nodo.getLeft().getLeft())){ 
            nodo = rotateRight(nodo);
        }
        if (isRed(nodo.getLeft())  &&  isRed(nodo.getRight())) {   
            flipColors(nodo);
        }
        nodo.tamano = size(nodo.getLeft()) + size(nodo.getRight()) + 1;
        return nodo;
    }

    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }
        if (!isRed(root.left) && !isRed(root.right)){
            root.color = RED;
        }
        root = deleteMax(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }
    private Node deleteMax(Node nodo) { 
        if (isRed(nodo.left)){
            nodo = rotateRight(nodo);
        }
        if (nodo.right == null){
            return null;
        }

        if (!isRed(nodo.right) && !isRed(nodo.right.left)){
            nodo = moveRedRight(nodo);
        }
        nodo.right = deleteMax(nodo.right);
        return balance(nodo);
    }

//    public void delete(Key key) { 
//        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
//        if (!contains(key)) return;
//
//        // if both children of root are black, set root to red
//        if (!isRed(root.left) && !isRed(root.right))
//            root.color = RED;
//
//        root = delete(root, key);
//        if (!isEmpty()) root.color = BLACK;
//        // assert check();
//    }

    // delete the key-value pair with the given key rooted at h
//    private Node delete(Node h, Key key) { 
//        // assert get(h, key) != null;
//
//        if (key.compareTo(h.key) < 0)  {
//            if (!isRed(h.left) && !isRed(h.left.left))
//                h = moveRedLeft(h);
//            h.left = delete(h.left, key);
//        }
//        else {
//            if (isRed(h.left))
//                h = rotateRight(h);
//            if (key.compareTo(h.key) == 0 && (h.right == null))
//                return null;
//            if (!isRed(h.right) && !isRed(h.right.left))
//                h = moveRedRight(h);
//            if (key.compareTo(h.key) == 0) {
//                Node x = min(h.right);
//                h.key = x.key;
//                h.val = x.val;
//                // h.val = get(h.right, min(h.right).key);
//                // h.key = min(h.right).key;
//                h.right = deleteMin(h.right);
//            }
//            else h.right = delete(h.right, key);
//        }
//        return balance(h);
//    }

    private Node moveRedRight(Node nodo) {
        flipColors(nodo);
        if (isRed(nodo.getLeft().getLeft())) { 
            nodo = rotateRight(nodo);
            flipColors(nodo);
        }
        return nodo;
    }
    private Node rotateRight(Node nodo) {
        Node n = nodo.getLeft();
        nodo.setLeft(n.getRight());
        n.setRight(nodo);
        n.color = n.getRight().color;
        n.getRight().color = RED;
        n.tamano = nodo.tamano;
        nodo.tamano = size(nodo.getLeft()) + size(nodo.getRight()) + 1;
        return n;
    }
        private Node moveRedLeft(Node nodo) {
        flipColors(nodo);
        if (isRed(nodo.getRight().getLeft())) { 
            nodo.setRight(rotateRight(nodo.getRight()));
            nodo = rotateLeft(nodo);
            flipColors(nodo);
        }
        return nodo;
    }
    private Node rotateLeft(Node nodo) {
        Node n = nodo.getRight();
        nodo.setRight(n.getLeft());
        n.setLeft(nodo);
        n.color = n.getLeft().color;
        n.getLeft().color = RED;
        n.tamano = nodo.tamano;
        nodo.tamano = size(nodo.getLeft()) + size(nodo.getRight()) + 1;
        return n;
    }
    private void flipColors(Node nodo) {
        nodo.color = !nodo.color;
        nodo.getLeft().color = !nodo.getLeft().color;
        nodo.getRight().color = !nodo.getRight().color;
    }
    private Node balance(Node nodo) {
        if (isRed(nodo.getRight())){                     
            nodo = rotateLeft(nodo);
        }
        if (isRed(nodo.getLeft()) && isRed(nodo.getLeft().getLeft())) {
            nodo = rotateRight(nodo);
        }
        if (isRed(nodo.getLeft()) && isRed(nodo.getRight()))  {   
            flipColors(nodo);
        }
        nodo.tamano = size(nodo.getLeft()) + size(nodo.getRight()) + 1;
        return nodo;
    }

   /***************************************************************************
    *  Utility functions.
    ***************************************************************************/
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    
}
