/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JUMPSTONIK
 * @author Sergio Marchena
 */
public class Node<E> {
    Association<String,String> data;
    Node<E> parent;
    Node<E> left,right;
    boolean color;
    int tamano;
 
    public Node() {
        
    }
    public Node(String ing, String espa) {
        data = new Association<>(ing, espa);
        parent = null; 
        left = right = null;
    }
    /**
     * devuelve el valor del association
     * @return data
     */
    public Association<String, String> getValue() {
        return data; 
    }
    /**
     * inserta valor
     * @param valor valor a insertar
     */
    public void setVal(String valor) {
        this.data.setValue(valor);
    }
    public Node(String ing, String espa, boolean color, int tamano) {
        data = new Association<>(ing, espa);
        parent = null; 
        left = right = null;
        this.tamano = tamano;
        this.color = color;
    }
    /**
     * devuleve la key del data
     * @return  key de data
     */
    public String getKey(){
        return data.getKey(); //devuelve la palabra en ingles
    }
    /**
     * devuelve el valor de dato
     * @return valor de dato
     */
    public String getEspa(){
        return data.elValue;
    }
    /**
     * pone valor al nodo izquierdo
     * @param left nodo a ingresarle
     */
    public void setLeft(Node left){
        this.left = left;
    }
    /**
     * devuelve el nodo izquierdo
     * @return nodo izquierdo
     */
    public Node<E> getLeft()
    {
        return left;
    } 
    /**
     * pone el valor del nodo derecho
     * @param right nodo derecho
     */
    public void setRight(Node right){
        this.right = right;
    }
    /**
     * devuleve el valor del nodo derecho
     * @return devuelve el nodo derecho
     */
    public Node<E> getRight(){
        return right;
    }
    /**
     * nos devuelve el en texto la info de data
     * @return info de data
     */
    public String toString(){
       String linea = "\t("+ data.laKey + ", " + data.elValue + ")";
       return linea;
    }
    /**
     * pone valro al padre
     * @param nuevoParent valor de padre
     */
    public void setParent(Node nuevoParent){
            parent = nuevoParent;
    }
    /**
     * devuelve valor del nodo padre
     * @return nodo padre
     */
    public Node<E> getParent(){
        return parent;
    }
}
