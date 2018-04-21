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
    public Node raiz;
    public SplayTree(){}
    @Override
    public boolean contains(String key) {
        return get(key) != null;
    }
    @Override
    public String get(String key) {
        raiz = splaytree(raiz, key);
        int comparable = key.compareTo(raiz.getKey());
        if (comparable == 0){
            return raiz.getValue().getValue().toString();
        }
        else{   
            return null;
        }
    }    
    @Override
    public void put(String key, String value) {
        if (raiz == null) {
            raiz = new Node(key, value);
            return;
        }
        raiz = splaytree(raiz, key);
        int comparable = key.compareTo(raiz.getKey());
        if (comparable < 0) {
            Node nodo = new Node(key, value);
            nodo.setLeft(raiz.getLeft());
            nodo.setRight(raiz);
            raiz.setLeft(null);
            raiz = nodo;
        }
        else if (comparable > 0) {
            Node nodo = new Node(key, value);
            nodo.setRight(raiz.getRight());
            nodo.setLeft(raiz);
            raiz.setRight(null);
            raiz = nodo;
        }
    }
    public void remove(String key) {
        if (raiz == null){
            return;
        }
        raiz=splaytree(raiz, key);
        int comparable = key.compareTo(raiz.getKey());
        if (comparable == 0) {
            if (raiz.getLeft() == null) {
                raiz = raiz.getRight();
            } 
            else {
                Node nodo = raiz.getRight();
                raiz=raiz.getLeft();
                splaytree(raiz, key);
                raiz.setRight(nodo);
            }
        }
    }
    public Node splaytree(Node nodo, String key) {
        if (nodo == null){
            return null;
            }
        int comparable=key.compareTo(nodo.getKey());
        if (comparable < 0) {
            if (nodo.getLeft() == null) {
                return nodo;
            }
            int otrocomparable = key.compareTo(nodo.getLeft().getKey());
            if (otrocomparable < 0) {
                nodo.getLeft().setLeft(splaytree(nodo.getLeft().getLeft(), key));
                nodo = rotateRight(nodo);
            }
            else if (otrocomparable > 0) {
                nodo.getLeft().setRight(splaytree(nodo.getLeft().getRight(), key));
                if (nodo.getLeft().getRight() != null){
                    nodo.setLeft(rotateLeft(nodo.getLeft()));
                }
            }
            if (nodo.getLeft() == null) {
                return nodo;
            }
            else{           
                return rotateRight(nodo);
            }
        }
        else if (comparable > 0) { 
            if (nodo.getRight() == null) {
                return nodo;
            }
            int otrootrocomparable = key.compareTo(nodo.getRight().getKey());
            if (otrootrocomparable < 0) {
                nodo.getRight().setLeft(splaytree(nodo.getRight().getLeft(), key));
                if (nodo.getRight().getLeft() != null){
                    nodo.setRight(rotateRight(nodo.getRight()));
                }
            }
            else if (otrootrocomparable > 0) {
                nodo.getRight().setRight(splaytree(nodo.getRight().getRight(), key));
                nodo = rotateLeft(nodo);
            }
            if (nodo.getRight() == null){
                return nodo;
            }
            else{           
                return rotateLeft(nodo);
            }
        }
        else{ 
            return nodo;
        }
    }
    public int size() {
        return size(raiz);
    }
    private int size(Node nodo) {
        if (nodo == null) return 0;
        else return 1 + size(nodo.getLeft()) + size(nodo.getRight());
    }
    private Node rotateRight(Node nodo) {
        Node nodito = nodo.getLeft();
        nodo.setLeft(nodito.getRight());
        nodito.setRight(nodo);
        return nodito;
    }
    private Node rotateLeft(Node nodo) {
        Node nodito = nodo.getRight();
        nodo.setRight(nodito.getLeft());
        nodito.setLeft(nodo);
        return nodito;
    }
}
