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
    /**
     * verifica contenido del key
     * @param key refencia al valor
     * @return true o false
     */
    @Override
    public boolean contains(String key) {
        return get(key) != null;
    }
    /**
     * devuelve en string el valor referenciado
     * @param key referencia
     * @return valor
     */
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
    /**
     * meten un valor a un nodo del splay tree
     * @param key referencia dle valor
     * @param value valor a ingresar
     */
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
    /**
     * encargado del dle ingreso del nodo al arbol y regreso del nodo
     * @param nodo nodo a ingresar
     * @param key referencia dle valor
     * @return nodo del splaytree
     */
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
    /**
     * esta funcion se encarga de rotar el nodo a la derecha
     * @param nodo nodo a mover
     * @return nodo desplazado
     */
    private Node rotateRight(Node nodo) {
        Node nodito = nodo.getLeft();
        nodo.setLeft(nodito.getRight());
        nodito.setRight(nodo);
        return nodito;
    }
    /**
     * esta funcion se encarga de rotar el nodo a la izquierda
     * @param nodo nodo a mover
     * @return nodo desplazado
     */
    private Node rotateLeft(Node nodo) {
        Node nodito = nodo.getRight();
        nodo.setRight(nodito.getLeft());
        nodito.setLeft(nodo);
        return nodito;
    }
}
