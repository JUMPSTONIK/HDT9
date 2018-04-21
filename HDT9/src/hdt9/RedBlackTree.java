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
     * @param nodo nodo a verificar
     * @return true o false
     */
    private boolean isRed(Node nodo) {
        if (nodo == null){ 
            return false;
        }
        return nodo.color == RED;
    }
    /**
     * regresa el tamaño del nodo
     * @param nodo nodo a medir
     * @return tamaño del nodo
     */
    private int size(Node nodo) {
        if (nodo == null){ 
            return 0;
        }
        return nodo.tamano;
    }
    /**
     * devuelve tamaño del arbol
     * @return tamaño del arbol
     */
    public int size() {
        return size(root);
    }
    /**
     * verifica si estavacio o no
     * @return true o false 
     */
    public boolean isEmpty() {
        return root == null;
    }
    /**
     * devuleve valor dentro del nodo
     * @param key referencia del valor
     * @return valor de dato referido
     */
    @Override
    public String get(String key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }
    /**
     * 
     * devuleve valor dentro del nodo
     * @param nodo nodo al cual se busca un valor
     * @param key referencia del valor
     * @return valor de dato referido
     */
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
    /**
     * verifica el contenido de un dato en el nodo
     * @param key referencia del dato
     * @return 
     */
    public boolean contains(String key) {
        return get(key) != null;
    }
    /**
     * poner valor dentro de un nodo 
     * @param key referencia del valor
     * @param value valor a guardar
     */
    public void put(String key, String value) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (value == null) {
            return;
        }
        root = put(root, key, value);
        root.color = BLACK;
    }
    /**
     * poner y devolver un nodo ingresado
     * @param nodo nodo a poner en un nuevo lugar
     * @param key referencia del valor
     * @param val valor del association
     * @return regresa el nodo
     */
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
    /**
     * esta funcion se encarga de mover un rojo a la derecha
     * @param nodo nodo a mover
     * @return nodo movido con cambio de color
     */
    private Node moveRedRight(Node nodo) {
        flipColors(nodo);
        if (isRed(nodo.getLeft().getLeft())) { 
            nodo = rotateRight(nodo);
            flipColors(nodo);
        }
        return nodo;
    }
    /**
     * aqui se realiza la accion de rotar el nodo a una posicion a la derecha
     * del arbol
     * @param nodo nodo que quiere ser movido
     * @return nodo a mover
     */
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
    /**
     * aqui se mueve el nodo rojo a la izquierda
     * @param nodo nodo a mover
     * @return nodo que sera movido
     */
        private Node moveRedLeft(Node nodo) {
        flipColors(nodo);
        if (isRed(nodo.getRight().getLeft())) { 
            nodo.setRight(rotateRight(nodo.getRight()));
            nodo = rotateLeft(nodo);
            flipColors(nodo);
        }
        return nodo;
    }
        /**
         * aqui se realiza la rotacion a la izquierda del nodo en el arbol
         * @param nodo nodo a mover
         * @return devuelve el nodo movido
         */
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
    /**
     * se realiza el cambio de color a un nodo
     * @param nodo 
     */
    private void flipColors(Node nodo) {
        nodo.color = !nodo.color;
        nodo.getLeft().color = !nodo.getLeft().color;
        nodo.getRight().color = !nodo.getRight().color;
    }
    /**
     * esta funcionse encarga de balancear los nodos del arbol
     * @param nodo nodo a ser balanceado en el arbol
     * @return nodo balanceado
     */
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
}
